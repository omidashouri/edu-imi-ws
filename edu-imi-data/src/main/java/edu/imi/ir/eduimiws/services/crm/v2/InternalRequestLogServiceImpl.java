package edu.imi.ir.eduimiws.services.crm.v2;

import edu.imi.ir.eduimiws.domain.crm.BusinessOperationEntity;
import edu.imi.ir.eduimiws.domain.crm.InternalRequestLogEntity;
import edu.imi.ir.eduimiws.domain.crm.InternalResponseLogEntity;
import edu.imi.ir.eduimiws.exceptions.v2.BusinessException;
import edu.imi.ir.eduimiws.exceptions.v2.ConflictException;
import edu.imi.ir.eduimiws.exceptions.v2.ErrorEnum;
import edu.imi.ir.eduimiws.mapper.crm.v2.InternalRequestLogMapper;
import edu.imi.ir.eduimiws.models.dto.record.v2.InternalRequestResponseLogData;
import edu.imi.ir.eduimiws.models.request.crm.v2.InternalRequestFilterDto;
import edu.imi.ir.eduimiws.models.response.crm.v2.InternalResponseFilterDto;
import edu.imi.ir.eduimiws.models.response.crm.v2.InternalResponseInquiryDto;
import edu.imi.ir.eduimiws.repositories.crm.BusinessOperationRepository;
import edu.imi.ir.eduimiws.repositories.crm.InternalRequestLogRepository;
import edu.imi.ir.eduimiws.repositories.crm.InternalResponseLogRepository;
import edu.imi.ir.eduimiws.spec.crm.v2.InternalRequestLogSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class InternalRequestLogServiceImpl implements InternalRequestLogService {

    private static final Long ACTIVE = 1L;

    private final InternalRequestLogRepository internalRequestLogRepository;
    private final InternalResponseLogRepository internalResponseLogRepository;
    private final BusinessOperationRepository businessOperationRepository;
    private final InternalRequestLogMapper internalRequestLogMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Long claimRequest(InternalRequestResponseLogData data) {
        log.info("Claiming idempotency requestId={} for operation={}",
                data.requestId(), data.businessOperationName());
        BusinessOperationEntity businessOperation = businessOperationRepository
                .findByOperationNameAndIsActive(data.businessOperationName(), ACTIVE)
                .orElseThrow(() -> new BusinessException(ErrorEnum.RECORD_NOT_FOUND));

        InternalRequestLogEntity requestLog = internalRequestLogMapper.toRequestLog(data, businessOperation);
        try {
            requestLog = internalRequestLogRepository.saveAndFlush(requestLog);
            return requestLog.getId();
        } catch (DataIntegrityViolationException e) {
            log.warn("Rejecting duplicate requestId {}: UK_INTERNAL_REQUEST_LOG_REQUEST_ID violated",
                    data.requestId());
            throw new ConflictException(ErrorEnum.REQUEST_ID_DUPLICATE_SUCCESS);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logResponse(Long requestLogId, int responseStatus, String responseJson) {
        log.info("Persisting internal response log for claim id={}, status={}", requestLogId, responseStatus);
        InternalRequestLogEntity requestLog = internalRequestLogRepository.findById(requestLogId)
                .orElseThrow(() -> new BusinessException(ErrorEnum.RECORD_NOT_FOUND));

        InternalResponseLogEntity responseLog = internalRequestLogMapper.toResponseLog(
                requestLog, responseStatus, responseJson);
        internalResponseLogRepository.save(responseLog);
    }

    @Override
    @Transactional(readOnly = true)
    public InternalResponseInquiryDto findByRequestId(String requestId) {
        log.info("Looking up internal response for requestId={}", requestId);
        InternalRequestLogEntity requestLog = internalRequestLogRepository.findByRequestId(requestId)
                .orElseThrow(() -> new BusinessException(ErrorEnum.INTERNAL_REQUEST_RESPONSE_NOT_FOUND));
        InternalResponseLogEntity responseLog = internalResponseLogRepository
                .findByInternalRequestLog_Id(requestLog.getId())
                .orElseThrow(() -> new BusinessException(ErrorEnum.INTERNAL_REQUEST_RESPONSE_NOT_FOUND));
        return internalRequestLogMapper.toResponseDto(requestLog, responseLog);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InternalResponseFilterDto> filter(InternalRequestFilterDto requestDto, Pageable pageable) {
        log.info("Filtering internal request logs with optional criteria");
        Page<InternalRequestLogEntity> page = internalRequestLogRepository.findAll(
                InternalRequestLogSpec.getSpec(requestDto), pageable);
        if (page.isEmpty()) {
            return Page.empty(pageable);
        }
        List<Long> requestIds = page.getContent().stream()
                .map(InternalRequestLogEntity::getId)
                .toList();
        Map<Long, InternalResponseLogEntity> responsesByRequestId = internalResponseLogRepository
                .findByInternalRequestLog_IdIn(requestIds).stream()
                .collect(Collectors.toMap(
                        response -> response.getInternalRequestLog().getId(),
                        Function.identity(),
                        (left, right) -> left));
        return page.map(requestLog -> internalRequestLogMapper.toFilterDto(
                requestLog, responsesByRequestId.get(requestLog.getId())));
    }
}

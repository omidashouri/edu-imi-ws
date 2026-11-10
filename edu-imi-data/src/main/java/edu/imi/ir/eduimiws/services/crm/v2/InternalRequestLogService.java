package edu.imi.ir.eduimiws.services.crm.v2;

import edu.imi.ir.eduimiws.models.dto.record.v2.InternalRequestResponseLogData;
import edu.imi.ir.eduimiws.models.request.crm.v2.InternalRequestFilterDto;
import edu.imi.ir.eduimiws.models.response.crm.v2.InternalResponseFilterDto;
import edu.imi.ir.eduimiws.models.response.crm.v2.InternalResponseInquiryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InternalRequestLogService {

    Long claimRequest(InternalRequestResponseLogData data);

    void logResponse(Long requestLogId, int responseStatus, String responseJson);

    InternalResponseInquiryDto findByRequestId(String requestId);

    Page<InternalResponseFilterDto> filter(InternalRequestFilterDto requestDto, Pageable pageable);
}

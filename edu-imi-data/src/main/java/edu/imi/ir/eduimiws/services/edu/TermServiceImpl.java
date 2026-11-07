package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.TermEntity;
import edu.imi.ir.eduimiws.repositories.edu.TermRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TermServiceImpl implements TermService {

    private final TermRepository termRepository;

    @Override
    public Page<TermEntity> findAllByOrderPageable(Pageable pageable) {
        log.info("TermService.findAllByOrderPageable - pageable: {}", pageable);
        Page<TermEntity> result = termRepository
                .findAllBy(pageable);
        log.info("TermService.findAllByOrderPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public TermEntity findByTermPublicId(String termPublicId) {
        log.info("TermService.findByTermPublicId - termPublicId: {}", termPublicId);
        TermEntity result = termRepository
                .findByTermApi_TermPublicId(termPublicId);
        log.info("TermService.findByTermPublicId - result: {}", result);
        return result;
    }
}

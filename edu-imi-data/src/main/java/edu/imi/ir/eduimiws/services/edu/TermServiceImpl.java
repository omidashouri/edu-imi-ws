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
        Page<TermEntity> termPages = termRepository
                .findAllBy(pageable);
        return termPages;
    }

    @Override
    public TermEntity findByTermPublicId(String termPublicId) {
        TermEntity term = termRepository
                .findByTermApi_TermPublicId(termPublicId);
        return term;
    }
}

package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.TermEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TermService {

    Page<TermEntity> findAllByOrderPageable(Pageable pageable);

    TermEntity findByTermPublicId(String termPublicId);
}

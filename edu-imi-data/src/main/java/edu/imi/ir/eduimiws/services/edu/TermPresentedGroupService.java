package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.TermPresentedGroupEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TermPresentedGroupService {

    Page<TermPresentedGroupEntity> findAllByOrderPageable(Pageable pageable);

    TermPresentedGroupEntity findByTermPresentedGroupPublicId(String termPresentedGroupPublicId);
}

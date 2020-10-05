package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.ProfessorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfessorService {

    Page<ProfessorEntity> findAllByPageable(Pageable pageable);

    ProfessorEntity findByProfessorPublicId(String professorPublicId);
}

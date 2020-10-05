package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.ProfessorEntity;
import edu.imi.ir.eduimiws.repositories.edu.ProfessorRepository;
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
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public Page<ProfessorEntity> findAllByPageable(Pageable pageable) {
        Page<ProfessorEntity> professorPages = professorRepository
                .findAllBy(pageable);
        return professorPages;
    }

    @Override
    public ProfessorEntity findByProfessorPublicId(String professorPublicId) {
        ProfessorEntity professor = professorRepository
                .findByProfessorApi_ProfessorPublicId(professorPublicId);
        return professor;
    }
}

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
        log.info("ProfessorService.findAllByPageable - pageable: {}", pageable);
        Page<ProfessorEntity> result = professorRepository
                .findAllBy(pageable);
        log.info("ProfessorService.findAllByPageable - resultSize: {}, totalElements: {}",
                result == null ? null : result.getNumberOfElements(),
                result == null ? null : result.getTotalElements());
        return result;
    }

    @Override
    public ProfessorEntity findByProfessorPublicId(String professorPublicId) {
        log.info("ProfessorService.findByProfessorPublicId - professorPublicId: {}", professorPublicId);
        ProfessorEntity result = professorRepository
                .findByProfessorApi_ProfessorPublicId(professorPublicId);
        log.info("ProfessorService.findByProfessorPublicId - result: {}", result);
        return result;
    }
}

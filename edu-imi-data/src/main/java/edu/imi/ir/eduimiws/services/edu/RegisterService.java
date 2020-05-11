package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegisterService {

    Long countRegisterByIdLessThanEqual(Long registerId);

    RegisterEntity selectLastRecord();

    Page<RegisterEntity> findAllByOrderByCreateDateDesc (Pageable pageable);

    RegisterEntity findByRegisterPublicIdOrderByCreateDateDesc(String registerPublicId);

    List<RegisterEntity> findAllRegisterOnlyByIdBetween(Long startId, Long endId);

    List<RegisterEntity> selectAllRegisterOnly();

    RegisterEntity findFirstByIdLessThanOrderByIdDesc(Long registerId);

    Long selectRegisterLastSequenceNumber();
}

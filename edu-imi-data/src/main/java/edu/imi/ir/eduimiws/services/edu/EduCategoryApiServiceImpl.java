package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.EduCategoryApiEntity;
import edu.imi.ir.eduimiws.domain.edu.EduCategoryEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.EduCategoryApiEduCategoryEntityHandlePublicIdMapper;
import edu.imi.ir.eduimiws.repositories.edu.EduCategoryApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EduCategoryApiServiceImpl implements EduCategoryApiService{

    private final EduCategoryApiRepository eduCategoryApiRepository;
    private final EduCategoryApiEduCategoryEntityHandlePublicIdMapper eduCategoryApiEduCategoryEntityHandlePublicIdMapper;

    @Override
    public EduCategoryApiEntity selectLastRecord() {
        log.info("EduCategoryApiService.selectLastRecord - start");
        EduCategoryApiEntity result = eduCategoryApiRepository.findFirstByOrderByIdDesc();
        log.info("EduCategoryApiService.selectLastRecord - result: {}", result);
        return result;
    }

    @Override
    public Long eduCategoryApiCount() {
        log.info("EduCategoryApiService.eduCategoryApiCount - start");
        Long result = eduCategoryApiRepository.count();
        log.info("EduCategoryApiService.eduCategoryApiCount - result: {}", result);
        return result;
    }

    @Override
    public List<EduCategoryApiEntity> generateEduCategoryApiPublicId(List<EduCategoryEntity> newEduCategories) {
        log.info("EduCategoryApiService.generateEduCategoryApiPublicId - newEduCategories: {}", newEduCategories);
        List<EduCategoryApiEntity> newEduCategoryApis = new ArrayList<>();
        newEduCategoryApis = eduCategoryApiEduCategoryEntityHandlePublicIdMapper
                .toEduCategoryApis(newEduCategories, new CycleAvoidingMappingContext());
        newEduCategoryApis.sort(Comparator.comparing(EduCategoryApiEntity::getEduCategoryId));
        eduCategoryApiRepository.saveAll(newEduCategoryApis);
        log.info("EduCategoryApiService.generateEduCategoryApiPublicId - resultSize: {}", newEduCategoryApis == null ? null : newEduCategoryApis.size());
        return newEduCategoryApis;
    }

    @Override
    public List<EduCategoryApiEntity> findAllByEduCategoryIdIn(List<Long> eduCategoryIds) {
        log.info("EduCategoryApiService.findAllByEduCategoryIdIn - eduCategoryIds: {}", eduCategoryIds);
        List<EduCategoryApiEntity> result = eduCategoryApiRepository
                .findAllByEduCategoryIdIn(eduCategoryIds);
        log.info("EduCategoryApiService.findAllByEduCategoryIdIn - resultSize: {}", result == null ? null : result.size());
        return result;
    }
}

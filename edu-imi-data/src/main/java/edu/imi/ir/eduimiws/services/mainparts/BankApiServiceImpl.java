package edu.imi.ir.eduimiws.services.mainparts;


import edu.imi.ir.eduimiws.domain.mainparts.BankApiEntity;
import edu.imi.ir.eduimiws.exceptions.controllers.NotFoundException;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import edu.imi.ir.eduimiws.mapper.mainparts.BankApiMapper;
import edu.imi.ir.eduimiws.models.dto.mainparts.BankApiDto;
import edu.imi.ir.eduimiws.repositories.mainparts.BankApiRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BankApiServiceImpl implements BankApiService{


    private final BankApiRepository bankApiRepository;
    private final BankApiMapper bankApiManager;

    @Override
    public BankApiEntity findByBankPublicId(String bankPublicId) {
        log.info("BankApiService.findByBankPublicId - bankPublicId: {}", bankPublicId);
        BankApiEntity result = bankApiRepository.findByBankPublicId(bankPublicId);
        log.info("BankApiService.findByBankPublicId - result: {}", result);
        return result;
    }

    @Override
    public BankApiDto findBankDtoByBankPublicId(String bankPublicId) {
        log.info("BankApiService.findBankDtoByBankPublicId - bankPublicId: {}", bankPublicId);
        BankApiDto bankApiDto =  bankApiManager
                .toBankApiDto(this.findByBankPublicId(bankPublicId),new CycleAvoidingMappingContext());
        if(bankApiDto==null){
            throw new NotFoundException("bank Not Found");
        }else {
            log.info("BankApiService.findBankDtoByBankPublicId - result: {}", bankApiDto);
            return bankApiDto;
        }
    }



}

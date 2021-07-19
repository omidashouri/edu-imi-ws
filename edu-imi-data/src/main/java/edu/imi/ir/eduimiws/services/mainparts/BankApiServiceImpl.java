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
import net.bytebuddy.implementation.bytecode.Throw;
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
        return bankApiRepository.findByBankPublicId(bankPublicId);
    }

    @Override
    public BankApiDto findBankDtoByBankPublicId(String bankPublicId) {
        BankApiDto bankApiDto =  bankApiManager
                .toBankApiDto(this.findByBankPublicId(bankPublicId),new CycleAvoidingMappingContext());
        if(bankApiDto==null){
            throw new NotFoundException("bank Not Found");
        }else {
            return bankApiDto;
        }
    }



}

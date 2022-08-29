package edu.imi.ir.eduimiws.services.mainparts;


/*import edu.imi.ir.eduimiws.exceptions.services.behdad.InvalidCredentialException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.InvalidIdentifierException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.PasswordIsNotStrongException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.UnableToAuthenticateException;
import edu.imi.ir.eduimiws.exceptions.services.behdad.UserTemporarilySuspendedException;
import edu.imi.ir.eduimiws.mapper.mainparts.behdad.identifier.*;
import edu.imi.ir.eduimiws.models.behdad.identifier.*;
import edu.imi.ir.eduimiws.models.dto.mainparts.behdad.identifier.*;*/

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
//@Transactional
@RequiredArgsConstructor
@Slf4j
public class BehdadIdentifierServiceImpl implements BehdadIdentifierService {

  /*  private final IdentifierService identifierServiceBehdad;
    private final Credential credentialIdentifier;
    private final IsVerhoeffRequestMapper isVerhoeffRequestMapper;
    private final BatchIdentifierInfoMapper batchIdentifierInfoMapper;
    private final IdentifierInfoMapper identifierInfoMapper;
    private final IdentifierResultMapper identifierResultMapper;
    private final GenerateIdentifierByOrganRequestMapper generateIdentifierByOrganRequestMapper;
    private final BatchIdentifierRemoveInfoMapper batchIdentifierRemoveInfoMapper;
    private final IdentifierRemoveResultMapper identifierRemoveResultMapper;
    private final IdentifierDetailMapper identifierDetailMapper;

    @Override
    public Boolean isVerhoeff(IsVerhoeffRequestDto isVerhoeffRequestDto) {

        Boolean verhoeff;
        IsVerhoeffRequest isVerhoeffRequest = isVerhoeffRequestMapper.toIsVerhoeffRequest(isVerhoeffRequestDto);
        try {
            verhoeff = identifierServiceBehdad.isVerhoeff(credentialIdentifier, isVerhoeffRequest);
        } catch (InvalidIdentifierException_Exception e) {
            throw new InvalidIdentifierException();
        } catch (InvalidCredentialException_Exception e) {
            throw new InvalidCredentialException();
        } catch (UnableToAuthenticateException_Exception e) {
            throw new UnableToAuthenticateException();
        } catch (PasswordIsNotStrongException_Exception e) {
            throw new PasswordIsNotStrongException();
        } catch (UserTemporarilySuspendedException_Exception e) {
            throw new UserTemporarilySuspendedException();
        }
        return verhoeff;
    }

    @Override
    public Boolean isValidIdentifier(String identifierCode, String accountNumber, BigDecimal transactionAmount) {
        Boolean validIdentifier = null;
        try {
            validIdentifier = identifierServiceBehdad.isValidIdentifier(credentialIdentifier, identifierCode, accountNumber, transactionAmount);
        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (InvalidIdentifierException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (InvalidAmountException_Exception e) {
            e.printStackTrace();
        } catch (IdentifierNotFoundException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        } catch (VerhoeffException_Exception e) {
            e.printStackTrace();
        } catch (IdentifierIsNotEffectiveException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        }
        return validIdentifier;
    }

    @Override
    public Boolean isEffectiveIdentifier(String identifierCode, String accountNumber) {
        Boolean effectiveIdentifier = null;
        try {
            effectiveIdentifier = identifierServiceBehdad.isEffectiveIdentifier(credentialIdentifier, identifierCode, accountNumber);
        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (IdentifierNotFoundException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        }
        return effectiveIdentifier;
    }

    @Override
    public Boolean isExistIdentifier(String identifierCde, String accountNumber) {
        Boolean existIdentifier = null;
        try {
            existIdentifier = identifierServiceBehdad.isExistIdentifier(credentialIdentifier, identifierCde, accountNumber);
        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        }
        return existIdentifier;
    }

    @Override
    public void addIdentifier(IdentifierInfoDto identifierInfoDto) {
        IdentifierInfo identifierInfo = identifierInfoMapper.toIdentifierInfo(identifierInfoDto);
        try {
            identifierServiceBehdad.addIdentifier(credentialIdentifier, identifierInfo);
        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (InvalidAmountException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (InvalidAccountNumberException_Exception e) {
            e.printStackTrace();
        } catch (IdentifierIsExistException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        } catch (InvalidDateException_Exception e) {
            e.printStackTrace();
        } catch (InvalidIdentifierCodeException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<IdentifierResultDto> addIdentifiers(BatchIdentifierInfoDto batchIdentifierInfoDto) {
        List<IdentifierResultDto> identifierResultsDtos = null;
        BatchIdentifierInfo batchIdentifierInfo = batchIdentifierInfoMapper.toBatchIdentifierInfo(batchIdentifierInfoDto);
        try {
            List<IdentifierResult> identifierResults = identifierServiceBehdad.addIdentifiers(credentialIdentifier, batchIdentifierInfo);
            identifierResultsDtos = identifierResultMapper.toIdentifierResultDtos(identifierResults);

        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        }
        return identifierResultsDtos;
    }

    @Override
    public String generateIdentifierByOrganInfo(GenerateIdentifierByOrganRequestDto generateIdentifierByOrganRequestDto) {
        String value = null;
        GenerateIdentifierByOrganRequest generateIdentifierByOrganRequest = generateIdentifierByOrganRequestMapper
                .toGenerateIdentifierByOrganRequest(generateIdentifierByOrganRequestDto);
        try {
            value = identifierServiceBehdad.generateIdentifierByOrganInfo(credentialIdentifier, generateIdentifierByOrganRequest);
        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (UnableToGenerateIdentifierException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        } catch (InvalidAllotmentItemInfoException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public void removeIdentifier(String identifierCode, String accountNumber) {
        try {
            identifierServiceBehdad.removeIdentifier(credentialIdentifier, identifierCode, accountNumber);
        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (IdentifierNotFoundException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<IdentifierRemoveResultDto> removeIdentifiers(BatchIdentifierRemoveInfoDto batchIdentifierRemoveInfoDto) {
        List<IdentifierRemoveResultDto> identifierRemoveResultDtos = null;
        final BatchIdentifierRemoveInfo batchIdentifierRemoveInfo = batchIdentifierRemoveInfoMapper
                .toBatchIdentifierRemoveInfo(batchIdentifierRemoveInfoDto);
        try {
            List<IdentifierRemoveResult> identifierRemoveResults = identifierServiceBehdad
                    .removeIdentifiers(credentialIdentifier, batchIdentifierRemoveInfo);
            identifierRemoveResultDtos = identifierRemoveResultMapper
                    .toIdentifierRemoveResultDtos(identifierRemoveResults);
        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        }

        return identifierRemoveResultDtos;
    }

    @Override
    public List<IdentifierDetailDto> getActiveIdentifiers(String accountNumber, String startShamsiDate, String endShamsiDate) {
        List<IdentifierDetailDto> identifierDetailDtos = null;
        try {
            List<IdentifierDetail> identifierDetails = identifierServiceBehdad
                    .getActiveIdentifiers(credentialIdentifier, accountNumber, startShamsiDate, endShamsiDate);
            identifierDetailDtos = identifierDetailMapper.toIdentifierDetailDtos(identifierDetails);
        } catch (InvalidCredentialException_Exception e) {
            e.printStackTrace();
        } catch (UnableToAuthenticateException_Exception e) {
            e.printStackTrace();
        } catch (PasswordIsNotStrongException_Exception e) {
            e.printStackTrace();
        } catch (UserTemporarilySuspendedException_Exception e) {
            e.printStackTrace();
        }
        return identifierDetailDtos;
    }*/
}

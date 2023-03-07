package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.edu.PeriodCertificateSmsApiDtoFarapayamakSendSmsDtoMapper;
import edu.imi.ir.eduimiws.mapper.edu.PeriodCertificateSmsApiProjectionMapper;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakReturnedSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.FarapayamakSendSmsDto;
import edu.imi.ir.eduimiws.models.dto.edu.PeriodCertificateSmsApiDto;
import edu.imi.ir.eduimiws.models.helper.DefaultValues;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodCertificateSmsApiProjection;
import edu.imi.ir.eduimiws.repositories.edu.PeriodCertificateSmsApiRepository;
import edu.imi.ir.eduimiws.security.FarapayamakCredential;
import edu.imi.ir.eduimiws.services.crm.FarapayamakService;
import edu.imi.ir.eduimiws.utilities.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PeriodCertificateSmsApiServiceImpl implements PeriodCertificateSmsApiService {

    private final PeriodCertificateSmsApiRepository periodCertificateSmsApiRepository;

    private final PeriodCertificateSmsApiProjectionMapper periodCertificateSmsApiProjectionMapper;
    private final PeriodCertificateSmsApiDtoFarapayamakSendSmsDtoMapper periodCertificateSmsApiDtoFarapayamakSendSmsDtoMapper;
    private final FarapayamakService farapayamakService;
    private final FarapayamakCredential farapayamakCredential;

    private final CommonUtils commonUtils;
    private final DefaultValues defaultValues;


    @Override
    public List<PeriodCertificateSmsApiDto> queryByPeriodCertificateSmsApi(Long periodCertificateActivityStatus,
                                                                           String registerFinalStatus,
                                                                           String registerType,
                                                                           Long registerFinancialStatus) {
        List<PeriodCertificateSmsApiProjection> periodCertificateSmsApiProjections = periodCertificateSmsApiRepository
                .queryByPeriodCertificateSmsApi(periodCertificateActivityStatus,
                        registerFinalStatus,
                        registerType,
                        registerFinancialStatus);

        List<PeriodCertificateSmsApiDto> periodCertificateSmsApiDtos =
                periodCertificateSmsApiProjectionMapper
                        .toPeriodCertificateSmsApiProjectionDtos(periodCertificateSmsApiProjections, new CycleAvoidingMappingContext()
                        );
        // return periodCertificateSmsApiDtos;
//         >>>>>>>>>>for Test
        PeriodCertificateSmsApiDto test = new PeriodCertificateSmsApiDto();
        test.setPhone("09101090511");
        test.setFullName("دلارام شریفی");
        List<PeriodCertificateSmsApiDto> listTest = Arrays.asList(test);
        //return listTest;

        Map<String, List<PeriodCertificateSmsApiDto>> mapPeriodCertificateSmsApiDtoByRegisterType =
                this.mapPeriodCertificateSmsApiByRegisterType(periodCertificateSmsApiDtos);

        List<PeriodCertificateSmsApiDto> personals = mapPeriodCertificateSmsApiDtoByRegisterType.get("0");

        /*  List<PeriodCertificateSmsApiDto> companies = mapPeriodCertificateSmsApiDtoByRegisterType.get("1");*/
//        todo: use id for specifying who had received the sms


        List<String> personalPhones = personals.stream()
                .map(PeriodCertificateSmsApiDto::getPhone)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

      /* List<String> companyPhones = companies.stream()
                .map(PeriodCertificateSmsApiDto ::getPhone)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());*/

        Collection<List<String>> collectionListPersonalPhones = commonUtils.partitionBasedOnSize(personalPhones, 99);
        List<List<String>> listListPersonalPhones = commonUtils.convertCollectionListToListList(collectionListPersonalPhones);

        List<FarapayamakReturnedSendSmsDto> farapayamakReturnedSendSmsDtos = new ArrayList<>();

        listListPersonalPhones.forEach(listPersonalPhones -> {
            String commaSeperatedPersonalPhones = commonUtils.listStringToCommaSeparatorString(personalPhones);
            FarapayamakSendSmsDto farapayamakSendSmsDtoPersonal = new FarapayamakSendSmsDto();
            farapayamakSendSmsDtoPersonal.setTo(commaSeperatedPersonalPhones);
            farapayamakSendSmsDtoPersonal.setText(defaultValues.getCertificateDeliverySmsPersonalText());
            FarapayamakReturnedSendSmsDto farapayamakReturnedSendSmsDto = farapayamakService
                    .sendSMS(farapayamakSendSmsDtoPersonal);
            farapayamakReturnedSendSmsDtos.add(farapayamakReturnedSendSmsDto);
        });

        return periodCertificateSmsApiProjectionMapper
                .toPeriodCertificateSmsApiProjectionDtos(periodCertificateSmsApiProjections, new CycleAvoidingMappingContext());
    }

    @Override
    public Map<String, List<PeriodCertificateSmsApiDto>> mapPeriodCertificateSmsApiByRegisterType
            (List<PeriodCertificateSmsApiDto> periodCertificateSmsApiDtos) {
        Map<String, List<PeriodCertificateSmsApiDto>> mapPeriodCertificateSmsApiDtoByRegisterType = periodCertificateSmsApiDtos
                .stream()
                .filter(pcs -> Objects.nonNull(pcs.getRegisterType()))
                .collect(Collectors.groupingBy(
                        PeriodCertificateSmsApiDto::getRegisterType,
                        Collectors.mapping(Function.identity(),
                                Collectors.toList())));
        return mapPeriodCertificateSmsApiDtoByRegisterType;
    }

    @Override
    public List<FarapayamakSendSmsDto> findPeriodCertificateReadyToSendByPcsaId(List<Long> periodCertificateSmsApiIds) {
        return null;
    }

    @Override
    public List<FarapayamakSendSmsDto> periodCertificateSendSmsApiToPersonalStudent(List<PeriodCertificateSmsApiDto> periodCertificateSmsApiDtos) {
        return null;
    }


 /*   @Override
    public List<FarapayamakSendSmsDto> findPeriodCertificateReadyToSendByPcsaId(List<Long> periodCertificateSmsApiIds) {
        List<PeriodCertificateSmsApiProjection> PeriodCertificateSmsApiProjections = periodCertificateSmsApiRepository
                .queryByPeriodCertificateSmsApi(null, null, null);
        return PeriodCertificateSmsApiProjections
        this.map(periodCertificateSmsApiDtoFarapayamakSendSmsDtoMapper::periodCertificateSmsApiDtoToFarapayamakSendSmsDto);
    }*/

/*    @Override
    public List<FarapayamakSendSmsDto> periodCertificateSendSmsApiToPersonalStudent(List<PeriodCertificateSmsApiDto> periodCertificateSmsApiDtos) {

       List<FarapayamakSendSmsDto>farapayamakPeriodCertificateSendSmsDtos = new ArrayList<>();
       List<FarapayamakSendSmsDto>farapayamakPeriodCertificateSendSmsDtos = periodCertificateSmsApiDtoFarapayamakSendSmsDtoMapper
                .periodCertificateSmsApiDtoToFarapayamakSendSmsDto(List<PeriodCertificateSmsApiDto>periodCertificateSmsApiDtos, new CycleAvoidingMappingContext());

       return null;*/


   /* public Map<String, List<FarapayamakSendSmsDto>> mapSendSmsToPersonalStudent
            (List<FarapayamakSendSmsDto>farapayamakSendSmsDtos){
        Map<String, List<FarapayamakSendSmsDto>> mapSendSmsToPersonalStudent = farapayamakSendSmsDtos
                .stream()

    }*/


//        todo: update status table periodcertificatesmsapi

      
}
package edu.imi.ir.eduimiws.services.attendance;


import edu.imi.ir.eduimiws.mapper.attendance.VacationRegistrationDataModelMapper;
import edu.imi.ir.eduimiws.models.response.attendance.response.VacationRegistrationDataModelResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.ArrayOfVacationRegistrationDataModel;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderService;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderServiceSoap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacationRegistrationDataModelEtsServiceImpl implements VacationRegistrationDataModelEtsService {

    private final EtsGeneralDataProviderService etsGeneralDataProviderService;
    private final VacationRegistrationDataModelMapper vacationRegistrationDataModelMapper;


    @Override
    public List<VacationRegistrationDataModelResponse> getAllVacationRegistrationFromApiByDate(String jalaliDate) {

        ArrayOfVacationRegistrationDataModel allVacationRegistrationDataModel = getEtsSoapService().getAllVacationRegistrationsByDate(jalaliDate);
        List<VacationRegistrationDataModelResponse> vacationRegistrationDataModelResponses = allVacationRegistrationDataModel.getVacationRegistrationDataModel()
                .stream().map(vacationRegistrationDataModelMapper::fromVacationRegistrationDataModel)
                .map(vacationRegistrationDataModelMapper::toVacationRegistrationDataModelResponse)
                .collect(Collectors.toList());
        return vacationRegistrationDataModelResponses;
    }

    private EtsGeneralDataProviderServiceSoap getEtsSoapService() {
        return etsGeneralDataProviderService.getEtsGeneralDataProviderServiceSoap();
    }
}


package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.mapper.attendance.MissionRegistrationDataModelMapper;
import edu.imi.ir.eduimiws.models.response.attendance.response.MissionRegistrationDataModelResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.ArrayOfMissionRegistrationDataModel;
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
public class MissionRegistrationDataModelEtsServiceImpl implements MissionRegistrationDataModelEtsService {

    private final EtsGeneralDataProviderService etsGeneralDataProviderService;
    private final MissionRegistrationDataModelMapper missionRegistrationDataModelMapper;


    @Override
    public List<MissionRegistrationDataModelResponse> getAllMissonRegistrationFromApiByDate(String jalaliDate) {

        ArrayOfMissionRegistrationDataModel allMissionRegistrationDataModel = getEtsSoapService().getAllMissionRegistrationsByDate(jalaliDate);
        List<MissionRegistrationDataModelResponse> missionRegistrationDataModelResponses = allMissionRegistrationDataModel.getMissionRegistrationDataModel()
                .stream().map(missionRegistrationDataModelMapper::fromMissionRegistrationDataModel)
                .map(missionRegistrationDataModelMapper::toMissionRegistrationDataModelResponse)
                .collect(Collectors.toList());
        return missionRegistrationDataModelResponses;
    }

    private EtsGeneralDataProviderServiceSoap getEtsSoapService() {
        return etsGeneralDataProviderService.getEtsGeneralDataProviderServiceSoap();
    }
}

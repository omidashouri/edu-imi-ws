package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.mapper.attendance.IoRecordDataModelDtoMapper;
import edu.imi.ir.eduimiws.models.response.attendance.response.IoRecordDataModelResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.ArrayOfIoRecordDataModel;
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
public class IoRecordDataModelEtsServiceImpl implements IoRecordDataModelEtsService {

    private final EtsGeneralDataProviderService etsGeneralDataProviderService;
    private final IoRecordDataModelDtoMapper ioRecordDataModelDtoMapper;

    @Override
    public List<IoRecordDataModelResponse> getAllIoRecordsFromApiByDate(String jalaliDate) {
        ArrayOfIoRecordDataModel allIoRecordDataModel = getEtsSoapService().getAllIoRecordsByDate(jalaliDate);
        List<IoRecordDataModelResponse> ioRecordDataModelResponses =  allIoRecordDataModel.getIoRecordDataModel()
                .stream().map(ioRecordDataModelDtoMapper::fromIoRecordDataModel)
                .map(ioRecordDataModelDtoMapper::toIoRecordDataModelResponse)
                .collect(Collectors.toList());
        return ioRecordDataModelResponses;
    }

    private EtsGeneralDataProviderServiceSoap getEtsSoapService() {
        return etsGeneralDataProviderService.getEtsGeneralDataProviderServiceSoap();
    }
}

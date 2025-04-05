package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderService;
import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderServiceSoap;
import edu.imi.ir.eduimiws.utilities.DateConvertor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FunctionalityListServiceImpl implements FunctionalityListService{

    private final EtsGeneralDataProviderService etsGeneralDataProviderService;
    private final DateConvertor dateConvertor;


    @Override
    public List<String> getFunctionalityList(String employeeCode, LocalDateTime fromDate, LocalDateTime toDate) {
        return getEtsSoapService().getFunctionalityList(employeeCode,
                dateConvertor.localDateTimeToXMLGregorianCalendar(fromDate),
                dateConvertor.localDateTimeToXMLGregorianCalendar(toDate))
                .getString();
    }


    private EtsGeneralDataProviderServiceSoap getEtsSoapService() {
        return etsGeneralDataProviderService.getEtsGeneralDataProviderServiceSoap();
    }
}

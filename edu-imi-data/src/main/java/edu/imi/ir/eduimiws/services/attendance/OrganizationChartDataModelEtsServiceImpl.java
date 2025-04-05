package edu.imi.ir.eduimiws.services.attendance;

import edu.imi.ir.eduimiws.mapper.attendance.OrganizationChartDataModelMapper;
import edu.imi.ir.eduimiws.models.response.attendance.response.OrganizationChartDataModelResponse;
import edu.imi.ir.eduimiws.models.wsdl.attendance.ArrayOfOrganizationChartDataModel;
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
public class OrganizationChartDataModelEtsServiceImpl implements OrganizationChartDataModelEtsService {

    private final EtsGeneralDataProviderService etsGeneralDataProviderService;
    private final OrganizationChartDataModelMapper organizationChartDataModelMapper;

    @Override
    public List<OrganizationChartDataModelResponse> getAllOrganizationChart() {

        ArrayOfOrganizationChartDataModel allOrganizationChartDataModel = getEtsSoapService().getAllOrganizationChartList();
        List<OrganizationChartDataModelResponse> organizationChartDataModelResponses = allOrganizationChartDataModel.getOrganizationChartDataModel()
                .stream().map(organizationChartDataModelMapper::fromOrganizationChartDataModel)
                .map(organizationChartDataModelMapper::toOrganizationChartDataModelResponse)
                .collect(Collectors.toList());
        return organizationChartDataModelResponses;
    }

    private EtsGeneralDataProviderServiceSoap getEtsSoapService() {
        return etsGeneralDataProviderService.getEtsGeneralDataProviderServiceSoap();
    }
}


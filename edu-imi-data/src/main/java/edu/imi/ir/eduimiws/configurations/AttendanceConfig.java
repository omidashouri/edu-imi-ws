package edu.imi.ir.eduimiws.configurations;

import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AttendanceConfig {

    @Bean
    EtsGeneralDataProviderService etsGeneralDataProviderService(){
        return new EtsGeneralDataProviderService();
    }
}

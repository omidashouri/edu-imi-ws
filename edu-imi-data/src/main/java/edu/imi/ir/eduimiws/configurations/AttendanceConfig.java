package edu.imi.ir.eduimiws.configurations;

import edu.imi.ir.eduimiws.models.wsdl.attendance.EtsGeneralDataProviderService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "attendance.ws.enabled", havingValue = "true", matchIfMissing = true)
public class AttendanceConfig {

    @Bean
    EtsGeneralDataProviderService etsGeneralDataProviderService() {
        return new EtsGeneralDataProviderService();
    }
}

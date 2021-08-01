package edu.imi.ir.eduimiws.utilities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActuatorInfoContributor //implements InfoContributor, HealthIndicator
{

/*    private final Environment environment;

    Map<String, Object> props = new HashMap<>();

    @Override
    public void contribute(Info.Builder builder) {
        System
                .getProperties()
                .forEach((k, v) -> props.put(String.valueOf(k), v));
        props.put("info.app.name", "IMI Web Service API");
        props.put("info.app.description", "This is a Restful Web Api");
        props.put("info.app.version", "1.0.0");
        props.put("Developer Name", "Omid Ashouri");
        props.put("Developer Contact Information", "+9809126607350");
        builder.withDetails(props);
    }


    @Override
    public Health health() {

        Status systemStatus = new Status("Server Status", "this status is defined by omid ashouri");

        Map<String, Object> details = new HashMap<>();
        details.put("system-ready", true);
        details.put("can-accept-request", true);

        return Health
                .status(systemStatus).withDetails(details)
                .build();
    }*/

//    an oder way to register a bean
/*    @Bean
    public HealthIndicator paymentServerStatus(){
        return () -> Health.status("Payment Server")
                .withDetail("system-ready",false)
                .build();
    }*/


}

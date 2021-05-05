package edu.imi.ir.eduimiws.utilities;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ActuatorInfoContributor implements InfoContributor {

    private final Environment environment;

    Map<String, Object> props = new HashMap<>();

    @Override
    public void contribute(Info.Builder builder) {
        System
                .getProperties()
                .forEach((k, v) -> props.put(String.valueOf(k), v));
        props.put("info.app.name","IMI Web Service API");
        props.put("info.app.description","This is a Restful Web Api");
        props.put("info.app.version","1.0.0");
        props.put("Developer Name","Omid Ashouri");
        props.put("Developer Contact Information","+9809126607350");
        builder.withDetails(props);
    }
}

package edu.imi.ir.eduimiws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    private static final String[] WEBJAR_RESOURCE_LOCATIONS = {"classpath:/META-INF/resources/webjars/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations(WEBJAR_RESOURCE_LOCATIONS);
        }
/*        registry.addResourceHandler("/**")
                .addResourceLocations(new String[]{"classpath:/static/"});*/
    }
}

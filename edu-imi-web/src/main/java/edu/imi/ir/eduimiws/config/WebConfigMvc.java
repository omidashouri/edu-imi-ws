package edu.imi.ir.eduimiws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Intentionally empty: Boot 4 auto-configures Jackson 3 ({@code JsonMapper}) and MVC converters.
 * Extending {@code WebMvcConfigurationSupport} previously disabled that auto-config.
 */
@Configuration
public class WebConfigMvc implements WebMvcConfigurer {
}

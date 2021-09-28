package edu.imi.ir.eduimiws.configurations;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.concurrent.Executor;


@Configuration
@EnableAsync
@Slf4j
public class SpringAsyncConfiguration implements AsyncConfigurer {

    @Primary
    @Bean("asyncExecutor")
    public Executor threadPoolTaskExecutor() {
        log.debug("Creating Async Task Executor");
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("AsyncThread-");
        executor.setThreadPriority(4);
        log.info("Active count {} and maxPoolSize {}",executor.getActiveCount(), executor.getMaxPoolSize());
        executor.initialize();
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return threadPoolTaskExecutor();
    }


    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet()
    {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet(), "/");
        registration.setAsyncSupported(true);
        return registration;
    }

//    change AsyncRequestTimeoutException
/*    @Bean
    public TomcatConnectorCustomizer tomcatConnectorCustomizer(){
        return connector -> connector.setAsyncTimeout(180000);
    }*/

/*    @Bean
    public TomcatServletWebServerFactoryCustomizer tomcatServletWebServerFactoryCustomizer(
            ServerProperties serverProperties) {
        TomcatServletWebServerFactoryCustomizer tomcatServletWebServerFactoryCustomizer =
                new TomcatServletWebServerFactoryCustomizer(serverProperties);
        tomcatServletWebServerFactoryCustomizer.customize(this.tomcatServletWebServerFactory());
        return tomcatServletWebServerFactoryCustomizer;
    }*/


    /*    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(){
        };
            tomcat.addAdditionalTomcatConnectors(connector());
        return tomcat;
    }*/


    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                var securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                var collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(connector());
        return tomcat;
    }

    @Bean
    public Connector connector(){
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setAsyncTimeout(180000);
        connector.setPort(Integer.valueOf(8083));
        connector.setAllowTrace(true);
        connector.setScheme("http");
        connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
    }

    @Bean
    public TomcatConnectorCustomizer tomcatConnectorCustomizer(){
        return connector -> {this.connector();};
    }

}

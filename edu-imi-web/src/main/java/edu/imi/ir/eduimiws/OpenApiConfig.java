package edu.imi.ir.eduimiws;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    //    http://localhost:8080/edu-imi-ws/v3/api-docs
    //    http://localhost:8080/edu-imi-ws/swagger-ui.html
    //    http://localhost:8080/edu-imi-ws/swagger-ui/index.html?configUrl=/edu-imi-ws/v3/api-docs/swagger-config
    //    http://172.17.70.160:8080/edu-imi-ws/swagger-ui/index.html?configUrl=/edu-imi-ws/v3/api-docs/swagger-config
    //    http://172.17.70.160:8080/edu-imi-ws/swagger-ui.html


    @Bean
    public OpenAPI customOpenAPI(){

        Server productionServer = new Server();
            productionServer.setDescription("Production Server");
            productionServer.setUrl("edu-imi-ws");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("imi-security-key",
                    new SecurityScheme()
                            .type(SecurityScheme.Type.APIKEY)
                            .description("IMI Education Authorization key")
                            .name("Authorization")
                            .in(SecurityScheme.In.HEADER))
                )
                .info(new Info()
                    .title("IMI Education API")
                    .version("3.0.3")
                    .description("IMI Education Web Service API")
                    .termsOfService("http://imi.ir/terms/")
                    .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                    .contact(new Contact()
                            .name("Industrial Management Institute")
                            .email("info@imi.ir")
                            .url("http://imi.ir"))
                )
//                .servers(Arrays.asList(productionServer))
                .addSecurityItem(
                            new SecurityRequirement().addList("imi-security-key", Arrays.asList("read", "write")));
    }

    @Bean
    public GroupedOpenApi loginApi(){
        return GroupedOpenApi.builder()
                .setGroup("Authentication-login")
                .pathsToMatch("/api/users/login")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi userApi(){
        return GroupedOpenApi.builder()
                .setGroup("Users")
                .pathsToMatch("/api/v1/users/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi contactApi(){
        return GroupedOpenApi.builder()
                .setGroup("Contacts")
                .pathsToMatch("/api/v1/contacts/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi periodApi(){
        return GroupedOpenApi.builder()
                .setGroup("Periods")
                .pathsToMatch("/api/v1/periods/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi studentApi(){
        return GroupedOpenApi.builder()
                .setGroup("Students")
                .pathsToMatch("/api/v1/students/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

//    Later correct Them
/*    @Bean
    public GroupedOpenApi roleApi(){
        return GroupedOpenApi.builder()
                .setGroup("Roles")
                .pathsToMatch("/api/v1/roles/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi privilegeApi(){
        return GroupedOpenApi.builder()
                .setGroup("Privileges")
                .pathsToMatch("/api/v1/privileges/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }*/

    @Bean
    public GroupedOpenApi registerApi(){
        return GroupedOpenApi.builder()
                .setGroup("Registers")
                .pathsToMatch("/api/v1/registers/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi mailApi(){
        return GroupedOpenApi.builder()
                .setGroup("Mails")
                .pathsToMatch("/api/v1/mails/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi levelApi(){
        return GroupedOpenApi.builder()
                .setGroup("Levels")
                .pathsToMatch("/api/v1/levels/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi educationCategoryApi(){
        return GroupedOpenApi.builder()
                .setGroup("Education Categories")
                .pathsToMatch("/api/v1/eduCategories/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi fieldApi() {
        return GroupedOpenApi.builder()
                .setGroup("Fields")
                .pathsToMatch("/api/v1/fields/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi courseApi() {
        return GroupedOpenApi.builder()
                .setGroup("Courses")
                .pathsToMatch("/api/v1/courses/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi periodCourseApi() {
        return GroupedOpenApi.builder()
                .setGroup("PeriodCourses")
                .pathsToMatch("/api/v1/periodCourses/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi periodCourseProfessorApi() {
        return GroupedOpenApi.builder()
                .setGroup("PeriodCourseProfessors")
                .pathsToMatch("/api/v1/periodCourseProfessors/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi professorApi() {
        return GroupedOpenApi.builder()
                .setGroup("Professors")
                .pathsToMatch("/api/v1/professors/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi termApi() {
        return GroupedOpenApi.builder()
                .setGroup("Terms")
                .pathsToMatch("/api/v1/terms/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi fieldCourseApi() {
        return GroupedOpenApi.builder()
                .setGroup("FieldCourses")
                .pathsToMatch("/api/v1/fieldCourses/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi termPresentedCourseApi() {
        return GroupedOpenApi.builder()
                .setGroup("TermPresentedCourses")
                .pathsToMatch("/api/v1/termPresentedCourses/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi termCourseProfessorApi() {
        return GroupedOpenApi.builder()
                .setGroup("TermCourseProfessors")
                .pathsToMatch("/api/v1/termCourseProfessors/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

//    Later correct Them
/*    @Bean
    public GroupedOpenApi rqresApi() {
        return GroupedOpenApi.builder()
                .setGroup("Reqres")
                .pathsToMatch("/api/v1/reqres/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }*/

/*    @Bean
    public GroupedOpenApi mellatsApi(){
        return GroupedOpenApi.builder()
                .setGroup("Behpardakhts")
                .pathsToMatch("/api/v1/behpardakhts/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }*/

}

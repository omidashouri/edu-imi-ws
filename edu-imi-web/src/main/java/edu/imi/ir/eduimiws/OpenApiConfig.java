package edu.imi.ir.eduimiws;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
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
    //    https://localhost:8443/edu-imi-ws/swagger-ui/index.html?configUrl=/edu-imi-ws/v3/api-docs/swagger-config


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
                .group("Authentication-login")
                .pathsToMatch("/api/users/login")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi userApi(){
        return GroupedOpenApi.builder()
                .group("Users")
                .pathsToMatch("/api/v1/users/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi contactApi(){
        return GroupedOpenApi.builder()
                .group("Contacts")
                .pathsToMatch("/api/v1/contacts/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi periodApi(){
        return GroupedOpenApi.builder()
                .group("Periods")
                .pathsToMatch("/api/v1/periods/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi studentApi(){
        return GroupedOpenApi.builder()
                .group("Students")
                .pathsToMatch("/api/v1/students/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

//    Later correct Them
/*    @Bean
    public GroupedOpenApi roleApi(){
        return GroupedOpenApi.builder()
                .group("Roles")
                .pathsToMatch("/api/v1/roles/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi privilegeApi(){
        return GroupedOpenApi.builder()
                .group("Privileges")
                .pathsToMatch("/api/v1/privileges/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }*/

    @Bean
    public GroupedOpenApi registerApi(){
        return GroupedOpenApi.builder()
                .group("Registers")
                .pathsToMatch("/api/v1/registers/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi mailApi(){
        return GroupedOpenApi.builder()
                .group("Mails")
                .pathsToMatch("/api/v1/mails/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi levelApi(){
        return GroupedOpenApi.builder()
                .group("Levels")
                .pathsToMatch("/api/v1/levels/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi educationCategoryApi(){
        return GroupedOpenApi.builder()
                .group("Education Categories")
                .pathsToMatch("/api/v1/eduCategories/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi fieldApi() {
        return GroupedOpenApi.builder()
                .group("Fields")
                .pathsToMatch("/api/v1/fields/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi courseApi() {
        return GroupedOpenApi.builder()
                .group("Courses")
                .pathsToMatch("/api/v1/courses/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi periodCourseApi() {
        return GroupedOpenApi.builder()
                .group("PeriodCourses")
                .pathsToMatch("/api/v1/periodCourses/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi periodCourseProfessorApi() {
        return GroupedOpenApi.builder()
                .group("PeriodCourseProfessors")
                .pathsToMatch("/api/v1/periodCourseProfessors/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi professorApi() {
        return GroupedOpenApi.builder()
                .group("Professors")
                .pathsToMatch("/api/v1/professors/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi termApi() {
        return GroupedOpenApi.builder()
                .group("Terms")
                .pathsToMatch("/api/v1/terms/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi fieldCourseApi() {
        return GroupedOpenApi.builder()
                .group("FieldCourses")
                .pathsToMatch("/api/v1/fieldCourses/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi termPresentedCourseApi() {
        return GroupedOpenApi.builder()
                .group("TermPresentedCourses")
                .pathsToMatch("/api/v1/termPresentedCourses/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi termCourseProfessorApi() {
        return GroupedOpenApi.builder()
                .group("TermCourseProfessors")
                .pathsToMatch("/api/v1/termCourseProfessors/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi projectApi() {
        return GroupedOpenApi.builder()
                .group("Projects")
                .pathsToMatch("/api/v1/projects/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi sabtAhvalApi() {
        return GroupedOpenApi.builder()
                .group("Sabtahval")
                .pathsToMatch("/api/v1/sabtahval/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi expenseCodeApi() {
        return GroupedOpenApi.builder()
                .group("ExpenseCodes")
                .pathsToMatch("/api/v1/expenseCodes/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi paymentCodeApi() {
        return GroupedOpenApi.builder()
                .group("PaymentCodes")
                .pathsToMatch("/api/v1/paymentCodes/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi melliCodeApi() {
        return GroupedOpenApi.builder()
                .group("MelliPayments")
                .pathsToMatch("/api/v1/sadadPayments/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi hamkaranCodeApi() {
        return GroupedOpenApi.builder()
                .group("HamkaranApi")
                .pathsToMatch("/api/v1/hamkarans/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi voucherListItemsApi() {
        return GroupedOpenApi.builder()
                .group("VoucherListItems")
                .pathsToMatch("/api/v1/voucherListItems/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi voucherDeleteItemsApi() {
        return GroupedOpenApi.builder()
                .group("VoucherDeleteItems")
                .pathsToMatch("/api/v1/voucherDeleteItems/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi AccountsApi() {
        return GroupedOpenApi.builder()
                .group("Accounts")
                .pathsToMatch("/api/v1/accounts/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi FarapayamakApi() {
        return GroupedOpenApi.builder()
                .group("Farapayamaks")
                .pathsToMatch("/api/v1/farapayamaks/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi behdadAccountApi() {
        return GroupedOpenApi.builder()
                .group("BehdadAccounts")
                .pathsToMatch("/api/v1/behdad/accounts/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi behdadIdentifierApi() {
        return GroupedOpenApi.builder()
                .group("BehdadIdentifiers")
                .pathsToMatch("/api/v1/behdad/identifiers/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi projectDepositCodeApi() {
        return GroupedOpenApi.builder()
                .group("ProjectDepositCodeApis")
                .pathsToMatch("/api/v1/projectDepositCodeApis/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }

    @Bean
    public GroupedOpenApi attendanceApi() {
        return GroupedOpenApi.builder()
                .group("AttendanceApis")
                .pathsToMatch("/api/v1/attendance/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }


/*    @Bean
    public GroupedOpenApi periodCertificateSmsApiApi() {
        return GroupedOpenApi.builder()
                .group("PeriodCertificateSmsApi")
                .pathsToMatch("/api/v1/periodCrtificateSmsApis/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }*/

//    Later correct Them
/*    @Bean
    public GroupedOpenApi rqresApi() {
        return GroupedOpenApi.builder()
                .group("Reqres")
                .pathsToMatch("/api/v1/reqres/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }*/

/*    @Bean
    public GroupedOpenApi mellatsApi(){
        return GroupedOpenApi.builder()
                .group("Behpardakhts")
                .pathsToMatch("/api/v1/behpardakhts/**")
                .packagesToScan("edu.imi.ir.eduimiws")
                .build();
    }*/

}

package edu.imi.ir.eduimiws;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.imi.ir.eduimiws.models.request.UserLoginRequestModel;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("dev")
class EduImiWsApplicationTests {

    @LocalServerPort
    int randomServerPort;


    private final RestTemplate restTemplate =  new RestTemplate();

    MockRestServiceServer mockServer =
            MockRestServiceServer.bindTo(restTemplate).build();


    @Autowired
    private ObjectMapper objectMapper;


    @Before
    public void setUp() throws Exception {

        String detailsString = objectMapper
                .writeValueAsString(new UserLoginRequestModel("9057", "", null));

        mockServer.verify();
    }

    @Ignore
    @Test
    void contextLoads() {
    }

}

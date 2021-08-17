package edu.imi.ir.eduimiws.controllers.melli.v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MelliControllerTest {

    @Autowired
    MelliController melliController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getToken() {
        melliController.getToken();
    }
}
package edu.imi.ir.eduimiws.controllers.v1;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

    @Operation(hidden = true)
    @RequestMapping("/greeting")
    public String greeting() {

        return "welcome";

    }
}

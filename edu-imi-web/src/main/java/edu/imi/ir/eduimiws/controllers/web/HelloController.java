package edu.imi.ir.eduimiws.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("/web/behpardakhts/thyme")
    public String thyme(Map<String,Object> model){
        model.put("message","Hello Omid Ashouri");
        return "thyme.html";
    }
}

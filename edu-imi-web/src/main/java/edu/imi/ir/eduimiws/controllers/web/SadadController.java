package edu.imi.ir.eduimiws.controllers.web;

import edu.imi.ir.eduimiws.security.MelliCredential;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web/sadad")
public class SadadController {

    private final MelliCredential melliCredential;


    @GetMapping(path = "/token/{digitalPaymentToken}")
    public ModelAndView bankPayment(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @PathVariable(value = "digitalPaymentToken") String digitalPaymentToken) throws URISyntaxException {
        ModelAndView modelAndView = new ModelAndView();
        URI uri = new URI("https://sadad.shaparak.ir/Purchase/Index?token="+digitalPaymentToken);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Referer",melliCredential.getApiRefererUrl());
        httpHeaders.set("Referer",melliCredential.getApiRefererUrl());
        httpHeaders.setLocation(uri);
        modelAndView.setViewName("sadad/sadadtoken.html");
        modelAndView.addObject("token",digitalPaymentToken);
        return modelAndView;
    }
}

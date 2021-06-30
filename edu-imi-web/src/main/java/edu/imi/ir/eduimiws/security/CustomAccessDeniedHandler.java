package edu.imi.ir.eduimiws.security;


import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class CustomAccessDeniedHandler implements AccessDeniedHandler, Serializable {

    private final Jackson2JsonObjectMapper jackson2JsonObjectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException e) throws IOException, ServletException {

        // You can create your own repsonse here to handle method level access denied reponses..
        // Follow similar method to the bad credentials handler above.

        ErrorMessage error = new ErrorMessage(LocalDateTime.now(), HttpStatus.FORBIDDEN.toString(), "You are Not Authenticated");

        /*
          Here we're going to creat a json strong from the CustomError object we just created.
          We set the media type, encoding, and then get the write from the response object and write
      our json string to the response.
        */
        try {
            String json = jackson2JsonObjectMapper.toJson(error);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            response.getWriter().write(json);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
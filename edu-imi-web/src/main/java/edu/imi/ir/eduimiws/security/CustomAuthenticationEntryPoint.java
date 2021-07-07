package edu.imi.ir.eduimiws.security;

import edu.imi.ir.eduimiws.models.response.ErrorMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    // the Jackson object mapper bean we created in the config
    private final Jackson2JsonObjectMapper jackson2JsonObjectMapper;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException e) throws IOException {

        /*
          This is a pojo you can create to hold the repsonse code, error, and description.
          You can create a POJO to hold whatever information you want to send back.
        */
        ErrorMessage error = new ErrorMessage(LocalDateTime.now().toString(),HttpStatus.FORBIDDEN.toString(), "You are Not Authorized");

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

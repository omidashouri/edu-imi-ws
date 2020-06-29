package edu.imi.ir.eduimiws.controllers.v1;


import edu.imi.ir.eduimiws.models.api.UserReqres;
import edu.imi.ir.eduimiws.services.api.reqres.ReqresApi;
import edu.imi.ir.eduimiws.services.api.reqres.SoapClientImpl;
import edu.imi.ir.eduimiws.services.api.reqres.SoapClientImpl2;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/reqres")
@RequiredArgsConstructor
@Tag(name = "reqres", description = "The reqres API")
public class ReqresController {

    private final ReqresApi reqresApi;
    private final SoapClientImpl soapClient;
    private final SoapClientImpl2 soapClientImpl2;


//    https://reqres.in/
//    https://reqres.in/api/users/2

    @GetMapping(path = "/{reqresId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getRoleByRolePublicId(@PathVariable String reqresId) {

        try {

            if(reqresId.equalsIgnoreCase("1")){
//                soapClient.callMellat();

              String aa =   soapClientImpl2.bpPayRequest(1L,null,null,
                        1L,1L,null,
                        null,null, null,
                String.valueOf(1L));

              String bb = aa;
            }

            UserReqres userReqres = reqresApi.getSingleUser(Long.valueOf(reqresId));


            return ResponseEntity.ok(userReqres);

        } catch (Exception ex) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}

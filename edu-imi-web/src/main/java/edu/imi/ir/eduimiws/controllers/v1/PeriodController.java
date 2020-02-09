package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.models.response.UserContactResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/periods")
@RequiredArgsConstructor
public class PeriodController {

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public List<UserContactResponse> getUsers(@RequestParam(value = "page",defaultValue = "1") int pageValue
            , @RequestParam(value = "limit",defaultValue = "25") int limitValue){


/*
        List<PersonWebServiceEntity> users =
                personWebServiceService
                        .findAllListByPageAndSize(pageValue,limitValue);

        List<UserContactFastDto> userContactFastDtos =
                personWebServiceUserContactFastDtoMapper.PersonWebServiceEntityToUserContactFastDtoes(users,new CycleAvoidingMappingContext());


        List<UserContactResponse> userContactResponses =
                userContactResponseUserContactFastDtoMapper
                        .UserContactFastDtoToUserContactResponses(userContactFastDtos,new CycleAvoidingMappingContext());


        return userContactResponses;*/
        return null;
    }
}

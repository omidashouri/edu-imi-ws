package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.UserContactFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.UserContactResponseMapper;
import edu.imi.ir.eduimiws.models.dto.UserContactFastDto;
import edu.imi.ir.eduimiws.models.response.UserContactResponse;
import edu.imi.ir.eduimiws.models.response.UserResponse;
import edu.imi.ir.eduimiws.services.crm.PersonWebServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final PersonWebServiceService personWebServiceService;
    private final UserContactFastDtoMapper userContactFastDtoMapper;
    private final UserContactResponseMapper userContactResponseMapper;


    // http://localhost:8080/edu-imi-ws/v1/users/aLIRVt88hdQ858q5AMURm1QI6DC3Je
    // in header add Accept : application/xml or application/json
    @GetMapping(path = "/{userPublicId}",
//            make response as XML or JSON
            produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public UserResponse getUser(@PathVariable String userPublicId){

        UserResponse returnValue = new UserResponse();

        PersonWebServiceEntity user = personWebServiceService.findPersonWebServiceEntityByUserPublicId(userPublicId);

        UserContactFastDto userContactFastDto = userContactFastDtoMapper.PersonWebServiceEntityToUserContactFastDto(user,new CycleAvoidingMappingContext());

        UserContactResponse userContactResponse = userContactResponseMapper.UserContactFastDtoToUserContactResponse(userContactFastDto,new CycleAvoidingMappingContext());

//        BeanUtils.copyProperties(userDto,returnValue);

        return returnValue;
    }
}

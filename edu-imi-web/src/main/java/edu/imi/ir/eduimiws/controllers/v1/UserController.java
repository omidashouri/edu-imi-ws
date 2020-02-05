package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.domain.crm.PersonWebServiceEntity;
import edu.imi.ir.eduimiws.mapper.CycleAvoidingMappingContext;
import edu.imi.ir.eduimiws.mapper.PersonWebServiceUserContactFastDtoMapper;
import edu.imi.ir.eduimiws.mapper.UserContactResponseUserContactFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.UserContactFastDto;
import edu.imi.ir.eduimiws.models.response.UserContactResponse;
import edu.imi.ir.eduimiws.models.response.UserResponse;
import edu.imi.ir.eduimiws.services.crm.PersonWebServiceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final PersonWebServiceService personWebServiceService;
    private final PersonWebServiceUserContactFastDtoMapper personWebServiceUserContactFastDtoMapper;
    private final UserContactResponseUserContactFastDtoMapper userContactResponseUserContactFastDtoMapper;


    // http://localhost:8080/edu-imi-ws/v1/users/aLIRVt88hdQ858q5AMURm1QI6DC3Je
    // in header add Accept : application/xml or application/json
    @GetMapping(path = "/{userPublicId}",
//            make response as XML or JSON
            produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public UserContactResponse getUser(@PathVariable String userPublicId){

        UserResponse returnValue = new UserResponse();

        PersonWebServiceEntity user = personWebServiceService.findPersonWebServiceEntityByUserPublicId(userPublicId);

        UserContactFastDto userContactFastDto = personWebServiceUserContactFastDtoMapper.PersonWebServiceEntityToUserContactFastDto(user,new CycleAvoidingMappingContext());

        UserContactResponse userContactResponse = userContactResponseUserContactFastDtoMapper.UserContactFastDtoToUserContactResponse(userContactFastDto,new CycleAvoidingMappingContext());

        return userContactResponse;
    }

    @ApiOperation(value = "THe Get User Details Web Service Endpoint ",
            notes = "This web service end points return user details. use public user id in url path")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "IMI JWT token", paramType = "header")
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public List<UserResponse> getUsers(@RequestParam(value = "page",defaultValue = "1") int pageValue
            , @RequestParam(value = "limit",defaultValue = "25") int limitValue){

/*        List<UserDto> userDtoList = userService.getUserDtosByPageAndLimit(pageValue,limitValue);

        List<UserRest> userRestList = new ArrayList<>();

        for(UserDto userDto : userDtoList){
            UserRest userRest = new UserRest();
            BeanUtils.copyProperties(userDto,userRest);
            userRestList.add(userRest);
        }

        return userRestList;*/
        return null;
    }
}

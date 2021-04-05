package edu.imi.ir.eduimiws.controllers.crm.v1;

import edu.imi.ir.eduimiws.assemblers.edu.CourseResponseCourseFastDtoAssembler;
import edu.imi.ir.eduimiws.mapper.crm.AccountMapper;
import edu.imi.ir.eduimiws.mapper.edu.CourseFastDtoMapper;
import edu.imi.ir.eduimiws.models.dto.crm.AccountDto;
import edu.imi.ir.eduimiws.models.dto.edu.CourseFastDto;
import edu.imi.ir.eduimiws.services.crm.AccountService;
import edu.imi.ir.eduimiws.services.edu.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
@Tag(name = "Accounts", description = "The account API")
public class AccountController {

    private final AccountService accountService;
//    private final AccountResponseAccountDtoAssembler accountResponseAccountDtoAssembler;
    private final PagedResourcesAssembler<AccountDto> accountDtoPagedResourcesAssembler;
    private final AccountMapper accountMapper;


}

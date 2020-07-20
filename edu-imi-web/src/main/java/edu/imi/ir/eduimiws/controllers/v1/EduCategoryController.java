package edu.imi.ir.eduimiws.controllers.v1;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EDUPOWERUSER')")
@RestController
@RequestMapping("/api/v1/eduCategories")
@RequiredArgsConstructor
@Tag(name = "EduCategories", description = "The Education Category API")
public class EduCategoryController {

}

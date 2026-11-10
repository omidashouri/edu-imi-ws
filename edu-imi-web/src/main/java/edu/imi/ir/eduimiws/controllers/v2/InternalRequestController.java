package edu.imi.ir.eduimiws.controllers.v2;

import edu.imi.ir.eduimiws.models.request.crm.v2.InternalRequestFilterDto;
import edu.imi.ir.eduimiws.models.response.Response;
import edu.imi.ir.eduimiws.models.response.crm.v2.InternalResponseFilterDto;
import edu.imi.ir.eduimiws.models.response.crm.v2.InternalResponseInquiryDto;
import edu.imi.ir.eduimiws.services.crm.v2.InternalRequestLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/internalRequests")
@RequiredArgsConstructor
@Tag(name = "سرویس های استعلام وضعیت درخواست")
@Validated
public class InternalRequestController {

    private final InternalRequestLogService internalRequestLogService;

    @GetMapping("/requests/filter")
    @Operation(
            summary = "فیلتر درخواست های ثبت شده",
            description = "همه پارامترهای فیلتر اختیاری هستند",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @PreAuthorize("hasAuthority('API_V2_CRM_INTERNAL_REQUEST_SEARCH')")
    public ResponseEntity<Response<Page<InternalResponseFilterDto>>> filter(
            @ParameterObject @ModelAttribute InternalRequestFilterDto requestDto,
            @ParameterObject @SortDefault(sort = "id") Pageable pageRequest) {
        Page<InternalResponseFilterDto> page = internalRequestLogService.filter(requestDto, pageRequest);
        if (page.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(Response.<Page<InternalResponseFilterDto>>builder()
                .responseDto(page).build());
    }

    @GetMapping("/requests/{requestId}")
    @Operation(
            summary = "استعلام وضعیت درخواست بر اساس شناسه درخواست",
            description = "وضعیت و اطلاعات ثبت شده یک درخواست را بر اساس requestId برمی گرداند",
            security = @SecurityRequirement(name = "imi-security-key")
    )
    @PreAuthorize("hasAuthority('API_V2_CRM_INTERNAL_REQUEST_READ')")
    public ResponseEntity<Response<InternalResponseInquiryDto>> getByRequestId(
            @PathVariable("requestId") @NotBlank(message = "{request.id.invalid}") String requestId) {
        return new ResponseEntity<>(Response.<InternalResponseInquiryDto>builder()
                .responseDto(internalRequestLogService.findByRequestId(requestId)).build(), HttpStatus.OK);
    }
}

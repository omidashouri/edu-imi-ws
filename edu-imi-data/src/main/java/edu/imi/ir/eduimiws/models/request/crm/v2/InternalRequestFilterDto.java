package edu.imi.ir.eduimiws.models.request.crm.v2;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InternalRequestFilterDto {

    @Schema(description = "شناسه یکتای درخواست")
    private String requestId;

    @Schema(description = "آدرس آی پی ارسال کننده درخواست")
    private String ipAddress;

    @Schema(description = "شناسه متصدی/اپراتور اجرا کننده عملیات")
    private String operatorId;

    @Schema(description = "نام عملیات تجاری")
    private String operationName;

    @Schema(description = "کد وضعیت پاسخ ارسال شده")
    private Short responseStatus;

    @Schema(description = "زمان دریافت درخواست", example = "2025-07-23T14:30:00")
    private LocalDateTime requestDateTime;
}

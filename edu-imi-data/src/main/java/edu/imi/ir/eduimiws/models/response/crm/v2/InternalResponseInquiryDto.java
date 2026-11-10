package edu.imi.ir.eduimiws.models.response.crm.v2;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class InternalResponseInquiryDto {

    @Schema(description = "نام عملیات تجاری")
    private String businessOperation;

    @Schema(description = "شناسه یکتای درخواست")
    private String requestId;

    @Schema(description = "شناسه متصدی/اپراتور اجرا کننده عملیات")
    private String operatorId;

    @Schema(description = "بدنه کامل درخواست به صورت JSON")
    private Map<String, Object> requestJson;

    @Schema(description = "زمان دریافت درخواست")
    private LocalDateTime requestTimestamp;

    @Schema(description = "کد وضعیت پاسخ ارسال شده")
    private Short responseStatus;

    @Schema(description = "زمان ارسال پاسخ")
    private LocalDateTime responseTimestamp;

    @Schema(description = "پیام خطا در صورت ناموفق بودن پاسخ")
    private String errorMessage;
}

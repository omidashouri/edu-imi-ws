package edu.imi.ir.eduimiws.utilities;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class SwaggerUtil {

    @Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Parameter(in = ParameterIn.QUERY
            , description = "Zero-based page index (0..N)"
            , name = "page"
            , content = @Content(schema = @Schema(type = "integer", defaultValue = "0")))
    @Parameter(in = ParameterIn.QUERY
            , description = "The size of the page to be returned"
            , name = "size"
            , content = @Content(schema = @Schema(type = "integer", defaultValue = "20")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Sorting criteria in the format: property(,asc|desc). "
            + "Default sort order is ascending. " + "Multiple sort criteria are supported."
            , name = "sort"
            , content = @Content(array = @ArraySchema(schema = @Schema(type = "string"))))
    public @interface PageableAsQueryParam {

    }


    @Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Parameter(in = ParameterIn.QUERY
            , description = "String value"
            , name = "operand"
            , content = @Content(schema = @Schema(type = "string", defaultValue = "greater")))
    @Parameter(in = ParameterIn.QUERY
            , description = "'create' for Create Date and 'edit' for Edit Date"
            , name = "operand_target"
            , content = @Content(schema = @Schema(type = "string", defaultValue = "create")))
    @Parameter(in = ParameterIn.QUERY
            , description = "example 1400/10/25"
            , name = "last_edit_date"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "The size of the page to be returned"
            , name = "limit"
            , content = @Content(schema = @Schema(type = "integer", defaultValue = "1000")))
    public @interface HamkaranAsQueryParam {

    }


    @Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Parameter(in = ParameterIn.QUERY
            , description = "Sample: 2022-02-02T12:39:52.933"
            , name = "datetime_create"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Sample: 2022-02-02T12:39:52.933"
            , name = "datetime_edit"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "The size of the page to be returned"
            , name = "limit"
            , content = @Content(schema = @Schema(type = "integer", defaultValue = "1000")))
    public @interface HamkaranGreaterThanDateTimeAsQueryParam {

    }

    @Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Parameter(in = ParameterIn.QUERY
            , description = "Voucher Number"
            , name = "voucherNumber"
            , content = @Content(schema = @Schema(type = "integer")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Voucher Sequence"
            , name = "voucherSequence"
            , content = @Content(schema = @Schema(type = "integer")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Voucher Daily Number"
            , name = "voucherDailyNumber"
            , content = @Content(schema = @Schema(type = "integer")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Fiscal Year Reference"
            , name = "fiscalYearRef"
            , content = @Content(schema = @Schema(type = "integer")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Fiscal Year"
            , name = "fiscalYear"
            , content = @Content(schema = @Schema(type = "inter")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Deleted Voucher ID, result is greater than input value"
            , name = "deletedVoucherID"
            , content = @Content(schema = @Schema(type = "integer")))
    @Parameter(in = ParameterIn.QUERY
            , description = "The size of the page to be returned"
            , name = "limit"
            , content = @Content(schema = @Schema(type = "integer", defaultValue = "1000")))
    public @interface HamkaranDeletedFinancialAsQueryParam {

    }


    @Target({ ElementType.METHOD, ElementType.ANNOTATION_TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Parameter(in = ParameterIn.QUERY
            , description = "payment code"
            , name = "paymentCode"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "request description"
            , name = "requestDescription"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "national code or national identification"
            , name = "nationalCode"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "expense Code"
            , name = "expenseCode"
            , content = @Content(schema = @Schema(type = "integer")))
    @Parameter(in = ParameterIn.QUERY
            , description = "expense title"
            , name = "expenseTitle"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "project code"
            , name = "projectCode"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "project name"
            , name = "projectName"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Mobile Phone"
            , name = "payerContactMobilePhone"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Full Name"
            , name = "payerContactFullName"
            , content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Zero-based page index (0..N)"
            , name = "page"
            , content = @Content(schema = @Schema(type = "integer", defaultValue = "0")))
    @Parameter(in = ParameterIn.QUERY
            , description = "The size of the page to be returned"
            , name = "size"
            , content = @Content(schema = @Schema(type = "integer", defaultValue = "20")))
    @Parameter(in = ParameterIn.QUERY
            , description = "Sorting criteria in the format: property(,asc|desc). "
            + "Default sort order is ascending."
            , name = "sort"
            , content = @Content(schema = @Schema(type = "string")))
    public @interface PaymentCodeResponseDescriptiveAsQueryParam {

    }
}

package edu.imi.ir.eduimiws.models.response.mainparts;


import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Timestamp;

@Schema(name = "VoucherDeleteItemsApiResponseMapper",description = "Voucher Delete Items Api Response")
@JsonRootName(value = "VoucherDeleteItemsApiResponseMapper")
@Relation(collectionRelation = "VoucherDeleteItemsApiResponses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoucherDeleteItemsApiResponse  extends RepresentationModel<VoucherDeleteItemsApiResponse> {

    private Long idApi;

    private String publicId;

    private String referenceNumber;

    private Long voucherNumber;

    private Long voucherSequence;

    private Long voucherDailyNumber;

    private Long fiscalYearRef;

    private Long fiscalYear;

    private String voucherDate;

    private Timestamp voucherDateTs;

    private String shamsiVoucherDate;

    private String voucherCreator;

    private String deleter;

    private String deleterUserName;

    private String dateOfRemoval;

    private Timestamp dateOfRemovalTs;

    private String shamsiDateOfRemoval;

    private Timestamp createDateTs;

    private Timestamp deleteDateTs;

    private Timestamp editDateTs;

    private Long recordStatus;
}

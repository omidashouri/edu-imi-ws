package edu.imi.ir.eduimiws.models.response.edu;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;



@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "period")
@Relation(collectionRelation = "periods")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodResponse extends RepresentationModel<PeriodResponse> {
    @Schema(
            description = "period public id"
    )
    private String periodPublicId;
    private String name;
    private String startDate;
    private String endDate;
    private String type;
    private Long fee;
    private Long offerNumber;
    private String createDate;
    private String editDate;
    private Long activityStatus;
    private Long deleteStatus;
    private Long maxCapacity;
    private Long minCapacity;
    private String executorPublicId;
    private String regStartDate;
    private String regEndDate;
    private String description;
    private String canRegisterOnline;
    private String holdingType;
    private String holdingLanguage;


}

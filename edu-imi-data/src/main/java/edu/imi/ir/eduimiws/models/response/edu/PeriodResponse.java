package edu.imi.ir.eduimiws.models.response.edu;

import edu.imi.ir.eduimiws.domain.crm.PersonEntity;
import edu.imi.ir.eduimiws.domain.edu.FieldEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

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

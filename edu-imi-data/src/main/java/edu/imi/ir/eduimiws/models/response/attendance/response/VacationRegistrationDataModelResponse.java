package edu.imi.ir.eduimiws.models.response.attendance.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.utilities.attendance.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@JsonRootName(value = "vacationRegistrationDataModel")
@Relation(collectionRelation = "vacationRegistrationDataModels")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacationRegistrationDataModelResponse implements Serializable {

    private Long id;
    private Long vacationRegistrationId;
    private String employeeCode;
    private Long businessPartnerId;
    private String fullName;
    private DayOfWeek dayOfWeek;
    private String beginDate;
    private String beginTime;
    private String endDate;
    private String endTime;
    private VacationName vacationName;
    private VacationType vacationType;
    private AcceptanceState acceptanceState;
    private SourceType vacationSourceType;
}

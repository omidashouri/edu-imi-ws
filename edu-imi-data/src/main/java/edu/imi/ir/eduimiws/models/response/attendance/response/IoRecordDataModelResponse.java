package edu.imi.ir.eduimiws.models.response.attendance.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.utilities.attendance.AcceptanceState;
import edu.imi.ir.eduimiws.utilities.attendance.DayOfWeek;
import edu.imi.ir.eduimiws.utilities.attendance.SourceType;
import edu.imi.ir.eduimiws.utilities.attendance.RecordIoType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;

@JsonRootName(value = "ioRecordDataModel")
@Relation(collectionRelation = "ioRecordDataModels")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IoRecordDataModelResponse implements Serializable {

    private Long id;
    private Long ioRecordId;
    private String employeeCode;
    private Long businessPartnerId;
    private String fullName;
    private DayOfWeek dayOfWeek;
    private String jalaliDate;
    private String time;
//    @JsonProperty("RecordIoType")
    private RecordIoType recordIoType;
    private AcceptanceState acceptanceState;
    private SourceType sourceType;
}

package edu.imi.ir.eduimiws.models.response.crm.farapayamak;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.DataDto;
import edu.imi.ir.eduimiws.models.dto.crm.farapayamak.MyBaseDto;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "farapayamaks")
@Schema(name = "getMessagesResponseForFarapayamak", description = "Class representing response get messages from farapayamak in the application.")
@EqualsAndHashCode(callSuper = false)
@JsonRootName(value = "getMessagesFromFarapayamakResponseForFarapayamak")
@Relation(collectionRelation = "getMessagesFromFarapayamakResponseForFarapayamaks")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetMessagesResponseForFarapayamak extends RepresentationModel<GetMessagesResponseForFarapayamak> {



    @Schema(title = "MyBase",
    description = "myBase dto has 3 property succh as value,retStatus,strRetstatus")
    @JsonProperty("MyBase")
    private MyBaseDto myBaseDto;

    @Schema(title = "Data",description = "data dto has many properties such as sender,body,msgId,...")
    @JsonProperty("Data")
    private List<DataDto> dataDtos = new ArrayList<>();


}

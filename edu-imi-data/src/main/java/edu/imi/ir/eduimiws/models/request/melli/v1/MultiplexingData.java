package edu.imi.ir.eduimiws.models.request.melli.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

import java.io.Serializable;
import java.util.List;

//  Attention: change MultiplexingDataItem inner class to a separate class

@Schema(name = "melli",description = "melli Multiplexing Data")
@JsonRootName(value = "multiplexingData")
@Relation(collectionRelation = "multiplexingData")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MultiplexingData implements Serializable {

    @Schema(title = "Multiplexing Type",
            description = "Multiplexing Type")
    @JsonProperty("MultiplexingType")
    public MultiplexingType type;

    @Schema(title = "Multiplexing Rows",
            description = "Multiplexing Rows")
    @JsonProperty("MultiplexingRows")
    public List<MultiplexingDataItem> multiplexingRows;

    @Schema(title = "Is Valid",
            description = "Is Valid")
    @JsonProperty("IsValid")
    public Boolean isValid;

    public Boolean isValid() {
        if (this.type==null)
            return false;

        if (this.multiplexingRows==null)
            return false;

        if (this.multiplexingRows!=null){
            if(this.getMultiplexingRows().size()==0){
                return false;
            }
        }

        switch (this.getType())
        {
            case Percentage:
                if(this.multiplexingRows
                        .stream()
                        .map(MultiplexingDataItem::getValue)
                        .reduce(0L,Long::sum)
                        .longValue()>100L)
                            return false;
                if(this.multiplexingRows
                        .stream()
                        .map(MultiplexingDataItem::getValue)
                        .reduce(0L,Long::sum)
                        .longValue()>99L)
                    return false;
            break;
            case Amount:
                break;
            default:
                break;
        }
            return true;
    }

    public enum MultiplexingType
    {
        Percentage,
        Amount
    }

}

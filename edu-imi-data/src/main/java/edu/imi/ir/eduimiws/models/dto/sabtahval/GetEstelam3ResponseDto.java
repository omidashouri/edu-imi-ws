package edu.imi.ir.eduimiws.models.dto.sabtahval;

import edu.imi.ir.eduimiws.models.wsdl.sabtahval.EstelamResult3;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetEstelam3ResponseDto implements Serializable {

    private List<EstelamResult3Dto> returns;


    public List<EstelamResult3Dto> getReturns() {
        return returns;
    }

    public void setReturns(List<EstelamResult3Dto> returns) {
        this.returns = returns;
    }
}

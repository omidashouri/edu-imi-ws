package edu.imi.ir.eduimiws.models.dto.sabtahval;


import edu.imi.ir.eduimiws.models.sabtahval.GetEstelam3;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SabtahvalCredential {

    private String uri;
    private String username;
    private String password;
    private String packagesToScan;
    private String messageSenderUsername;
    private String messageSenderPassword;
    private GetEstelam3 getEstelam3;


}

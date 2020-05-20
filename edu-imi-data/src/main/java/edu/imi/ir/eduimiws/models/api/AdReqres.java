package edu.imi.ir.eduimiws.models.api;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdReqres implements Serializable {

    private String company;
    private String url;
    private String text;
}

package edu.imi.ir.eduimiws.models.dto.hamkaran;


import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranLinkDto implements Serializable {

    private static final long serialVersionUID = 8657675873131746997L;

    private String name;
    private String href;
}

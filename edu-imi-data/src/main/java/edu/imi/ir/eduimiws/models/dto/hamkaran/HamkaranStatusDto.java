package edu.imi.ir.eduimiws.models.dto.hamkaran;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HamkaranStatusDto {

    private boolean success;
    private String statusCode;
    private String message;
}

package edu.imi.ir.eduimiws.exceptions.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RaiseError {

    private String code;
    private String message;
    private Map<String, List<String>> detail;
}

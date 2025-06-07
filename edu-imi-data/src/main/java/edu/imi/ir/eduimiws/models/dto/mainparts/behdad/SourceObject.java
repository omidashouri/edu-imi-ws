package edu.imi.ir.eduimiws.models.dto.mainparts.behdad;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class SourceObject {
    private Map<String, Object> fields = new HashMap<String, Object>();
}

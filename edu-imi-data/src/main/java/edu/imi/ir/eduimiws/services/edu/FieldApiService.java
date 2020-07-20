package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.FieldApiEntity;
import edu.imi.ir.eduimiws.domain.edu.FieldEntity;

import java.util.List;

public interface FieldApiService {

    FieldApiEntity selectLastRecord();

    Long fieldApiCount();

    List<FieldApiEntity> generateFieldApiPublicId(List<FieldEntity> newFieldEntities);
}

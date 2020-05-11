package edu.imi.ir.eduimiws.services.edu;

import edu.imi.ir.eduimiws.domain.edu.RegisterApiEntity;
import edu.imi.ir.eduimiws.domain.edu.RegisterEntity;

import java.util.List;

public interface RegisterApiService {

    RegisterApiEntity selectLastRecord();

    Long registerApiCount();

    List<RegisterApiEntity> generateRegisterApiPublicId(List<RegisterEntity> newRegisterEntities);
}

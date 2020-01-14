package edu.imi.ir.eduimiws.services;


import edu.imi.ir.eduimiws.domain.crm.CarDetail;

public interface CarDetailService {

    CarDetail addCarDetail(CarDetail carDetail);

    CarDetail findById(Long id) throws ClassNotFoundException;
}

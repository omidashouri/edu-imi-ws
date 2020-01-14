package edu.imi.ir.eduimiws.services;


import edu.imi.ir.eduimiws.domain.crm.CarDetail;
import edu.imi.ir.eduimiws.repositories.CarDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarDetailServiceImpl implements CarDetailService {

    private final CarDetailRepository carDetailRepository;

    @Autowired
    public CarDetailServiceImpl(CarDetailRepository carDetailRepository) {
        this.carDetailRepository = carDetailRepository;
    }

    @Override
    public CarDetail addCarDetail(CarDetail carDetail) {
        return carDetailRepository.save(carDetail);
    }

    @Override
    public CarDetail findById(Long id) throws ClassNotFoundException {
        return carDetailRepository.findById(id).orElseThrow(ClassNotFoundException::new);
    }
}

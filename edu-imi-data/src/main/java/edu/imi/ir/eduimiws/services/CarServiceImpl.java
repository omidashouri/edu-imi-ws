package edu.imi.ir.eduimiws.services;


import edu.imi.ir.eduimiws.domain.Car;
import edu.imi.ir.eduimiws.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car findCarById(Long id) throws ClassNotFoundException {
        return carRepository.findById(id).orElseThrow(ClassNotFoundException::new);
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

}

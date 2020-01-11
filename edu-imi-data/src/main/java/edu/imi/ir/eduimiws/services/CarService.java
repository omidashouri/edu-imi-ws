package edu.imi.ir.eduimiws.services;

import edu.imi.ir.eduimiws.domain.Car;

import java.util.List;

public interface CarService {

    List<Car> findAllCars();

    Car findCarById(Long id) throws ClassNotFoundException;

    Car addCar(Car car);
}

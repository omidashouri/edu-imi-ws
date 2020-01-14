package edu.imi.ir.eduimiws.controllers.v1;

import edu.imi.ir.eduimiws.domain.crm.Car;
import edu.imi.ir.eduimiws.domain.crm.CarDetail;
import edu.imi.ir.eduimiws.repositories.CarRepository;
import edu.imi.ir.eduimiws.services.CarDetailService;
import edu.imi.ir.eduimiws.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {


    @Autowired
    CarRepository carRepository;

    @Autowired
    CarService carService;

    @Autowired
    CarDetailService carDetailService;


    @RequestMapping("/cars")
    public String getcars(){
        List<Car> cars = carRepository.findAll();
        List<Car> cars1 = carService.findAllCars();
        Car car = new Car();
        car.setName(cars.get(0).getName());
        return car.getName();
    }

    @RequestMapping("/newCar")
    public void addCar() throws ClassNotFoundException {
        Car newCar = new Car();
        newCar.setName("car16");
        newCar.setCreatorId(100160L);
        newCar.setCreateDate("1398/07/15");
        CarDetail carDetail = new CarDetail();
        carDetail = carDetailService.findById(2l);
        newCar.getCarDetails().add(carDetail);
        carService.addCar(newCar);
    }

}

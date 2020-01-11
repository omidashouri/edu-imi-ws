package edu.imi.ir.eduimiws.controllers.v1;


import edu.imi.ir.eduimiws.domain.Car;
import edu.imi.ir.eduimiws.domain.CarDetail;
import edu.imi.ir.eduimiws.services.CarDetailService;
import edu.imi.ir.eduimiws.services.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarDetailController {

   private final CarDetailService carDetailService;
   private final CarService carService;


    public CarDetailController(CarDetailService carDetailService, CarService carService) {
        this.carDetailService = carDetailService;
        this.carService = carService;
    }

    @RequestMapping("/newCarDetail")
    public void addCar() throws ClassNotFoundException {
        CarDetail newCarDetail = new CarDetail();
        Car car = new Car();
        car = carService.findCarById(1l);
        car.getCarDetails().add(newCarDetail);
        newCarDetail.setCarId(car);
        newCarDetail.setColor("Blue");
        newCarDetail.setPlateNum("Plate Number");
        newCarDetail.setPlateKing("Plate Kind");
        newCarDetail.setCreatorId(100160L);
        newCarDetail.setCreateDate("1398/07/15");
        newCarDetail.setCarOwnerId(100160l);
        newCarDetail.setParkingCapacityId(1l);
        carDetailService.addCarDetail(newCarDetail);
    }




}

package com.carontime.on_time.service.carservice;

import com.carontime.on_time.dto.AddCarDao;
import com.carontime.on_time.forms.CarForm;
import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.geom.Point2D;
import java.security.InvalidParameterException;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public Car getCar(Integer id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public boolean isExists(Integer id) {
        return carRepository.existsById(id);
    }

    @Override
    public void updateCar(Integer carId, CarForm carForm) {
        Car car = carRepository.findById(carId).orElseThrow(InvalidParameterException::new);
        car.setLocalization(AddCarDao.convertCoordsToPoint2D(carForm));
        car.setStatus(carForm.getStatus());
        carRepository.save(car);
    }

}

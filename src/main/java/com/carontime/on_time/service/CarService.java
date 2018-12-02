package com.carontime.on_time.service;

import com.carontime.on_time.model.car.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car addCar(Car car);
    void deleteCar(Car car);
    Car getCar(Integer id);
    List<Car> getAll();
    boolean isExists(Integer id);
}

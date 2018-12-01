package com.carontime.on_time.model;

import com.carontime.on_time.model.car.Car;

public interface CarManager {
    void addCar(Car car);
    boolean removeCar(Car car);
    Car getCar(int id);
}

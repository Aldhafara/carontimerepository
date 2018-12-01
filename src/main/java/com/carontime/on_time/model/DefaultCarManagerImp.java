package com.carontime.on_time.model;

import com.carontime.on_time.model.car.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultCarManagerImp implements CarManager {
    private List<Car> listOfCars = new ArrayList<>();

    @Override
    public int addCar(Car car) {

    }

    public void asd() {}
    
    @Override
    public boolean removeCar(Car car) {
        return false;
    }

    @Override
    public Car getCar(int id) {
        return null;
    }
}

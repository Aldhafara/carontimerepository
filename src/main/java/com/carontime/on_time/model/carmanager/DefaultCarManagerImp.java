package com.carontime.on_time.model.carmanager;

import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.model.carmanager.CarManager;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultCarManagerImp implements CarManager {
    private List<Car> listOfCars = new ArrayList<>();

    @Override
    public int addCar(Car car) {
        Preconditions.checkNotNull(car, "Car is null");
        if(!listOfCars.contains(car)) {
            listOfCars.add(car);
            return listOfCars.size() - 1;
        }
        return -1;
    }
    
    @Override
    public boolean removeCar(Car car) {
        if(car == null) return false;
        return listOfCars.remove(car);
    }

    @Override
    public Car getCar(int id) {
        Preconditions.checkArgument(id >= 0 && id < listOfCars.size(), "Id wyszukiwanego pojazdu przekracza zakres listy");
        return listOfCars.get(id);
    }
}

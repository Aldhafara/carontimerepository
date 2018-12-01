package com.carontime.on_time.model.carmanager;

import com.carontime.on_time.model.car.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarManager extends CrudRepository<Car, Integer> {

}

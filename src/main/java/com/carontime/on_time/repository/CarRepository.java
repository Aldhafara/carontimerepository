package com.carontime.on_time.repository;

import com.carontime.on_time.model.car.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {

}

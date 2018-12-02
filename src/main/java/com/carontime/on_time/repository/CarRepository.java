package com.carontime.on_time.repository;

import com.carontime.on_time.model.car.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Integer> {
    List<Car> findAll();
}

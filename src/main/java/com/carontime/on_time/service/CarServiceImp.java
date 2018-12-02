package com.carontime.on_time.service;

import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
        Optional<Car> car = carRepository.findById(id);
        System.out.println("Car: " + car);
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

}

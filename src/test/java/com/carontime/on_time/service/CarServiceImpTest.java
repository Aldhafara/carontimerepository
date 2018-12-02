package com.carontime.on_time.service;

import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.repository.CarRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceImpTest {

    @Autowired private CarService carService;
    @Autowired private CarRepository carRepository;
    private List<Car> carList = new ArrayList<>();


    @Before
    public void before() {
        carRepository.deleteAll();
        carList.add(new Car());
        carList.add(new Car());
        carList.add(new Car());
    }

    @After
    public void after() {
        carList.clear();
        carRepository.deleteAll();
    }

    @Test
    public void checkIfCarIsAddedSuccessfully() {
        Car carToSave = carList.get(0);
        assertThat(carService.getAll().size()).isZero();
        carService.addCar(carToSave);
        assertThat(carService.getAll().size()).isEqualTo(1);
        assertThat(carService.isExists(carToSave.getId())).isTrue();
    }

    @Test
    public void checkIfCarIsDeletedSuccessfully() {
        Car carToRemove = carList.get(1);
        carService.addCar(carToRemove);
        assertThat(carService.isExists(carToRemove.getId())).isTrue();
        carService.deleteCar(carToRemove);
        assertThat(carService.isExists(carToRemove.getId())).isFalse();
    }

    @Test
    public void checkIfCarIsGettingSuccessfully() {
        Car carToCheck = carList.get(1);
        Car carFromDB;
        carService.addCar(carToCheck);
        carFromDB = carService.getCar(carToCheck.getId());
        assertThat(carToCheck).isEqualTo(carFromDB);
    }

    @Test
    public void checkIfSerivceWillReturnFullListOfCarsInDB() {
        carService.addCar(carList.get(0));
        carService.addCar(carList.get(1));
        carService.addCar(carList.get(2));

        List<Car> listOfCarsFromDB = carService.getAll();

        assertThat(listOfCarsFromDB.size()).isEqualTo(carList.size());
        assertThat(listOfCarsFromDB).containsAll(carList);
    }
}
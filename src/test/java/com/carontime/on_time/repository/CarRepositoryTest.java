package com.carontime.on_time.repository;

import com.carontime.on_time.model.car.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Before
    public void prepare() {
        carRepository.deleteAll();
    }

    @After
    public void after() {
        carRepository.deleteAll();
    }

    @Test
    public void checkIfCarIsSavedCorrectly() {
        Car car_1 = new Car();
        Car car_2 = new Car();
        Car car_3 = new Car();

        carRepository.save(car_1);
        carRepository.save(car_2);
        carRepository.save(car_3);

        assertThat(carRepository.count()).isEqualTo(3);

        List<Car> listOfCars = carRepository.findAll();
        assertThat(listOfCars.get(0)).isEqualTo(car_1);
        assertThat(listOfCars.get(1)).isEqualTo(car_2);
        assertThat(listOfCars.get(2)).isEqualTo(car_3);

    }

}
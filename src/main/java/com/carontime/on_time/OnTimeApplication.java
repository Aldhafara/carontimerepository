package com.carontime.on_time;

import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.model.car.CarStatus;
import com.carontime.on_time.model.user.User;
import com.carontime.on_time.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.awt.geom.Point2D;

@SpringBootApplication
public class OnTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnTimeApplication.class,args);
    }

    @Autowired
    private CarRepository carRepository;



    //@Override
    public void run(String... strings) throws Exception {
        System.out.println("Hello Spring");

        Car car1 = new Car(1, CarStatus.UNUSED,new Point2D.Double(53.0261829,18.6278931));

        User user1 = new User("Jan","Kowalski","Torun","00521/12/0632","jan.kowalski@poczta.com",734198397,0);

        carRepository.save(car1);

    }
}

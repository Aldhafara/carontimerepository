package com.carontime.on_time;

import com.carontime.on_time.login.Role;
import com.carontime.on_time.login.RoleRepository;
import com.carontime.on_time.repository.UserRepository;
import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.model.car.CarStatus;
import com.carontime.on_time.model.user.User;
import com.carontime.on_time.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OnTimeApplication implements CommandLineRunner{
public class OnTimeApplication implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(OnTimeApplication.class,args);
    }

    @Autowired
    private CarRepository carRepository;



    //@Override
    public void run(String... strings) throws Exception {
        System.out.println("Hello Spring");

        Car car1 = new Car(1, CarStatus.UNUSED,new Point2D.Double(53.0261829,18.6278931));
        carRepository.save(car1);

        Role userRole = roleRepository.save(new Role("USER"));

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        userRepository.save(new User("user", passwordEncoder.encode("user"), userRoles, "Mariusz","Kowalski","Torun","00521","mar.kowalski@poczta.com",734198397,0 ));
    }
}

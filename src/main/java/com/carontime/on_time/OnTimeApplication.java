package com.carontime.on_time;

import com.carontime.on_time.login.Role;
import com.carontime.on_time.login.RoleRepository;
import com.carontime.on_time.model.car.Car;
import com.carontime.on_time.model.car.CarStatus;
import com.carontime.on_time.model.user.User;
import com.carontime.on_time.repository.CarRepository;
import com.carontime.on_time.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OnTimeApplication implements CommandLineRunner{

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

    public void run(String... strings) throws Exception {
        System.out.println("Hello Spring");

        Car car1 = new Car(1, CarStatus.UNUSED,new Point2D.Double(53.0261829,18.6278931));
        //carRepository.save(car1);

        Role adminRole = roleRepository.save(new Role("ADMIN"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);

        //System.out.println("Czy istnieje Admin??: " + !userRepository.findUserByRole(adminRoles).isEmpty());
        //userRepository.save(new User("adminek", passwordEncoder.encode("adminek"), adminRoles, "Aamin","Administratorski","AdminTown","000000000","administrator@carontime.com",666666666,10000000 ));
    }
}

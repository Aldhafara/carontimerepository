package com.carontime.on_time.repository;

import com.carontime.on_time.model.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById (int id);
    Optional<User> findByName(String name);
    Optional<User> findByLastname (String lastname);
    Optional<User> findByCity (String city);
    Optional<User> findByCarLicenceId (String carLicenceId);
    Optional<User> findByEmailAdress (String emailAdress);
    Optional<User> findByPhoneNumber (int phoneNumber);
}

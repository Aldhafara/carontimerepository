package com.carontime.on_time.repository;

import com.carontime.on_time.login.Role;
import com.carontime.on_time.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findUserById (Long id);
    Optional<User> findByName(String name);
    Optional<User> findByLastname (String lastname);
    Optional<User> findByCity (String city);
    Optional<User> findByCarLicenceId (String carLicenceId);
    Optional<User> findByEmailAdress (String emailAdress);
    Optional<User> findByPhoneNumber (Long phoneNumber);
   // List<User> findUserByRole(Set<Role> role);
}

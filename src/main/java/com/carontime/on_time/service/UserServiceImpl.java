package com.carontime.on_time.service;

import com.carontime.on_time.repository.UserRepository;
import com.carontime.on_time.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);

    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }
}

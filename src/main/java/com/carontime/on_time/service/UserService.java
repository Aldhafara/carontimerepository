package com.carontime.on_time.service;

import com.carontime.on_time.forms.UserEditForm;
import com.carontime.on_time.model.user.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    void deleteUser(User user);
    List<User> getAll();
    User updateUserData(User user, UserEditForm userEditForm);
    User getUserByEmail(String email);
    User getUserById(int id);
}
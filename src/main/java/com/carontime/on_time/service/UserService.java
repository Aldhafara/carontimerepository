package com.carontime.on_time.service;

import com.carontime.on_time.forms.UserEditForm;
import com.carontime.on_time.login.Role;
import com.carontime.on_time.model.user.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User addUser(User user);
    void deleteUser(User user);
    List<User> getAll();
    User updateUserData(User user, UserEditForm userEditForm);
    User getUserByEmail(String email);
    User getUserById(Long id);
    User getUserByUsername(String username);

   // List<User> getAllByRole(Set<Role> role);
}
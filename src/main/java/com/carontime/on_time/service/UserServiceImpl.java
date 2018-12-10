package com.carontime.on_time.service;

import com.carontime.on_time.forms.UserEditForm;
import com.carontime.on_time.login.Role;
import com.carontime.on_time.model.user.User;
import com.carontime.on_time.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Override
    public User updateUserData(User user, UserEditForm userEditForm) {
        user.setCarLicenceId(userEditForm.getDriverLicense());
        user.setEmailAdress(userEditForm.getEmail());
        user.setCity(userEditForm.getCity());
        user.setLastname(userEditForm.getLastname());
        user.setName(userEditForm.getName());
        user.setPhoneNumber(userEditForm.getTelephone());
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmailAdress(email).orElse(null);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
/*

    @Override
    public List<User> getAllByRole(Set<Role> roles) {
        // return (List<User>) userRepository.findUserByRole(role).o;
//        List<User> strings = new ArrayList<>();
//        for (User p : getAll()) {
//            if (p.getRoles().equals(role)) {
//                strings.add(p);
//
//            }
//        }
//        return strings;

*/
/*        List<User> strings = new ArrayList<>();
        for (User p : userRepository.findUserByRole(roles)) {
            if (p.getRoles().equals(roles)) {
                strings.add(p);

            }
        }
        return strings;*//*



        return userRepository.findUserByRole(roles);
    }
*/

}

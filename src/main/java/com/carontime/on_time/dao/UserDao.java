package com.carontime.on_time.dao;

import com.carontime.on_time.forms.UserEditForm;
import com.carontime.on_time.model.user.User;

public class UserDao {
    public static UserEditForm toUserForm(User user) {
        UserEditForm userEditForm = new UserEditForm();
        userEditForm.setName(user.getName());
        userEditForm.setLastname(user.getLastname());
        userEditForm.setCity(user.getCity());
        userEditForm.setDriverLicense(user.getCarLicenceId());
        userEditForm.setEmail(user.getEmailAdress());
        userEditForm.setTelephone(user.getPhoneNumber());
        return userEditForm;
    }
}

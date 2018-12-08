package com.carontime.on_time.forms;

import com.carontime.on_time.model.user.User;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class UserEditForm {
    @Pattern(regexp = "^[A-Za-z]{1,32}$", message="Imię musi składać się z liter i być długości od 1 do 32 znaków")
    private String name;
    @Pattern(regexp = "^[A-Za-z \\-]{1,64}$", message="Nazwisko musi składać się z liter i być długości od 1 do 64 znaków")
    private String lastname;
    @Pattern(regexp = "^[A-Za-z \\-]{1,64}$", message="Nazwa miasta musi składać się z liter i być długości od 1 do 64 znaków")
    private String city;
    @Pattern(regexp = "^[\\d]{9}$", message="ID prawa jazdy musi składać się z dziewięciu cyfr")
    private String driverLicense;
    @Pattern(regexp = "^[A-Za-z \\-@]{1,64}$", message="Adres email musi składać się z liter i być długości od 1 do 64 znaków") //TO DO - Email pattern
    private String email;
    @Min(value = 100000000, message = "Niepoprawny numer telefonu")
    @Max(value = 999999999, message = "Niepoprawny numer telefonu")
    private int telephone;

    public UserEditForm() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}

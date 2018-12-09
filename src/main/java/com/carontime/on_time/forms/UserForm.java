package com.carontime.on_time.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class UserForm {

    @Pattern(regexp = "^[A-Za-zĄąĆćĘęŁłŃńÓóŚśŻŹźż]{1,32}$", message="Login musi składać się z liter i być długości od 1 do 32 znaków")
    private String username;
    @Pattern(regexp = "^[A-Za-z\\d]{6,32}$", message = "Hasło musi sie składać z conajmniej 6 znaków")
    private String password;
    @Pattern(regexp = "^[A-Za-z\\d]{6,32}$", message = "Hasło musi sie składać z conajmniej 6 znaków")
    private String confirmpassword;
    @Pattern(regexp = "^[A-Za-zĄąĆćĘęŁłŃńÓóŚśŻŹźż]{1,32}$", message="Imię musi składać się z liter i być długości od 1 do 32 znaków")
    private String name;
    @Pattern(regexp = "^[A-Za-zĄąĆćĘęŁłŃńÓóŚśŻŹźż \\-]{1,64}$", message="Nazwisko musi składać się z liter i być długości od 1 do 64 znaków")
    private String lastname;
    @Pattern(regexp = "^[A-Za-zĄąĆćĘęŁłŃńÓóŚśŻŹźż \\-]{1,64}$", message="Nazwa miasta musi składać się z liter i być długości od 1 do 64 znaków")
    private String city;
    @Pattern(regexp = "^[\\d]{9}$", message="ID prawa jazdy musi składać się z dziewięciu cyfr")
    private String carLicenceId;
    @Pattern(regexp = "^[A-Za-z.\\-@]{1,64}$", message="Adres email musi składać się z liter i być długości od 1 do 64 znaków") //TO DO - Email pattern
    private String emailAdress;
    @Min(value = 100000000, message = "Niepoprawny numer telefonu")
    @Max(value = 999999999, message = "Niepoprawny numer telefonu")
    private int phoneNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

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

    public String getCarLicenceId() {
        return carLicenceId;
    }

    public void setCarLicenceId(String carLicenceId) {
        this.carLicenceId = carLicenceId;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean confirmPassword(){
        return password.equals(confirmpassword);
    }
}

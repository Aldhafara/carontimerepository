package com.carontime.on_time.model.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String city;
    private String carLicenceId;
    private String emailAdress;
    private int phoneNumber;
    private int wallet = 0;

    public User(String name, String lastname, String city, String carLicenceId, String emailAdress, int phoneNumber, int wallet) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.carLicenceId = carLicenceId;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
        this.wallet = wallet;
    }


    @JsonCreator
    public User(@JsonProperty("username") String username, @JsonProperty ("password") String password,@JsonProperty("name") String name, @JsonProperty("lastname") String lastname, @JsonProperty("city") String city, @JsonProperty("carLicenceId") String carLicenceId, @JsonProperty("emailAdress") String emailAdress, @JsonProperty("phoneNumber") int phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.carLicenceId = carLicenceId;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
    }

//    public User(String name, String lastname, String city, String carLicenceId, String emailAdress, int phoneNumber) {
//        this.name = name;
//        this.lastname = lastname;
//        this.city = city;
//        this.carLicenceId = carLicenceId;
//        this.emailAdress = emailAdress;
//        this.phoneNumber = phoneNumber;
//    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username +'\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", carLicenceId='" + carLicenceId + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", wallet=" + wallet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                phoneNumber == user.phoneNumber &&
                wallet == user.wallet &&
                Objects.equals(name, user.name) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(city, user.city) &&
                Objects.equals(carLicenceId, user.carLicenceId) &&
                Objects.equals(emailAdress, user.emailAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, city, carLicenceId, emailAdress, phoneNumber, wallet);
    }
}

package com.carontime.on_time.model.user;

import com.carontime.on_time.login.Role;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    private String name;
    private String lastname;
    private String city;
    private String carLicenceId;
    private String emailAdress;
    private int phoneNumber;
    private int wallet = 0;

    public User(String username, String password, Set<Role> roles, String name, String lastname, String city, String carLicenceId, String emailAdress, int phoneNumber, int wallet) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.carLicenceId = carLicenceId;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
        this.wallet = wallet;
    }

    public User(String username, String password, String name, String lastname,
                String city, String carLicenceId, String emailAdress, int phoneNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.carLicenceId = carLicenceId;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;
    }

    public User(){}

    public Long getId() {
        return id;
    }


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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setId(Long id) {
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
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
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
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(name, user.name) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(city, user.city) &&
                Objects.equals(carLicenceId, user.carLicenceId) &&
                Objects.equals(emailAdress, user.emailAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, roles, name, lastname, city, carLicenceId, emailAdress, phoneNumber, wallet);
    }
}

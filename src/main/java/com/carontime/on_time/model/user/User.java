package com.carontime.on_time.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastname;
    private String city;
    private String carLicenceId;
    private String emailAdress;
    private int phoneNumber;

}

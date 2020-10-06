package models;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Builder
@Getter
@Setter
public class Account {
    String firstName;
    String surNameInitial;
    String email;
    String password;
    String confirmPassword;
    String yearBirth;
    String gender;


    public Account(String firstName, String surNameInitial, String email, String password, String confirmPassword, String yearBirth, String gender) {

        log.info("create account with:\n\nFirst name :" + firstName + "\nSur name initial:" + surNameInitial +
                "\nPassword:" + password + ",\nYear birth:" + yearBirth + "\nGender:" + gender);

        this.firstName = firstName;
        this.surNameInitial = surNameInitial;
        this.email = email;
        this.password = password;
        this.yearBirth = yearBirth;
        this.gender = gender;
        this.confirmPassword = confirmPassword;

    }
}

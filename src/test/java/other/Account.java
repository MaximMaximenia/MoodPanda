package other;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Account {
    String firstName;
    String surNameInitial;
    String email;
    String password;
    String confirmPassword;
    String yearBirth;
    String gender;

    public String getSurName() {
        return surNameInitial;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public String getGender() {
        return gender;
    }

    public Account(String firstName, String surNameInitial, String email, String password,String confirmPassword, String yearBirth, String gender) {
       log.info("create account with first name :"+firstName+"\nsur name initial:"+surNameInitial+
               "\npassword:"+password+",\n year birth:"+yearBirth+"\ngender:"+gender );

        this.firstName = firstName;
        this.surNameInitial = surNameInitial;
        this.email = email;
        this.password = password;
        this.yearBirth = yearBirth;
        this.gender = gender;
        this.confirmPassword = confirmPassword;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurNameInitial() { return surNameInitial; }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurNameInitial(String surName) {
        this.surNameInitial = surName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

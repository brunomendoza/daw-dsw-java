package es.brunomendoza.dsw.dto;

import java.util.Date;

public class CustomerDto {
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String address;
    private String phoneNumber1;
    private String phoneNumber2;
    private String email;
    private String country;

    public CustomerDto(String firstName, String lastName, Date birthdate, String address, String phoneNumber1, String phoneNumber2, String email, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.email = email;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

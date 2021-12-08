package es.brunomendoza.dsw.model;

import java.util.Date;

public class Customer {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private Integer countryId;
    private String address;
    private String phoneNumber1;
    private String phoneNumber2;
    private Date createdAt;

    public Customer(Long id, String username, String password, String firstName, String lastName, Date birthdate, Integer countryId, String address, String phoneNumber1, String phoneNumber2, Date createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.countryId = countryId;
        this.address = address;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
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
}

package com.copious.restAPI.RestApi.Model;


import javax.validation.constraints.NotNull;


public class User
{

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String mobileNumber;
    @NotNull
    private String id_Number;
    private String physical_address;

    public User() {
        super();
    }

    public User(String firstName, String lastName, String mobileNumber, String id_Number, String physical_address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.id_Number = id_Number;
        this.physical_address = physical_address;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getId_Number() {
        return id_Number;
    }

    public void setId_Number(String id_Number) {
        this.id_Number = id_Number;
    }

    public String getPhysical_address() {
        return physical_address;
    }

    public void setPhysical_address(String physical_address) {
        this.physical_address = physical_address;
    }
}

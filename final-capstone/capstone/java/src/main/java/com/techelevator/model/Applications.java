package com.techelevator.model;

public class Applications {
    private int applicationId;
    private String firstName ="";
    private String lastName ="";
    private int socialSecurity;
    private String homeAddress ="";
    private String email ="";
    private String phoneNumber="";
    private String bkgrndCheckApproved = "pending";
    private boolean adminApproval = false;

    public Applications(int applicationId, String firstName, String lastName, String homeAddress, String email, String phoneNumber, String bkgrndCheckApproved, boolean adminApproval) {
        this.applicationId = applicationId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bkgrndCheckApproved = bkgrndCheckApproved;
        this.adminApproval = adminApproval;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
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

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBkgrndCheckApproved() {
        return bkgrndCheckApproved;
    }

    public void setBkgrndCheckApproved(String bkgrndCheckApproved) {
        this.bkgrndCheckApproved = bkgrndCheckApproved;
    }

    public boolean isAdminApproval() {
        return adminApproval;
    }

    public void setAdminApproval(boolean adminApproval) {
        this.adminApproval = adminApproval;
    }
}

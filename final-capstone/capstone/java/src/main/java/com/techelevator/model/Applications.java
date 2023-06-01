package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Applications {
    private int applicationId;
    private String firstName ="";
    private String lastName ="";
    private String dateOfBirth;
    private String homeAddress ="";
    private String availability ="";
    private String schoolMascot ="";
    private String email ="";
    private String phoneNumber="";
    private boolean optInText;
    private boolean experience;
    private boolean transportation;
    private String bkgrndCheckApproved = "pending";
    private String adminApproval = "pending";

    public Applications(int applicationId, String firstName, String lastName, String dateOfBirth, String homeAddress, String availability, String schoolMascot, String email, String phoneNumber, boolean optInText, boolean experience, boolean transportation, String bkgrndCheckApproved, String adminApproval) {
        this.applicationId = applicationId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.homeAddress = homeAddress;
        this.availability = availability;
        this.schoolMascot = schoolMascot;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.optInText = optInText;
        this.experience = experience;
        this.transportation = transportation;
        this.bkgrndCheckApproved = bkgrndCheckApproved;
        this.adminApproval = adminApproval;
    }

    public Applications() {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getSchoolMascot() {
        return schoolMascot;
    }

    public void setSchoolMascot(String schoolMascot) {
        this.schoolMascot = schoolMascot;
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

    public boolean isOptInText() {
        return optInText;
    }

    public void setOptInText(boolean optInText) {
        this.optInText = optInText;
    }

    public boolean isExperience() {
        return experience;
    }

    public void setExperience(boolean experience) {
        this.experience = experience;
    }

    public boolean isTransportation() {
        return transportation;
    }

    public void setTransportation(boolean transportation) {
        this.transportation = transportation;
    }

    public String getBkgrndCheckApproved() {
        return bkgrndCheckApproved;
    }

    public void setBkgrndCheckApproved(String bkgrndCheckApproved) {
        this.bkgrndCheckApproved = bkgrndCheckApproved;
    }

    public String isAdminApproval() {
        return adminApproval;
    }

    public void setAdminApproval(String adminApproval) {
        this.adminApproval = adminApproval;
    }

}

package com.techelevator.dao;

import java.time.LocalDate;
import java.util.*;
import com.techelevator.model.Applications;

public interface ApplicationsDao {
     boolean approveApplication(int applicationId, boolean approval);



    List<Applications> getAllApplications();

    public boolean createApplication(String firstName, String lastName, String date, String homeAddress, String mascot, String email, String phoneNumber, boolean optInText, boolean experience, boolean transportation);

    Applications findById(int applicationId);

    List<Applications> findByFirstName(String firstName);
    List<Applications> findByLastName(String lastName);
}

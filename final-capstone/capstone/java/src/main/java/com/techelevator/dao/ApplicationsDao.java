package com.techelevator.dao;

import java.util.*;
import com.techelevator.model.Applications;

public interface ApplicationsDao {
     boolean approveApplication(int applicationId);



    List<Applications> getAllApplications();

    boolean createApplication(String firstName, String lastName, String homeAddress, String email, String phoneNumber);

    Applications findById(int applicationId);

    List<Applications> findByFirstName(String firstName);
    List<Applications> findByLastName(String lastName);
}

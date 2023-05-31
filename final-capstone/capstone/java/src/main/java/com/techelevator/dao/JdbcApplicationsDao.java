package com.techelevator.dao;

import com.techelevator.model.Applications;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JdbcApplicationsDao implements ApplicationsDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicationsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    boolean approveApplication(int applicationId) {
    }
    @Override
    List<Applications> getAllApplications() {

    }
    boolean createApplication(String firstName, String lastName, String homeAddress, String email, String phoneNumber, String bkgrndCheckApproved, boolean adminApproval) {


    }

    Applications findById(int applicationId) {

    }
    List<Applications> findByFirstName(String firstName) {

    }
    List<Applications> findByLastName(String lastName) {

    }
}

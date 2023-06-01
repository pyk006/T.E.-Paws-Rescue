package com.techelevator.dao;

import com.techelevator.Application;
import com.techelevator.model.Applications;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class JdbcApplicationsDao implements ApplicationsDao {
    private final JdbcTemplate jdbcTemplate;

    public  JdbcApplicationsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override

    public boolean approveApplication(int applicationId, boolean approval) {
        String sql = "UPDATE applications SET admin_approval = NOT ? WHERE application_id = ?; ";
        return jdbcTemplate.update(sql, approval, applicationId) == 1;
    }
    @Override
    public List<Applications> getAllApplications() {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, date_of_birth, home_address, school_mascot, email, " +
                "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval FROM applications;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            applicationsList.add(mapRowToApplications(results));
        }
        return applicationsList;
    }

    public boolean createApplication(String firstName, String lastName, String date, String homeAddress, String mascot, String email, String phoneNumber, boolean optInText, boolean experience, boolean transportation) {
        String sql = "INSERT INTO applications (first_name, last_name, date_of_birth, home_address, school_mascot, email, " +
            "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Pending', false);";
        return jdbcTemplate.update(sql, firstName, lastName, date, homeAddress, mascot, email, phoneNumber, optInText, experience, transportation ) == 1;

    }

    public Applications findById(int applicationId) {
        String sql = "SELECT application_id, first_name, last_name, date_of_birth, home_address, school_mascot, email," +
                "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval FROM applications WHERE application_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, applicationId);
        if (results.next()) {
            return mapRowToApplications(results);
        } else {
            return null;
        }
    }
    public List<Applications> findByFirstName(String firstName) {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, date_of_birth, home_address, school_mascot, email," +
                "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval FROM applications WHERE first_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstName);
        while(results.next()) {
            applicationsList.add(mapRowToApplications(results));
        }
        return applicationsList;
    }
    public List<Applications> findByLastName(String lastName) {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, date_of_birth, home_address, school_mascot, email," +
                "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval FROM applications WHERE last_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, lastName);
        while(results.next()) {
            applicationsList.add(mapRowToApplications(results));
        }
        return applicationsList;
    }

    private Applications mapRowToApplications(SqlRowSet sql) {
        Applications application = new Applications();
        application.setApplicationId(sql.getInt("application_id"));
        application.setFirstName(sql.getString("first_name"));
        application.setLastName(sql.getString("last_name"));
        application.setDateOfBirth((sql.getString("date_of_birth")));
        application.setHomeAddress(sql.getString("home_address"));
        application.setEmail(sql.getString("email"));
        application.setPhoneNumber(sql.getString("phone_number"));
        application.setOptInText(sql.getBoolean("opt_in_text"));
        application.setExperience(sql.getBoolean("experience"));
        application.setTransportation(sql.getBoolean("transportation"));
        application.setBkgrndCheckApproved(sql.getString("bkgrnd_check_approved"));
        application.setAdminApproval(sql.getBoolean("admin_approval"));
        return application;

    }
}

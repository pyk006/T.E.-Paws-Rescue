package com.techelevator.dao;

import com.techelevator.Application;
import com.techelevator.model.Applications;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JdbcApplicationsDao implements ApplicationsDao {
    private final JdbcTemplate jdbcTemplate;

    public  JdbcApplicationsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override

    public boolean approveApplication(int applicationId) {
        String sql = "UPDATE applications SET admin_approval = true WHERE application_id =?; ";
        return jdbcTemplate.update(sql, applicationId) == 1;
    }
    @Override
    public List<Applications> getAllApplications() {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, home_address, email, " +
                "phone_number, bkgrnd_check_approved, admin_approval FROM applications;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            applicationsList.add(mapRowToApplications(results));
        }
        return applicationsList;
    }

    public boolean createApplication(String firstName, String lastName, String homeAddress, String email, String phoneNumber) {
        String sql = "insert into applications (first_name, last_name, home_address, email, " +
            "phone_number) values (?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql, firstName, lastName, homeAddress, email, phoneNumber ) == 1;

    }

    public Applications findById(int applicationId) {
        String sql = "SELECT application_id, first_name, last_name, home_address, email," +
                "phone_number, bkgrnd_check_approved, admin_approval FROM applications WHERE application_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, applicationId);
        if (results.next()) {
            return mapRowToApplications(results);
        } else {
            return null;
        }
    }
    public List<Applications> findByFirstName(String firstName) {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, home_address, email," +
                "phone_number, bkgrnd_check_approved, admin_approval FROM applications WHERE first_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstName);
        while(results.next()) {
            applicationsList.add(mapRowToApplications(results));
        }
        return applicationsList;
    }
    public List<Applications> findByLastName(String lastName) {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, home_address, email," +
                "phone_number, bkgrnd_check_approved, admin_approval FROM applications WHERE last_name = ?";
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
        application.setHomeAddress(sql.getString("home_address"));
        application.setEmail(sql.getString("email"));
        application.setPhoneNumber(sql.getString("phone_number"));
        application.setBkgrndCheckApproved(sql.getString("bkgrnd_check_approved "));
        application.setAdminApproval(sql.getBoolean("admin_approval"));
        return application;

    }
}

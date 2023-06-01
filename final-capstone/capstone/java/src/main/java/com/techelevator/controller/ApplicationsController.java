package com.techelevator.controller;

import com.techelevator.dao.ApplicationsDao;
import com.techelevator.model.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ApplicationsController {
    @Autowired
    ApplicationsDao applicationsDao;

    @RequestMapping(path = "/volunteers", method = RequestMethod.GET)
    public List<Applications> listApplications () {
        return applicationsDao.getAllApplications();
    }

    @PostMapping("/volunteer/submit-form")
    public void createApplication(@RequestBody Applications applications) {
        applicationsDao.createApplication(applications.getFirstName(), applications.getLastName(), applications.getDateOfBirth(), applications.getHomeAddress(), applications.getAvailability(), applications.getSchoolMascot(), applications.getEmail(), applications.getPhoneNumber(), applications.isOptInText(), applications.isExperience(), applications.isTransportation());
    }

    @RequestMapping(path = "/applications", method = RequestMethod.PUT)
    public String approveApplication(@RequestBody Applications applications) {
        return applicationsDao.approveApplication(applications.getApplicationId(), applications.isAdminApproval()) ? "Successfully Approved Application!" : "That didn't work";
    }
}

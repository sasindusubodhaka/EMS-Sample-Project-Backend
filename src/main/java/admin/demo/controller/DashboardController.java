package admin.demo.controller;


import admin.demo.model.Account;
import admin.demo.model.dto.AdminDataCard;
import admin.demo.model.dto.UserCount;
import admin.demo.service.DashboardService;
import admin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "demo")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

    @Autowired
    private UserService userService;

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/getDataCardDetails")
    public List<AdminDataCard> getAdminCardDetails(){
        List<AdminDataCard> cardDetails = dashboardService.getAdminCardDetails();
        return cardDetails;
    }

    @GetMapping("/getRegisteredUsers")
    public ArrayList<Integer> getRegisteredUsers(){
        ArrayList<Integer> registeredList = dashboardService.getRegisteredUsers();
        return registeredList;
    }
    @GetMapping("/getDeptWiseUserCount")
    public List<UserCount> getUserCounts() {
        List<UserCount> userCount = dashboardService.getUserCounts();
        return userCount;
    }




}

package admin.demo.controller;

import admin.demo.model.dto.AdminDataCard;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DashboardControllerTest {

    @Test
    void getAdminCardDetails() {
        DashboardController dashboardController = new DashboardController();
        List<AdminDataCard> cardDetails = dashboardController.getAdminCardDetails();
        assertEquals("Hello", cardDetails);

    }
}
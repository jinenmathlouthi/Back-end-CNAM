package CNAM.example.CNAM.BACKEND.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import CNAM.example.CNAM.BACKEND.Services.DashboardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/invalidBulletinsValideCount")
    public int[] GetNbbulletinsValides() {
        return dashboardService.getBulletinsValidesChartData();
    }

    @GetMapping("/connectedUsersCount")
    public int[] getConnectedUsersCount() {
        return dashboardService.getConnectedUsersChartData();
    }

    @GetMapping("/neverConnectedCount")
    public int[] getNeverConnectedCount() {
        return new int[0];
    }

    @GetMapping("/enteredFactureCount")
    public int[] getFactureCount() {
        return dashboardService.getFactureChartData();
    }

    @GetMapping("/enteredBulletinsCnm")
    public int[] getBulletinsCnamCount() {
        return dashboardService.getBulletinsCnamChartData();
    }

    @GetMapping("/enteredBulletinsAssurance")
    public int[] getBulletinsAssuranceCount() {
        return dashboardService.getBulletinsAssuranceChartData();
    }

    @GetMapping("/adherentsAffiliesMedecinsPharmaciesCount")
    public int[] getAdherentsAffiliesMedecinsPharmaciesCount() {
        return dashboardService.getAdherentsAffiliesMedecinsPharmaciesCount();
    }
}

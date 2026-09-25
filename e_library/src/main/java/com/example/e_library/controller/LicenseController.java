package com.example.e_library.controller;

import com.example.e_library.model.License;
import com.example.e_library.service.LicenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenses")
public class LicenseController {

    private final LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @PostMapping
    public License createLicense(
            @RequestParam int userId,
            @RequestParam int bookId) {

        return licenseService.createLicense(userId, bookId);
    }

    @GetMapping
    public List<License> getAllLicenses() {
        return licenseService.getAllLicenses();
    }

    @GetMapping("/user/{userId}")
    public List<License> getUserLicenses(
            @PathVariable int userId) {

        return licenseService.getUserLicenses(userId);
    }

    @GetMapping("/book/{bookId}")
    public List<License> getBookLicenses(
            @PathVariable int bookId) {

        return licenseService.getBookLicenses(bookId);
    }
}

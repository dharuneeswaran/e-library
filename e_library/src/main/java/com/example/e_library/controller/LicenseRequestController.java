package com.example.e_library.controller;

import com.example.e_library.model.LicenseRequest;
import com.example.e_library.service.LicenseRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/license-requests")
public class LicenseRequestController {

    private final LicenseRequestService requestService;

    public LicenseRequestController(
            LicenseRequestService requestService) {

        this.requestService = requestService;
    }

    @PostMapping
    public LicenseRequest createRequest(
            @RequestParam int userId,
            @RequestParam int bookId) {

        return requestService.createRequest(userId, bookId);
    }

    @GetMapping
    public List<LicenseRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/user/{userId}")
    public List<LicenseRequest> getUserRequests(
            @PathVariable int userId) {

        return requestService.getUserRequests(userId);
    }

    @PutMapping("/{id}/approve")
    public LicenseRequest approveRequest(
            @PathVariable int id) {

        return requestService.approveRequest(id);
    }

    @PutMapping("/{id}/reject")
    public LicenseRequest rejectRequest(
            @PathVariable int id) {

        return requestService.rejectRequest(id);
    }
}

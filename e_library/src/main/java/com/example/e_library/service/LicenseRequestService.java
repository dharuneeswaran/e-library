package com.example.e_library.service;

import com.example.e_library.model.LicenseRequest;
import com.example.e_library.repository.LicenseRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LicenseRequestService {

    private final LicenseRequestRepository requestRepository;

    public LicenseRequestService(
            LicenseRequestRepository requestRepository) {

        this.requestRepository = requestRepository;
    }

    public LicenseRequest createRequest(
            int userId,
            int bookId) {

        LicenseRequest request = new LicenseRequest();

        request.setUserId(userId);
        request.setBookId(bookId);
        request.setRequestDate(LocalDate.now());
        request.setStatus("PENDING");

        return requestRepository.save(request);
    }

    public List<LicenseRequest> getAllRequests() {
        return requestRepository.findAll();
    }

    public List<LicenseRequest> getUserRequests(int userId) {
        return requestRepository.findByUserId(userId);
    }

    public LicenseRequest approveRequest(int id) {

        LicenseRequest request =
                requestRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Request not found"));

        request.setStatus("APPROVED");

        return requestRepository.save(request);
    }

    public LicenseRequest rejectRequest(int id) {

        LicenseRequest request =
                requestRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Request not found"));

        request.setStatus("REJECTED");

        return requestRepository.save(request);
    }
}

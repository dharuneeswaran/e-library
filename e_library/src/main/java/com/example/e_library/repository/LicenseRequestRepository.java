package com.example.e_library.repository;

import com.example.e_library.model.LicenseRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicenseRequestRepository
        extends JpaRepository<LicenseRequest, Integer> {

    List<LicenseRequest> findByUserId(int userId);

    List<LicenseRequest> findByBookId(int bookId);
}

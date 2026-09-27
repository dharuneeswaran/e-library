package com.example.e_library.service;

import com.example.e_library.model.License;
import com.example.e_library.repository.LicenseRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LicenseService {

    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }


    // CREATE LICENSE
    public License createLicense(int userId, int bookId) {

        List<License> existingLicenses =
                licenseRepository.findByUserIdAndBookId(
                        userId,
                        bookId
                );

        for (License license : existingLicenses) {

            if (license.getStatus().equals("ACTIVE")
                    && license.getExpiryDate()
                              .isAfter(LocalDate.now())) {

                throw new RuntimeException(
                        "User already has an active license for this book"
                );
            }
        }


        License license = new License();

        license.setUserId(userId);

        license.setBookId(bookId);

        license.setStartDate(
                LocalDate.now()
        );

        license.setExpiryDate(
                LocalDate.now().plusDays(14)
        );

        license.setStatus("ACTIVE");


        return licenseRepository.save(license);
    }


    // GET ALL LICENSES
    public List<License> getAllLicenses() {

        return licenseRepository.findAll();
    }


    // GET LICENSES BY USER
    public List<License> getUserLicenses(int userId) {

        return licenseRepository.findByUserId(userId);
    }


    // GET LICENSES BY BOOK
    public List<License> getBookLicenses(int bookId) {

        return licenseRepository.findByBookId(bookId);
    }


    // DELETE LICENSE
    public void deleteLicense(int id) {

        if (!licenseRepository.existsById(id)) {

            throw new RuntimeException(
                    "License with ID " + id + " not found"
            );
        }

        licenseRepository.deleteById(id);
    }
}

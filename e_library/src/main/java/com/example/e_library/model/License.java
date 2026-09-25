package com.example.e_library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int licenseId;

    private int userId;

    private int bookId;

    private LocalDate startDate;

    private LocalDate expiryDate;

    private String status;
}

package com.example.e_library.repository;

import com.example.e_library.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicenseRepository extends JpaRepository<License, Integer> {

    List<License> findByUserId(int userId);

    List<License> findByBookId(int bookId);

    List<License> findByUserIdAndBookId(int userId, int bookId);
}

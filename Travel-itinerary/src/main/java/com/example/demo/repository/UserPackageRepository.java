package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.UserPackage;

public interface UserPackageRepository extends JpaRepository<UserPackageRepository, Long> {  
}
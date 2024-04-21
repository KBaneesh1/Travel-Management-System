package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Package;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;

@Repository
public interface PackageRepository extends JpaRepository<Package, Long> {
    @Query("Select p from Package p where p.baseLocation=:baseLocation")
    public List<Package> findByBaseLocation(String baseLocation);
}
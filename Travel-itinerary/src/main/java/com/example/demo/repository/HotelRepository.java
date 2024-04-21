package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Hotel;
import java.util.List;


@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
    @Query("Select h from Hotel h where baseLocation=:baseLocation")
    public List<Hotel> findByBaseLocation(@Param("baseLocation")String baseLocation);
}

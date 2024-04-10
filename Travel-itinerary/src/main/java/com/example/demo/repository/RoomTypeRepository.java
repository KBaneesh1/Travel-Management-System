package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Room;

import java.util.Optional;

@Repository
public interface RoomTypeRepository extends JpaRepository<Room, Long> {

    @Query("SELECT rt.id FROM Room rt WHERE rt.roomType = :roomType")
    Optional<Long> findRoomIdByRoomType(String roomType);

}


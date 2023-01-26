package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.Room;
import org.roronoa.youbooking.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomType(RoomType roomType);
    Room findByReference(String reference);
}
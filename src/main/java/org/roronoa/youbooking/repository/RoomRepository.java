package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
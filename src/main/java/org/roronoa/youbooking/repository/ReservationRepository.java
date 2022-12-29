package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
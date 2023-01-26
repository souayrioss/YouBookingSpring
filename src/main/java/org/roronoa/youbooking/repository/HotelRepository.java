package org.roronoa.youbooking.repository;

import org.roronoa.youbooking.entity.Hotel;
import org.roronoa.youbooking.entity.StatusOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAllByStatusOffer(StatusOffer statusOffer);
}
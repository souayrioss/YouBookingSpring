package org.roronoa.youbooking.service;

import org.roronoa.youbooking.entity.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);
    Reservation getReservation(Reservation reservation);
    List<Reservation> getAllReservations();
    Reservation updateReservation(Reservation reservation);

}

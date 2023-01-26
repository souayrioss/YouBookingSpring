package org.roronoa.youbooking.service.Imp;

import lombok.RequiredArgsConstructor;
import org.roronoa.youbooking.entity.Reservation;
import org.roronoa.youbooking.entity.Room;
import org.roronoa.youbooking.entity.UserApp;
import org.roronoa.youbooking.repository.ReservationRepository;
import org.roronoa.youbooking.repository.RoomRepository;
import org.roronoa.youbooking.service.IReservationService;
import org.roronoa.youbooking.service.IUserService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationServiceImp implements IReservationService {

    private final IUserService userService;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(@Valid Reservation reservation) {
        reservation.setUuid(UUID.randomUUID().toString());
        reservation.setDateReservation(LocalDate.now());
        reservation.setRange(reservation.getDateFin().compareTo(reservation.getDateDebut()));
        UserApp user = userService.getUser(reservation.getUserApp().getUuid());
        if (Objects.isNull(user)) return null;
        reservation.setUserApp(user);
        reservation.setTotalPrice(reservation.getRooms().stream().mapToDouble(room -> room.getPrice()).sum());
        List<Room> rooms = new ArrayList<>();
        for (Room room :reservation.getRooms()){
            room = roomRepository.findByReference(room.getReference());
            if (Objects.isNull(room)) return null;
            reservation.setTotalPrice(reservation.getTotalPrice()+room.getPrice());
            rooms.add(room);
        }
        reservation.setRooms(rooms);
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservation(Reservation reservation) {
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return null;
    }
}

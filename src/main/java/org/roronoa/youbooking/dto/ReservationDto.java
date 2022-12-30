package org.roronoa.youbooking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.roronoa.youbooking.dto.HotelDto;
import org.roronoa.youbooking.dto.UserAppDto;
import org.roronoa.youbooking.entity.Reservation;
import org.roronoa.youbooking.entity.Room;
import org.roronoa.youbooking.entity.RoomType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link Reservation} entity
 */
@Data
public class ReservationDto implements Serializable {

    private final String uuid;
    private final LocalDate dateReservation;
    private final LocalDate dateDebut;
    @NotEmpty
    private final LocalDate dateFin;
    @NotEmpty
    private final int range;
    @NotEmpty
    private final float totalPrice;
    private final List<RoomDto> rooms;
    private final UserAppDto userApp;


}
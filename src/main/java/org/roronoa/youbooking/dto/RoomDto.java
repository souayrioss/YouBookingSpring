package org.roronoa.youbooking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.roronoa.youbooking.entity.RoomType;

import java.io.Serializable;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.Room} entity
 */
@Data
public class RoomDto implements Serializable {

    private final String reference;
    @NotEmpty
    private final float price;
    private final boolean reserved;
    @NotNull
    private final RoomType roomType;
    private final ReservationDto reservation;
    private final HotelDto hotel;
}
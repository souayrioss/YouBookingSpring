package org.roronoa.youbooking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.roronoa.youbooking.dto.HotelDto;
import org.roronoa.youbooking.dto.RoleDto;
import org.roronoa.youbooking.entity.Reservation;
import org.roronoa.youbooking.entity.UserApp;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link UserApp} entity
 */
@Data
public class UserAppDto implements Serializable {

    private final String uuid;
    @NotNull
    @NotEmpty
    private final String fullName;
    @NotNull
    @NotEmpty
    @Email
    private final String email;
    @NotNull
    @NotEmpty
    private final String password;
    @NotNull
    @NotEmpty
    private final String phone;
    private final RoleDto role;
    private final List<HotelDto> hotels;
    private final List<ReservationDto> reservations;

}
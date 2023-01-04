package org.roronoa.youbooking.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    private String uuid;
    @NotNull
    @NotEmpty
    private String fullName;
    @NotNull
    @NotEmpty
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String phone;
    private RoleDto role;

    private List<ReservationDto> reservations;

}
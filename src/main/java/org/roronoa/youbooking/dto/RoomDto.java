package org.roronoa.youbooking.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.roronoa.youbooking.entity.RoomType;

import java.io.Serializable;

/**
 * A DTO for the {@link org.roronoa.youbooking.entity.Room} entity
 */
@Data
public class RoomDto implements Serializable {

    private String reference;
    @NotEmpty
    private float price;
    private boolean reserved;
    private String roomType;
    private ReservationDto reservation;

}
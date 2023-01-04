package org.roronoa.youbooking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Data
public class ReservationDto implements Serializable {

    private String uuid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateReservation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateFin;
    @NotEmpty
    private float totalPrice;
    private List<RoomDto> rooms;
    private UserAppDto userApp;


}
package org.roronoa.youbooking.rest;

import lombok.RequiredArgsConstructor;
import org.roronoa.youbooking.dto.HotelDto;
import org.roronoa.youbooking.dto.ReservationDto;
import org.roronoa.youbooking.dto.ResponseDTO;
import org.roronoa.youbooking.entity.Hotel;
import org.roronoa.youbooking.entity.Reservation;
import org.roronoa.youbooking.service.IReservationService;
import org.roronoa.youbooking.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

import static org.roronoa.youbooking.util.IConstantes.*;

@RestController
@RequestMapping("/api/v1/reservation")
@RequiredArgsConstructor
public class ReservationResource {
    private final IReservationService reservationService;

    @PostMapping(path = "/save")
    public ResponseEntity<ResponseDTO<ReservationDto>> save(@RequestBody @Valid ReservationDto reservationDto){
//        try {
            Reservation reservation = EntityUtils.reservationDTOToReservation(reservationDto);
            reservation = reservationService.addReservation(reservation);
            if (Objects.isNull(reservation)){
                ResponseDTO<ReservationDto> response = new ResponseDTO<>() ;
                response.setStatus(CODE_003 + OR + CODE_004 );
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            ResponseDTO<ReservationDto> response = new ResponseDTO<>() ;
            response.setData(EntityUtils.reservationToReservationDTO(reservation));
            response.setStatus(CODE_001);
            return new ResponseEntity<>(response, HttpStatus.OK);
/*        }catch (Exception e){
            ResponseDTO<ReservationDto> response = new ResponseDTO<>() ;
            response.setStatus(CODE_000);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }*/
    }
}

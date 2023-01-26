package org.roronoa.youbooking.rest;

import lombok.RequiredArgsConstructor;
import org.roronoa.youbooking.dto.HotelDto;
import org.roronoa.youbooking.dto.ResponseDTO;
import org.roronoa.youbooking.dto.UserAppDto;
import org.roronoa.youbooking.entity.Hotel;
import org.roronoa.youbooking.entity.StatusOffer;
import org.roronoa.youbooking.service.IHotelService;
import org.roronoa.youbooking.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.roronoa.youbooking.util.IConstantes.*;

@RestController
@RequestMapping("/api/v1/hotel")
@RequiredArgsConstructor
public class HotelResource {
    private final IHotelService hotelService;
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseDTO<HotelDto>> save(@RequestBody @Valid HotelDto hotelDto){
        try {
            Hotel hotel = EntityUtils.hotelDTOToHotel(hotelDto);
            hotel = hotelService.addHotel(hotel);
            if (Objects.isNull(hotel)){
                ResponseDTO<HotelDto> response = new ResponseDTO<>() ;
                response.setStatus(CODE_003 + OR + CODE_004 );
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            ResponseDTO<HotelDto> response = new ResponseDTO<>() ;
            response.setData(EntityUtils.hotelToHotelDTO(hotel));
            response.setStatus(CODE_001);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDTO<HotelDto> response = new ResponseDTO<>() ;
            response.setStatus(CODE_000);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
    @PostMapping(path = "/AppOrRef")
    public ResponseEntity<ResponseDTO<HotelDto>> ApproveOrRefuse(@RequestBody HotelDto hotelDto){
        try {
            StatusOffer statusOffer;
            if(hotelDto.getStatusOffer().equals("ACCEPTED")) statusOffer = StatusOffer.ACCEPTED;
            else statusOffer = StatusOffer.REFUSED;
            Hotel hotel = hotelService.hotelOffer(hotelDto.getId(),statusOffer);
            if (Objects.isNull(hotel)){
                ResponseDTO<HotelDto> response = new ResponseDTO<>() ;
                response.setStatus("DATA INVALID");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            ResponseDTO<HotelDto> response = new ResponseDTO<>() ;
            response.setData(EntityUtils.hotelToHotelDTO(hotel));
            response.setStatus(CODE_001);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDTO<HotelDto> response = new ResponseDTO<>() ;
            response.setStatus(CODE_000);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/hotels/{status}")
    public ResponseEntity<ResponseDTO<List<HotelDto>>> getHotels(@PathVariable String status){
        try {
            StatusOffer statusOffer;
            if(status.equals("ACCEPTED")) statusOffer = StatusOffer.ACCEPTED;
            else statusOffer = StatusOffer.PENDING;
            List<Hotel> hotels = hotelService.getAllHotels(statusOffer);
            ResponseDTO<List<HotelDto>> response = new ResponseDTO<>() ;
            List<HotelDto> hotelDtoList = hotels.stream().map(hotel -> EntityUtils.hotelToHotelDTO(hotel)).collect(Collectors.toList());
            response.setStatus(CODE_001);
            response.setData(hotelDtoList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDTO<List<HotelDto>> response = new ResponseDTO<>() ;
            response.setStatus(CODE_000);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseDTO<HotelDto>> getHotel(@PathVariable Long id){
        try {
            Hotel hotel = hotelService.getHotel(id);
            ResponseDTO<HotelDto> response = new ResponseDTO<>() ;
            response.setStatus(CODE_001);
            response.setData(EntityUtils.hotelToHotelDTO(hotel));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDTO<HotelDto> response = new ResponseDTO<>() ;
            response.setStatus(CODE_000);
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}

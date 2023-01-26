package org.roronoa.youbooking.util;


import org.modelmapper.ModelMapper;
import org.roronoa.youbooking.dto.HotelDto;
import org.roronoa.youbooking.dto.ReservationDto;
import org.roronoa.youbooking.dto.UserAppDto;
import org.roronoa.youbooking.entity.Hotel;
import org.roronoa.youbooking.entity.Reservation;
import org.roronoa.youbooking.entity.UserApp;


import java.security.SecureRandom;

import static org.roronoa.youbooking.util.IConstantes.CAPS;
import static org.roronoa.youbooking.util.IConstantes.LENGTH;


public class EntityUtils {

    private static final SecureRandom random = new SecureRandom();



    public static String generateReference() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CAPS.length());
            result.append(CAPS.charAt(index));
        }
        return result.toString();
    }



    public static UserAppDto userToUserDTO(UserApp userApp) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userApp, UserAppDto.class);
    }
    public static UserApp userDTOToUser(UserAppDto userAppDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userAppDto, UserApp.class);
    }
    public static Hotel hotelDTOToHotel(HotelDto hotelDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(hotelDto, Hotel.class);
    }
    public static HotelDto hotelToHotelDTO(Hotel hotel) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(hotel, HotelDto.class);
    }
    public static ReservationDto reservationToReservationDTO(Reservation reservation) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(reservation, ReservationDto.class);
    }
    public static Reservation reservationDTOToReservation(ReservationDto reservationDto ) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(reservationDto, Reservation.class);
    }


}

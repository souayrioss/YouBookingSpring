package org.roronoa.youbooking.service;

import org.roronoa.youbooking.entity.Hotel;
import org.roronoa.youbooking.entity.StatusOffer;

import java.util.List;

public interface IHotelService {
    Hotel addHotel(Hotel hotel);
    Hotel getHotel(Long id);
    List<Hotel> getAllHotels(StatusOffer statusOffer);
    Hotel updateHotel(Hotel hotel);
    Hotel hotelOffer(Long id,StatusOffer statusOffer);
}

package org.roronoa.youbooking.service.Imp;

import lombok.RequiredArgsConstructor;
import org.roronoa.youbooking.entity.*;
import org.roronoa.youbooking.repository.HotelRepository;
import org.roronoa.youbooking.repository.ReservationRepository;
import org.roronoa.youbooking.repository.RoleRepository;
import org.roronoa.youbooking.repository.RoomRepository;
import org.roronoa.youbooking.service.*;
import org.roronoa.youbooking.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.*;

@Service
@RequiredArgsConstructor
public class HotelServiceImp implements IHotelService {

    private final IRoomService roomService;
    private final IAttachmentService attachmentService;
    private final HotelRepository hotelRepository;
    private final IUserService userService;
    private final IAddressService addressService;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public Hotel addHotel(@Valid Hotel hotel) {
        try {

            hotel.setUuid(UUID.randomUUID().toString());
            UserApp user = userService.getUser(hotel.getUserApp().getUuid());
            if (Objects.isNull(user)) return null;
            hotel.setUserApp(user);
            hotel.setStatusOffer(StatusOffer.PENDING);
            Address address = addressService.addAddress(hotel.getAddress());
            hotel.setAddress(address);
            hotel = hotelRepository.save(hotel);
            for (Room room : hotel.getRooms()) {
                room.setReference(EntityUtils.generateReference());
                room.setHotel(hotel);
                room.setReserved(false);
                room.setReservations(new ArrayList<>());
                roomService.addRoom(room);
            }
            for (Attachment attachment : hotel.getAttachments()) {
                attachment.setUuid(UUID.randomUUID().toString());
                attachment.setHotel(hotel);
                attachmentService.addAttachment(attachment);
            }
            return hotel;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Hotel getHotel(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isPresent()) {
            return hotel.get();
        }
        return null;
    }

    @Override
    public List<Hotel> getAllHotels(StatusOffer statusOffer) {
        return hotelRepository.findAllByStatusOffer(statusOffer);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return null;
    }

    @Override
    public Hotel hotelOffer(Long id, StatusOffer statusOffer) {
        Hotel hotel = hotelRepository.findById(id).get();
        hotel.setStatusOffer(statusOffer);
        return hotelRepository.save(hotel);
    }
}

package org.roronoa.youbooking.service.Imp;

import lombok.RequiredArgsConstructor;
import org.roronoa.youbooking.entity.Hotel;
import org.roronoa.youbooking.entity.Room;
import org.roronoa.youbooking.entity.RoomType;
import org.roronoa.youbooking.entity.UserApp;
import org.roronoa.youbooking.repository.RoomRepository;
import org.roronoa.youbooking.service.IRoomService;
import org.roronoa.youbooking.service.IUserService;
import org.roronoa.youbooking.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class RoomServiceImp implements IRoomService {
    private final RoomRepository roomRepository;


    @Override
    public Room addRoom(@Valid Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room getByType(RoomType roomType) {
        Optional<Room> room = roomRepository.findByRoomType(roomType);
        if (room.isPresent()) {
            return room.get();
        }
        return null;
    }

    @Override
    public Room getRoom(Room room) {
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }
}

package org.roronoa.youbooking.service;

import org.roronoa.youbooking.entity.Hotel;
import org.roronoa.youbooking.entity.Room;
import org.roronoa.youbooking.entity.RoomType;

import java.util.List;

public interface IRoomService {
    Room addRoom(Room room);

    Room getByType(RoomType roomType);

    Room getRoom(Room room);
    List<Room> getAllRooms();

}

package com.zaid.meeting.booking.system.models.dao;

import java.util.List;

import com.zaid.meeting.booking.system.models.Location;
import com.zaid.meeting.booking.system.models.Room;

public interface RoomDao {

	List<Room> getAllRooms(Location location);

}

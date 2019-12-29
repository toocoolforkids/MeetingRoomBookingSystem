package com.zaid.meeting.booking.system.models.dao.impl;

import java.util.List;
import java.util.Map;

import com.zaid.meeting.booking.system.models.Location;
import com.zaid.meeting.booking.system.models.Room;
import com.zaid.meeting.booking.system.models.dao.RoomDao;

public class InMemoryRoomDao implements RoomDao {

	private final Map<Location, List<Room>> locationToRoomsMap;

	@Override
	public List<Room> getAllRooms(Location location) {
		return locationToRoomsMap.get(location);
	}

	public InMemoryRoomDao(Map<Location, List<Room>> locationToRoomsMap) {
		this.locationToRoomsMap = locationToRoomsMap;
	}

}

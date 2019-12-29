package com.zaid.meeting.booking.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zaid.meeting.booking.system.actors.BookingManager;
import com.zaid.meeting.booking.system.actors.RoomAvailabilityFinder;
import com.zaid.meeting.booking.system.models.Location;
import com.zaid.meeting.booking.system.models.Room;
import com.zaid.meeting.booking.system.models.RoomReservation;
import com.zaid.meeting.booking.system.models.dao.RoomDao;
import com.zaid.meeting.booking.system.models.dao.RoomReservationDao;
import com.zaid.meeting.booking.system.models.dao.impl.InMemoryRoomDao;
import com.zaid.meeting.booking.system.models.dao.impl.InMemoryRoomReservationDao;

public class ApplicationContext {
	private static BookingManager bookingManager = new BookingManager(getInMemoryRoomDao(),
			getInMemoryRoomReservationDao());
	private static RoomAvailabilityFinder roomAvailabilityFinder = new RoomAvailabilityFinder(
			getInMemoryRoomReservationDao());

	public static RoomAvailabilityFinder getBasicRoomAvailabilityFinder() {
		return roomAvailabilityFinder;
	}

	private static RoomReservationDao getInMemoryRoomReservationDao() {
		Map<Room, List<RoomReservation>> roomToReservationsMap = new HashMap<Room, List<RoomReservation>>();
		return new InMemoryRoomReservationDao(roomToReservationsMap);
	}

	public static BookingManager getBasicBookingManager() {
		return bookingManager;
	}

	private static RoomDao getInMemoryRoomDao() {
		Map<Location, List<Room>> locationToRoomsMap = new HashMap<Location, List<Room>>();
		List<Room> roomsInMinatoOffice = new ArrayList<Room>();
		Location minatoOffice = new Location("MinatoOffice");
		roomsInMinatoOffice.add(new Room(minatoOffice, 5));
		locationToRoomsMap.put(minatoOffice, roomsInMinatoOffice);
		RoomDao roomDao = new InMemoryRoomDao(locationToRoomsMap);
		return roomDao;
	}
}

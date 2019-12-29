package com.zaid.meeting.booking.system.actors;

import java.util.List;

import com.zaid.meeting.booking.system.models.Location;
import com.zaid.meeting.booking.system.models.Room;
import com.zaid.meeting.booking.system.models.RoomReservation;
import com.zaid.meeting.booking.system.models.TimeSlot;
import com.zaid.meeting.booking.system.models.dao.RoomDao;
import com.zaid.meeting.booking.system.models.dao.RoomReservationDao;

//TODO Make this an interface if it violates open closed principle with upcoming features
public class BookingManager {

	private final RoomDao roomDao;
	private final RoomReservationDao roomReservationDao;

	public BookingManager(final RoomDao roomDao, final RoomReservationDao roomReservationDao) {
		this.roomDao = roomDao;
		this.roomReservationDao = roomReservationDao;
	}

	public List<Room> getAllRooms(final Location location) {
		return roomDao.getAllRooms(location);
	}
	
	public RoomReservation book(Room roomToBeBookedInMinatoBuilding, TimeSlot timeSlotToBeBookedArround3PM) {
		RoomReservation reservedRoom = roomReservationDao.reserve(roomToBeBookedInMinatoBuilding, timeSlotToBeBookedArround3PM);
		return reservedRoom;
	}

	public RoomReservation getReservation(String id) {
		return roomReservationDao.getById(id);
	}

}

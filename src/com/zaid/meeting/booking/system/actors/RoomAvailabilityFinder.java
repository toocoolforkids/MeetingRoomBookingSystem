package com.zaid.meeting.booking.system.actors;

import java.util.List;

import com.zaid.meeting.booking.system.models.Room;
import com.zaid.meeting.booking.system.models.RoomReservation;
import com.zaid.meeting.booking.system.models.TimeSlot;
import com.zaid.meeting.booking.system.models.dao.RoomReservationDao;

// TODO Make this an interface as and when chances of multiple flavors of availability finder arises
public class RoomAvailabilityFinder {

	private final RoomReservationDao roomReservationDao;

	public RoomAvailabilityFinder(final RoomReservationDao roomReservationDao) {
		this.roomReservationDao = roomReservationDao;
	}

	public List<RoomReservation> getAllReservationsIntersectingWithTheTimeSlot(final Room room, final TimeSlot timeSlotToBeBooked) {
		return roomReservationDao.getAllReservationsIntersectingWithTheTimeSlot(room,timeSlotToBeBooked);
	}

}

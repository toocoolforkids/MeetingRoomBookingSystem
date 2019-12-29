package com.zaid.drivers;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.zaid.meeting.booking.system.ApplicationContext;
import com.zaid.meeting.booking.system.actors.BookingManager;
import com.zaid.meeting.booking.system.actors.RoomAvailabilityFinder;
import com.zaid.meeting.booking.system.models.Location;
import com.zaid.meeting.booking.system.models.Room;
import com.zaid.meeting.booking.system.models.RoomReservation;
import com.zaid.meeting.booking.system.models.TimeSlot;

public class Driver {

	private static BookingManager bookingManager = ApplicationContext.getBasicBookingManager();
	private static RoomAvailabilityFinder roomAvailabilityFinder = ApplicationContext.getBasicRoomAvailabilityFinder();

	public static void main(String[] args) throws Exception {
		TimeSlot timeSlotToBeBooked = new TimeSlot(new Date(), new Date(new Date().getTime() + 300000));
		Room freeRoomToBeBookedInMinatoBuilding = getFreeRoomToBeBookedInMinatoBuilding(timeSlotToBeBooked);
		RoomReservation roomReservation = bookingManager.book(freeRoomToBeBookedInMinatoBuilding, timeSlotToBeBooked);

		if (Objects.isNull(bookingManager.getReservation(roomReservation.getId()))) {
			throw new Exception("Room booking should not fail");
		}
	}

	private static Room getFreeRoomToBeBookedInMinatoBuilding(TimeSlot timeSlotToBeBooked) throws Exception {
		Location minatoOffice = new Location("MinatoOffice");
		List<Room> allRoomsForMinatoOffice = bookingManager.getAllRooms(minatoOffice);
		for (Room room : allRoomsForMinatoOffice) {
			if (isAvailable(room, timeSlotToBeBooked)) {
				return room;
			}
		}
		throw new Exception("No available rooms found!!! Change the time");
	}

	private static boolean isAvailable(Room room, TimeSlot timeSlotToBeBooked) {
		List<RoomReservation> reservations = roomAvailabilityFinder.getAllReservationsIntersectingWithTheTimeSlot(room,
				timeSlotToBeBooked);
		return reservations.isEmpty() ? true : false;
	}

}

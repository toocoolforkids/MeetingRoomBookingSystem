package com.zaid.meeting.booking.system.models;

import java.util.UUID;

public class RoomReservation {

	public TimeSlot getBookedTimeSlot() {
		return bookedTimeSlot;
	}

	public Room getRoom() {
		return room;
	}

	public String getId() {
		return id;
	}

	final private TimeSlot bookedTimeSlot;
	final private Room room;
	final private String id;

	public RoomReservation(final Room room, final TimeSlot bookedTimeSlot) {
		this.id = UUID.randomUUID().toString();
		this.room = room;
		this.bookedTimeSlot = bookedTimeSlot;
	}

	public TimeSlot getTimeSlot() {
		return bookedTimeSlot;
	}

}

package com.zaid.meeting.booking.system.models.dao;

import java.util.List;

import com.zaid.meeting.booking.system.models.Room;
import com.zaid.meeting.booking.system.models.RoomReservation;
import com.zaid.meeting.booking.system.models.TimeSlot;

public interface RoomReservationDao {

	List<RoomReservation> getAllReservationsIntersectingWithTheTimeSlot(Room room, TimeSlot timeSlotToBeBooked);

	RoomReservation reserve(Room roomToBeBookedInMinatoBuilding, TimeSlot timeSlotToBeBookedArround3PM);

	RoomReservation getById(String id);

}

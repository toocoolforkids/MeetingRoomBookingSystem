package com.zaid.meeting.booking.system.models.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.zaid.meeting.booking.system.models.Room;
import com.zaid.meeting.booking.system.models.RoomReservation;
import com.zaid.meeting.booking.system.models.TimeSlot;
import com.zaid.meeting.booking.system.models.dao.RoomReservationDao;

public class InMemoryRoomReservationDao implements RoomReservationDao {

	private final Map<Room, List<RoomReservation>> roomToRervationsMap;

	public InMemoryRoomReservationDao(Map<Room, List<RoomReservation>> roomToReservationsMap) {
		this.roomToRervationsMap = roomToReservationsMap;
	}

	@Override
	public List<RoomReservation> getAllReservationsIntersectingWithTheTimeSlot(Room room, TimeSlot timeSlotToBeBooked) {
		synchronized (room.getId()) {
			List<RoomReservation> reservations = roomToRervationsMap.get(room);
			if (Objects.isNull(reservations))
				return new ArrayList<RoomReservation>();
			List<RoomReservation> allReservationIntersecting = new ArrayList<RoomReservation>();
			for (RoomReservation reservation : reservations) {
				if (isIntersecting(reservation.getTimeSlot(), timeSlotToBeBooked)) {
					allReservationIntersecting.add(reservation);
				}
			}
			return allReservationIntersecting;
		}
	}

	private boolean isIntersecting(TimeSlot timeSlot, TimeSlot timeSlotToBeBooked) {
		return lieInside(timeSlot, timeSlotToBeBooked) || lieInside(timeSlotToBeBooked, timeSlot);
	}

	private boolean lieInside(TimeSlot timeSlot, TimeSlot timeSlotToBeBooked) {
		if (timeSlot.getStartTime().before(timeSlotToBeBooked.getEndTime())
				&& timeSlot.getStartTime().after(timeSlotToBeBooked.getStartTime())) {
			return true;
		} else if (timeSlot.getEndTime().before(timeSlotToBeBooked.getEndTime())
				&& timeSlot.getEndTime().after(timeSlotToBeBooked.getStartTime())) {
			return true;
		} else
			return false;
	}

	@Override
	public RoomReservation reserve(Room room, TimeSlot timeSlotToBeBooked) {
		RoomReservation reservation = new RoomReservation(room, timeSlotToBeBooked);
		if (Objects.isNull(roomToRervationsMap.get(room))) {
			roomToRervationsMap.put(room, new ArrayList<>());
		}
		roomToRervationsMap.get(room).add(reservation);
		return reservation;
	}

	@Override
	public RoomReservation getById(String id) {
		for (List<RoomReservation> roomReservations : roomToRervationsMap.values()) {
			for (RoomReservation roomReservation : roomReservations) {
				if (roomReservation.getId().equals(id)) {
					return roomReservation;
				}
			}
		}
		return null;
	}

}

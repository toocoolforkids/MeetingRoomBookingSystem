package com.zaid.meeting.booking.system.models;

import java.util.UUID;

public class Room {
	private final String id;
	private final Location officeLocation;
	private final Integer capacity;

	public Room(final Location officeLocation, final int capacity) {
		this.officeLocation = officeLocation;
		this.capacity = capacity;
		this.id = UUID.randomUUID().toString();
	}

	@Override
	public boolean equals(Object obj) {
		Room other = (Room) obj;
		if(isMismatch(id, other.id))return false;
		if(isMismatch(officeLocation, other.officeLocation))return false;
		if(isMismatch(capacity, other.capacity))return false;
		return true;
	}

	private boolean isMismatch(Object obj1, Object obj2) {
		if(obj1 == null && obj2 == null) {
			return false;
		}
		if(obj2 == null)return true;
		if(obj1 == null)return true;
		if(obj1.equals(obj2))return false;
		return true;
	}
	

	@Override
	public int hashCode() {
		return id.hashCode()+officeLocation.hashCode()+capacity.hashCode();
	}

	public String getId() {
		return this.id;
	}

}

package com.zaid.meeting.booking.system.models;

public class Location {

	private final String location;

	@Override
	public boolean equals(Object obj) {
		Location other = (Location) obj;
		return location.equals(other.location);
	}

	@Override
	public int hashCode() {
		return location.hashCode();
	}

	public Location(final String location) {
		this.location = location;
	}

}

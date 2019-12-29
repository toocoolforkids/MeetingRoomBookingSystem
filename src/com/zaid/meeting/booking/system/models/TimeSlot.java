package com.zaid.meeting.booking.system.models;

import java.util.Date;

public class TimeSlot {

	public Date getEndTime() {
		return endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	private final Date endTime;
	private final Date startTime;

	public TimeSlot(final Date startTime, final Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

}

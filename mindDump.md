Questions and assumptions:
1. Should people also be considered in the booking or just the availability of room matters?? 
2. Targeted users-> Number of users that are going to use this service??2,000 Number of rooms??500 Number of locations?100


Flow:
A user comes
enters location
systems shows room
selects date
selects room
A system will show the available time slots during that day
user select one among available time slots
system will return a message showing room booked

A user come
enter location
system show all rooms
selects date
selects room
A system will show the available time slots during that day
user select one among available time slots
system will return a message showing that room is not booked, as it got booked (Possible reasons: It was available earlier when it was fetched, but becomes unavailable when booking is tried)


Models:
Actors
BookingManager
	List<Room> getAllRooms(Location location);
	List<TimeSlot> getAllAvailableTimeSlots(Room room, Time time);
	RoomReservation book(Room roomToBeBooked, TimeSlot timeSlot);
	
	
RoomAvailibilityFinder
	List<TimeSlot> getAllBookedTimeSlots(Room room, Time time);




Model:
Location
	String location

Room
	String id
	Location location
	Integer capacity
	
TimeSlot
	Time startingTime
	Time endTime

RoomReservation
	Room room
	TimeSlot bookedTimeSlot



ModelDao:
RoomDao

RoomReservationDao



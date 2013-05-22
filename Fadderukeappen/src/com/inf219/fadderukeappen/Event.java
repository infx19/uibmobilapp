package com.inf219.fadderukeappen;

/**
 * Event contains all information about an event.
 * This includes information about time, location, name and more.
 * 
 * @author Marianne
 */
public class Event implements Comparable<Event> {
	private long id;
	private String title;
	private String location;
	private Date date;
	private Time time;

	/**
	 * Sets the event's information. The parameters are given as objects. 
	 *
	 * @param title The title of the event
	 * @param location The location of the event
	 * @param date The event's date
	 * @param time The event's time
	 */
	public Event(String title, String location, Date date, Time time) {
		super();
		this.title = title;
		this.location = location;
		this.date = date;
		this.time = time;
	}

	/**
	 * Sets the event's information. The parameters are given as strings. 
	 * 
	 * @param title The title of the event
	 * @param location The location of the event
	 * @param date The event's date
	 * @param startTime The starting time of the event
	 * @param durationTime The duration of the event 
	 */
	public Event(String title, String location, String date, String startTime, String durationTime) {
		this(title, location, new Date(date), new Time(startTime, durationTime));
	}

	/**
	 * Empty constructor 
	 */
	public Event() {
	}

	/**
	 * @return the Event's ID
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the ID of the event
	 * @param id The event's ID
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title of the event
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the event
	 * 
	 * @param title The event's title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return The event's location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the title of the event
	 * 
	 * @param location the event's location 
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return The event's date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date of the event
	 * @param Date the event's date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return The event's time information
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * Sets the time of the event
	 * 
	 * @param time The event's time
	 */
	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public int compareTo(Event anotherEvent) {
		if (this.getDate().compareTo(anotherEvent.getDate()) == 0) {
			if (this.getTime().compareTo(anotherEvent.getTime()) == 0) {
				return this.getTitle().compareTo(anotherEvent.getTitle());
			} else {
				return this.getTime().compareTo(anotherEvent.getTime());
			}
		} else {
			return this.getDate().compareTo(anotherEvent.getDate());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Event)) {
			return false;
		} else {
			Event compEvent = (Event) o;
			return this.compareTo(compEvent) == 0;
		}

	}
}

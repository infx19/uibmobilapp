package com.inf219.fadderukeappen;

/**
 * Copyright 2013 Marianne Grov and Johan Rusvik
 * 
 * This file is part of Fadderukeappen.
 * Fadderukeappen is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Fadderukeappen is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Fadderukeappen. If not, see <http://www.gnu.org/licenses/>.
 *
 */

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
				int comp = this.getTitle().compareTo(anotherEvent.getTitle());
				if(comp > 0) return 1;
				else if (comp < 0) return -1;
				else return 0;
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

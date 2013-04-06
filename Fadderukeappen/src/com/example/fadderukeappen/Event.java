package com.example.fadderukeappen;

public class Event implements Comparable<Event> {
	private long id;
	private String title;
	private String location;
	private Date date;
	private Time time;

	public Event(String title, String location, Date date, Time time) {
		super();
		this.title = title;
		this.location = location;
		this.date = date;
		this.time = time;
	}

	public Event(String title, String location, String date, String startTime, String durationTime) {
		this(title, location, new Date(date), new Time(startTime, durationTime));
	}

	public Event() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public int compareTo(Event another) {
		if (this.getDate().compareTo(another.getDate()) == 0) {
			if (this.getTime().compareTo(another.getTime()) == 0) {
				return this.getTitle().compareTo(another.getTitle());
			} else {
				return this.getTime().compareTo(another.getTime());
			}
		} else {
			return this.getDate().compareTo(another.getDate());
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

package com.example.fadderukeappen;

public class Time implements Comparable<Time> {
	HoursAndMins start;
	HoursAndMins duration;
	HoursAndMins end;

	public Time(int startHour, int startMinutes, int durationHour,
			int durationMinutes) {
		super();
		start = new HoursAndMins(startHour, startMinutes);
		duration = new HoursAndMins(durationHour, durationMinutes);
		end = HoursAndMins.addHoursAndMins(start, duration);
	}

	public HoursAndMins getStart() {
		return start;
	}

	public void setStart(HoursAndMins start) {
		this.start = start;
	}

	public HoursAndMins getDuration() {
		return duration;
	}

	public void setDuration(HoursAndMins duration) {
		this.duration = duration;
	}

	public HoursAndMins getEnd() {
		return end;
	}

	public void setEnd(HoursAndMins end) {
		this.end = end;
	}

	public String toString() {
		return start.toString() + " - " + end.toString();
	}
	
	@Override
	public int compareTo(Time another) {
		int comp = this.getStart().compareTo(another.getStart());
		if (comp != 0) {
			return comp;
		} else {
			return this.getEnd().compareTo(another.getEnd());
		}
	}

}

package com.inf219.fadderukeappen;

public class Time implements Comparable<Time> {
	private HoursAndMins start;
	private HoursAndMins duration;
	private HoursAndMins end;

	public Time(int startHour, int startMinutes, int durationHour,
			int durationMinutes) {
		super();
		start = new HoursAndMins(startHour, startMinutes);
		duration = new HoursAndMins(durationHour, durationMinutes);
		end = HoursAndMins.calculateEndTime(start, duration);
	}

	public Time(String startTime, String durationTime) {
		super();
		start = HoursAndMins.convertToHoursAndMins(startTime);
		duration = HoursAndMins.convertToHoursAndMins(durationTime);
		end = HoursAndMins.calculateEndTime(start, duration);
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
	public int compareTo(Time anotherTime) {
		int comp = this.getStart().compareTo(anotherTime.getStart());
		if (comp != 0) {
			return comp;
		} else {
			return this.getEnd().compareTo(anotherTime.getEnd());
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Time)) {
			return false;
		} else {
			Time comp = (Time) o;
			return this.compareTo(comp) == 0;
		}
		
	}

}

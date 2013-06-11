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

package com.example.fadderukeappen;

import java.util.Locale;

public class HoursAndMins implements Comparable<HoursAndMins> {
	final static int MINUTES_IN_HOUR = 60;
	final static int HOURS_IN_DAY = 24;
	int hours;
	int minutes;

	HoursAndMins(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public String toString() {
		return String.format(Locale.ENGLISH, "%02d:%02d\n", hours, minutes);
	}

	@Override
	public int compareTo(HoursAndMins another) {
		if (this.getHours() > another.getHours())
			return 1;
		else if (this.getHours() < another.getHours())
			return -1;
		else {
			if (this.getMinutes() == another.getMinutes())
				return 0;
			else if (this.getMinutes() > another.getMinutes())
				return 1;
			else
				return -1;

		}
	}

	public static HoursAndMins addHoursAndMins(HoursAndMins start,
			HoursAndMins duration) {
		int hourSum = start.getHours() + duration.getHours();
		int minSum = start.getMinutes() + duration.getMinutes();

		if (minSum > MINUTES_IN_HOUR) {
			hourSum++;
			minSum -= MINUTES_IN_HOUR;
		}

		if (hourSum >= HOURS_IN_DAY) {
			hourSum -= HOURS_IN_DAY;
		}
		return new HoursAndMins(hourSum, minSum);
	}
}

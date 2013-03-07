package com.example.fadderukeappen;

public class Date implements Comparable<Date> {
	int year;
	int month;
	int day;

	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Date(String date) {
		super();
		// konvertere streng til int-verdier
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public String toString() {
		return String.format("%02d.%02d.%d", day, month, year);
		
	}

	@Override
	public int compareTo(Date another) {
		if (this.getYear() != another.getYear()) {
			if (this.getYear() > another.getYear()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			if (this.getMonth() != another.getMonth()) {
				if (this.getMonth() > another.getMonth()) {
					return 1;
				} else {
					return -1;
				}
			} else {
				if (this.getDay() == another.getDay()) {
					return 0;
				} else if (this.getDay() > another.getDay()) {
					return 1;
				} else {
					return -1;
				}
			}
		}
	}
}

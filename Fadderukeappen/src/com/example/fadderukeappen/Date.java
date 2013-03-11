package com.example.fadderukeappen;

import android.util.Log;

public class Date implements Comparable<Date> {
	final static int[] DAYS_IN_MONTH = {31,28,31,30,31,30,31,31,30,31,30,31};
	final static int MONTHS_IN_YEAR = 12;
	
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
		String[] parts = date.split("\\.");
		Log.d("DEBUG", "LENGTH OF STRING: " + parts.length);
		for(int i = 0; i < parts.length; i++) {
			Log.d("DEBUG", "INNHOLD I " + (i+1) + parts[i]);
		}
		this.day = Integer.parseInt(parts[0]);
		this.month = Integer.parseInt(parts[1]);
		this.year = Integer.parseInt(parts[2]);
		
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

	public Date nextDate() {
		int day = getDay();
		int month = getMonth();
		int year = getYear();
		
		if(getDay() == DAYS_IN_MONTH[getMonth()-1]) {
			day = 1;
			if(getMonth() == MONTHS_IN_YEAR) {
				month = 1;
				year++;
			} else {
				month++;
			}
			
		} else {
			day++;
		}
		
		return new Date(year, month, day);
	}
}

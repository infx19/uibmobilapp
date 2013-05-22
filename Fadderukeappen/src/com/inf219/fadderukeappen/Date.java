package com.inf219.fadderukeappen;


/**
 * Date contains information about day, month and year.
 * 
 * @author Marianne
 *
 */
public class Date implements Comparable<Date> {
	final static int[] DAYS_IN_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	final static int MONTHS_IN_YEAR = 12;

	int year;
	int month;
	int day;

	/**
	 * Constructor that sets the year, month and day of the date
	 * 
	 * @param year The date's year 
	 * @param month The date's month
	 * @param day The date's day number
	 */
	public Date(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 *  * Constructor that sets the year, month and day of the date
	 * 
	 * @param date The date given as a string on the format DD.MM.YYYY
	 */
	public Date(String date) {
		super();
		String[] parts = date.split("\\.");
		this.day = Integer.parseInt(parts[0]);
		this.month = Integer.parseInt(parts[1]);
		this.year = Integer.parseInt(parts[2]);

	}

	/**
	 * @return The year of the date
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year of the date
	 * 
	 * @param year The year of the date
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return The date's month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Sets the date's month
	 * 
	 * @param month The date's month number
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return The date's day number
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Sets the date's day number
	 * 
	 * @param day The date's day number
	 */
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

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Date)) {
			return false;
		} else {
			Date comp = (Date) o;
			return this.compareTo(comp) == 0;
		}

	}

	/**
	 * This function returns the following date after this date
	 * @return The next date
	 */
	public Date nextDate() {
		int day = getDay();
		int month = getMonth();
		int year = getYear();

		if (getDay() == DAYS_IN_MONTH[getMonth() - 1]) {
			day = 1;
			if (getMonth() == MONTHS_IN_YEAR) {
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

	/**
	 * This function returns the previous date, the date before this date
	 * @return The previous date
	 */
	public Date prevDate() {
		int day = getDay();
		int month = getMonth();
		int year = getYear();

		if (getDay() == 1) {
			day = DAYS_IN_MONTH[getMonth() - 1];
			if (getMonth() == 1) {
				month = MONTHS_IN_YEAR;
				year--;
			} else {
				month--;
			}

		} else {
			day--;
		}

		return new Date(year, month, day);
	}
}

package com.inf219.fadderukeappen;

import static org.junit.Assert.*;

//import static org.hamcrest.core.Is.*;
//import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

import com.inf219.fadderukeappen.Date;

public class DateTest {

	private Date testDate1;
	private Date testDate2;

	@Before
	public void setUp() throws Exception {
		String testDateString = "01.01.2013";
		testDate1 = new Date(2013,1,1);
		testDate2 = new Date(testDateString);
	}

	@Test
	public void testConstructors() {

		for(int year = 1999; year <2001; year++) {
			for(int month = 1; month < 12; month++) {
				for(int day = 1; day < Date.DAYS_IN_MONTH[month]; day++) {
					testDate1 = new Date(String.format("%02d.%02d.%d", day, month, year));
					testDate2 = new Date(year, month, day);
					assertEquals(testDate1, testDate2);

				}
			}
		}
	}

	@Test
	public void testToString() {
		for(int year = 1999; year <2001; year++) {
			for(int month = 1; month < 12; month++) {
				for(int day = 1; day < Date.DAYS_IN_MONTH[month]; day++) {
					testDate1 = new Date(String.format("%02d.%02d.%d", day, month, year));
					testDate2 = new Date(year, month, day);
					assertEquals(testDate1.toString(), testDate2.toString());
				}
			}
		}

	}

	@Test
	public void testCompareTo() {
		for(int year = 1999; year <2001; year++) {
			for(int month = 1; month < 12; month++) {
				for(int day = 1; day < Date.DAYS_IN_MONTH[month]; day++) {

					for(int year2 = 1999; year2 <2001; year2++) {
						for(int month2 = 1; month2 < 12; month2++) {
							for(int day2 = 1; day2 < Date.DAYS_IN_MONTH[month2]; day2++) {
								testDate1 = new Date(year, month, day);
								testDate2 = new Date(year2, month2, day2);

								int expected = 0;
								if(year > year2) {
									expected = 1;
								} else if (year < year2) {
									expected = -1;
								} else {
									if(month > month2) {
										expected = 1;
									} else if (month < month2) {
										expected = -1;
									} else {
										if(day > day2) {
											expected = 1;
										} else if (day < day2) {
											expected = -1;
										} else {
											expected = 0;
										}
									}

								}
								assertEquals(testDate1.compareTo(testDate2), expected);
							}
						}
					}

				}
			}
		}
	}

	@Test
	public void testEquals() {
		for(int year = 1999; year <2001; year++) {
			for(int month = 1; month < 12; month++) {
				for(int day = 1; day < Date.DAYS_IN_MONTH[month]; day++) {

					for(int year2 = 1999; year2 <2001; year2++) {
						for(int month2 = 1; month2 < 12; month2++) {
							for(int day2 = 1; day2 < Date.DAYS_IN_MONTH[month2]; day2++) {
								testDate1 = new Date(year, month, day);
								testDate2 = new Date(year2, month2, day2);

								int expected = 0;
								if(year > year2) {
									expected = 1;
								} else if (year < year2) {
									expected = -1;
								} else {
									if(month > month2) {
										expected = 1;
									} else if (month < month2) {
										expected = -1;
									} else {
										if(day > day2) {
											expected = 1;
										} else if (day < day2) {
											expected = -1;
										} else {
											expected = 0;
										}
									}

								}
								if(expected == 0) {
									assertEquals(testDate1, testDate2);
								} else {
									assertNotEquals(testDate1, testDate2);
								}

							}
						}
					}

				}
			}
		}
	}

	@Test
	public void testNextDate() {

		for(int year = 1999; year <2001; year++) {
			for(int month = 1; month <= 12; month++) {
				for(int day = 1; day <= Date.DAYS_IN_MONTH[month-1]; day++) {
					testDate1 = new Date(year, month, day);
					
					if(day < Date.DAYS_IN_MONTH[month-1])
						testDate2 = new Date(year, month, day+1);
					else {
						if(month < 12)
							testDate2 = new Date(year, month+1, 1);
						else {
							testDate2 = new Date(year+1, 1, 1);
						}
						
					}
					assertEquals(testDate1.nextDate(), testDate2);
				}
			}
		}

	}

	@Test
	public void testPrevDate() {
		for(int year = 1999; year <2001; year++) {
			for(int month = 1; month <= 12; month++) {
				for(int day = 1; day <= Date.DAYS_IN_MONTH[month-1]; day++) {
					testDate1 = new Date(year, month, day);
					
					if(day > 1)
						testDate2 = new Date(year, month, day-1);
					else {
						if(month > 1)
							testDate2 = new Date(year, month-1, Date.DAYS_IN_MONTH[month-1]);
						else {
							testDate2 = new Date(year-1, 12, Date.DAYS_IN_MONTH[11]);
						}
						
					}
					assertEquals(testDate1.previousDate(), testDate2);
				}
			}
		}
	}
}

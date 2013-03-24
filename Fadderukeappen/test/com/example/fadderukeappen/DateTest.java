package com.example.fadderukeappen;

import static org.junit.Assert.*;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

public class DateTest {
	
	private Date testDate1;
	private Date testDate2;
	private Date testDate3;
	
	private String testDateString;
	private int dateOutputLength;

	@Before
	public void setUp() throws Exception {
		testDateString = "01.01.2013";
		dateOutputLength = testDateString.length();
		testDate1 = new Date(2013,1,1);
		testDate2 = new Date(testDateString);
		testDate3 = new Date(2013,10,31);
		
	}

	@Test
	public void testConstructors() {
		assertThat(testDate1,is(testDate2));
	}
	
	@Test
	public void testToString() {
		assertThat(testDate1.toString().length(), is(dateOutputLength));
		assertThat(testDate2.toString().length(), is(dateOutputLength));
	}
	
	@Test
	public void testCompareTo() {
		assertThat(testDate1.compareTo(new Date(2012,1,1)),is(1));
		assertThat(testDate1.compareTo(new Date(2013,1,2)),is(-1));
	}
	
	@Test
	public void testEquals() {
		assertThat(testDate1.equals(testDate2),is(true));
		assertThat(testDate1.equals(testDate3),is(false));
	}
	
	@Test
	public void testNextDate() {
		Date next = testDate1.nextDate();
		assertThat(next.getDay(),is(testDate1.getDay()+1));
		next = testDate3.nextDate();
		assertThat(next.getDay(),is(1));
		assertThat(next.getMonth(), is(testDate3.getMonth()+1));
	}
	
	@Test
	public void testPrevDate() {
		Date prev = testDate1.prevDate();
		assertThat(prev.getDay(), is(31));
		assertThat(prev.getMonth(),is(12));
		assertThat(prev.getYear(),is(testDate1.getYear()-1));
		prev = testDate3.prevDate();
		assertThat(prev.getDay(),is(testDate3.getDay()-1));
	}

}

package com.example.fadderukeappen;

import static org.junit.Assert.*;

//import static org.hamcrest.core.Is.*;
//import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Before;
import org.junit.Test;

import com.inf219.fadderukeappen.Date;

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
		assertEquals(testDate1, testDate2);
	}
	
	@Test
	public void testToString() {
		assertEquals(testDate1.toString().length(), dateOutputLength);
		assertEquals(testDate2.toString().length(), dateOutputLength);
		assertEquals(testDate1.toString(), testDate2.toString());
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(testDate1.compareTo(new Date(2012,1,1)),1);
		assertEquals(testDate1.compareTo(new Date(2013,1,2)),-1);
	}
	
	@Test
	public void testEquals() {
		assertTrue(testDate1.equals(testDate2));
		assertFalse(testDate1.equals(testDate3));
	}
	
	@Test
	public void testNextDate() {
		Date next = testDate1.nextDate();
		assertEquals(next.getDay(),testDate1.getDay()+1);
		next = testDate3.nextDate();
		assertEquals(next.getDay(),1);
		assertEquals(next.getMonth(), testDate3.getMonth()+1);
	}
	
	@Test
	public void testPrevDate() {
		Date prev = testDate1.prevDate();
		assertEquals(prev.getDay(), 31);
		assertEquals(prev.getMonth(), 12);
		assertEquals(prev.getYear(), testDate1.getYear()-1);
		prev = testDate3.prevDate();
		assertEquals(prev.getDay(), testDate3.getDay()-1);
	}
}

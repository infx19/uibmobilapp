package com.example.fadderukeappen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.inf219.fadderukeappen.Date;
import com.inf219.fadderukeappen.Event;
import com.inf219.fadderukeappen.Time;

public class EventTest {
	
	private Event testObject1;
	private Event testObject2;
	

	@Before
	public void setUp() throws Exception {
		testObject1 = new Event("test", "location", new Date(2000, 3, 12), new Time("10:15", "01:45"));
		
	}

	@Test
	public void testConstructors() {
		Date date = new Date(2013,5,30);
		Time time = new Time("12:00", "02:00");
		
		testObject1 = new Event("tittel", "sted", date, time);
		testObject2 = new Event("tittel", "sted", date.toString(), time.getStart().toString(), time.getDuration().toString());
	
		
		assertEquals(testObject1.getTitle(), testObject2.getTitle());
		assertEquals(testObject1.getLocation(), testObject2.getLocation());
		assertEquals(testObject1.getDate(), testObject2.getDate());
		assertEquals(testObject1.getTime(), testObject2.getTime());
	}
	
	@Test
	public void testEquals() {
		testObject1 = new Event("test", "location", new Date(2000, 3, 12), new Time("10:15", "01:45"));
		testObject2 = new Event("test", "location", new Date(2000, 3, 12), new Time("10:15", "01:45"));
		assertEquals(testObject1, testObject1);
		assertEquals(testObject1, testObject2);
		
		testObject2 = new Event("test", "location", new Date(2000, 3, 12), new Time("10:15", "01:46"));
		assertNotEquals(testObject1, testObject2);
		
		testObject2 = new Event("test", "location", new Date(2000, 3, 12), new Time("11:15", "01:45"));
		assertNotEquals(testObject1, testObject2);
		
		testObject2 = new Event("test", "location", new Date(2000, 3, 17), new Time("10:15", "01:45"));
		assertNotEquals(testObject1, testObject2);
		
		testObject2 = new Event("other_test", "location", new Date(2000, 3, 12), new Time("10:15", "01:45"));
		assertNotEquals(testObject1, testObject2);
	}
	
	@Test
	public void testCompareTo() {
		testObject1 = new Event("test", "location", new Date(2000, 3, 12), new Time("10:15", "01:45"));
		testObject2 = new Event("test", "location", new Date(2000, 3, 12), new Time("10:15", "01:45"));
		assertEquals(0,testObject1.compareTo(testObject1));
		assertEquals(0,testObject1.compareTo(testObject2));
		
		testObject2 = new Event("utest", "location", new Date(2000, 3, 12), new Time("10:15", "01:45"));
		assertEquals(-1,testObject1.compareTo(testObject2));
		
		testObject2 = new Event("atest", "location", new Date(2000, 3, 12), new Time("10:15", "01:45"));
		assertEquals(1,testObject1.compareTo(testObject2));
		
		testObject2 = new Event("test", "location", new Date(2000, 3, 12), new Time("11:15", "01:45"));
		assertEquals(-1,testObject1.compareTo(testObject2));
		
		testObject2 = new Event("test", "location", new Date(2000, 3, 12), new Time("09:15", "01:45"));
		assertEquals(1,testObject1.compareTo(testObject2));
		
		testObject2 = new Event("test", "location", new Date(2000, 4, 12), new Time("10:15", "01:45"));
		assertEquals(-1,testObject1.compareTo(testObject2));
		
		testObject2 = new Event("test", "location", new Date(2000, 2, 12), new Time("10:15", "01:45"));
		assertEquals(1,testObject1.compareTo(testObject2));
		
	}

}

package com.example.fadderukeappen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	
	private Time testObject1;
	private Time testObject2;
	private Time testObject3;

	@Before
	public void setUp() throws Exception {
		testObject1 = new Time(5,5,5,5);
		testObject2 = new Time("05:05", "05:05");
		testObject3 = new Time(5,5,5,4);
	}

	@Test
	public void testConstructors() {
		assertEquals(testObject1, testObject2);
	}
	
	@Test
	public void testCompareTo() {
		assertEquals(testObject1.compareTo(testObject3), 1);
		assertEquals(testObject3.compareTo(testObject1), -1);
		assertEquals(testObject1.compareTo(testObject2), 0);
	}
	
	@Test
	public void testEquals() {
		assertTrue(testObject1.equals(testObject2));
		assertFalse(testObject1.equals(testObject3));
	}

}

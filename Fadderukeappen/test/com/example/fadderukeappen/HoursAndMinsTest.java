package com.example.fadderukeappen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HoursAndMinsTest {

	private HoursAndMins testObject1;
	private HoursAndMins testObject2;
	private HoursAndMins testObject3;

	@Before
	public void setUp() throws Exception {
		testObject1 = new HoursAndMins(5, 5);
		testObject2 = new HoursAndMins(10, 59);
		testObject3 = new HoursAndMins(5, 5);
	}

	@Test
	public void testToString() {
		assertEquals(testObject1.toString(), "05:05");
		assertEquals(testObject2.toString(), "10:59");
	}

	@Test
	public void testCompareTo() {
		assertEquals(testObject1.compareTo(testObject2), -1);
		assertEquals(testObject2.compareTo(testObject1), 1);
		assertEquals(testObject1.compareTo(testObject3), 0);
	}

	@Test
	public void testEquals() {
		assertTrue(testObject1.equals(testObject3));
		assertFalse(testObject1.equals(testObject2));
	}

	@Test
	public void testCalculateEndTime() {
		HoursAndMins end = HoursAndMins.calculateEndTime(testObject2,
				testObject1);
		// 10:59+05:05 = 16:04
		assertEquals(end, new HoursAndMins(16, 4));
		end = HoursAndMins.calculateEndTime(testObject1, testObject3);
		// 05:05+05:05 = 10:10
		assertEquals(end, new HoursAndMins(10, 10));
	}

	@Test
	public void testConvertToHoursAndMins() {
		assertEquals(testObject1, HoursAndMins.convertToHoursAndMins("05:05"));
		assertEquals(testObject2, HoursAndMins.convertToHoursAndMins("10:59"));
	}
}

package com.inf219.fadderukeappen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.inf219.fadderukeappen.HoursAndMins;
import com.inf219.fadderukeappen.Time;

/**
 * Copyright 2013 Marianne Grov and Johan Rusvik
 * 
 * This file is part of Fadderukeappen.
 * Fadderukeappen is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Fadderukeappen is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Fadderukeappen. If not, see <http://www.gnu.org/licenses/>.
 *
 */

public class TimeTest {

	private Time testObject1;
	private Time testObject2;

	@Before
	public void setUp() throws Exception {
		testObject1 = new Time(5, 5, 5, 5);
		testObject2 = new Time("05:05", "05:05");

	}

	@Test
	public void testConstructors() {
		for (int startH = 0; startH < 24; startH++) {
			for (int startM = 0; startM < 60; startM++) {

				for (int durationH = 0; durationH < 2; durationH++) {
					for (int durationM = 0; durationM < 2; durationM++) {

						testObject1 = new Time(startH, startM, durationH, durationM);
						testObject2 = new Time(String.format("%02d:%02d", startH, startM), String.format("%02d:%02d",
								durationH, durationM));
						assertEquals(testObject1.getStart(), testObject2.getStart());
						assertEquals(testObject1.getEnd(), testObject2.getEnd());
						assertEquals(testObject1.getDuration(), testObject2.getDuration());
					}
				}

			}
		}

	}

	@Test
	public void testCompareTo() {

		testObject1 = new Time("10:10", "01:45");
		for (int startH = 8; startH < 14; startH++) {
			for (int startM = 0; startM < 60; startM++) {

				for (int durationH = 0; durationH < 2; durationH++) {
					for (int durationM = 0; durationM < 2; durationM++) {

						testObject2 = new Time(startH, startM, durationH, durationM);

						if (testObject1.getStart().compareTo(new HoursAndMins(startH, startM)) != 0)
							assertEquals(testObject1.getStart().compareTo(new HoursAndMins(startH, startM)),
									testObject1.compareTo(testObject2));
						else
							assertEquals(testObject1.getDuration().compareTo(new HoursAndMins(durationH, durationM)),
									testObject1.compareTo(testObject2));

					}
				}

			}
		}
	}

	@Test
	public void testEquals() {

		testObject1 = new Time("10:10", "01:45");
		for(int startH = 8; startH < 14; startH++) {
			for(int startM = 0; startM < 60; startM++) {

				for(int durationH = 0; durationH < 2; durationH++) {
					for(int durationM = 0; durationM <2; durationM++) {

						testObject2 = new Time(startH, startM, durationH, durationM);

						if(testObject1.getStart().equals(testObject2.getStart()) && testObject1.getDuration().equals(testObject2.getDuration()) && testObject1.getEnd().equals(testObject2.getEnd()))
							assertEquals(testObject1, testObject2);
						else
							assertNotEquals(testObject1, testObject2);

					}
				}

			}
		}
	}
}


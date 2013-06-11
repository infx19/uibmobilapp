package com.inf219.fadderukeappen;

import java.util.List;

import android.util.Log;

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
public class Controller {
	public static final Date FADDERUKE_START_DATE = new Date(2013, 8, 15);
	public static final Date FADDERUKE_END_DATE = new Date(2013, 8, 22);
	public static final int FADDERUKE_DURATION = 7;
	
	private static final String id = "123456789abc";

	public static void updateDB(DBEventDataSource database) {
		try {
			List<Event> events = getAllEvents();

			database.deleteAllEvents();
			for (Event e : events) {
				database.createEvent(e);
			}
		} catch (Exception e) {
			Log.e("PARSINGERROR", "Couldn't get events from XML");
			e.printStackTrace();
		}
	}
	
	private static List<Event> getAllEvents() throws Exception {
		// from XML:
		String url = "https://raw.github.com/livarb/uibmobilapp/master/Fadderukeappen/Docs/XML/e3.xml";		

		DataThread async = new DataThread();
		List<Event> eventsFromXML = async.execute(url).get();

		return eventsFromXML;
	}	
	
	public static String getId() {
		return id;
	}

}

package com.inf219.fadderukeappen;

import java.util.List;

import android.util.Log;

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

package com.inf219.fadderukeappen;

import java.util.ArrayList;
import java.util.Collections;
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
		//String url1 = "https://timeplan.data.uib.no/KEYuhyhu9any/xml/timeplanliste/now/INF237";
		String url = "https://raw.github.com/livarb/uibmobilapp/master/Fadderukeappen/Docs/XML/e3.xml";		

		DataThread async = new DataThread();
		List<Event> eventsFromXML = async.execute(url).get();
		
		//List<Event> allEvents = new ArrayList<Event>();
		//allEvents.addAll(eventsFromXML);

		return eventsFromXML;
	}

//	public static List<Event> getEventsOnDate(Date date) throws Exception {
//		List<Event> eventlist = new ArrayList<Event>();
//		for (Event e : getAllEvents()) {
//			if (e.getDate().equals(date)) {
//				eventlist.add(e);
//			}
//		}
//		return eventlist;
//	}
//
//	public static List<Event> getEventsOnDateSorted(Date date) throws Exception {
//		List<Event> sortedEvents = getEventsOnDate(date);
//		Collections.sort(sortedEvents);
//		return sortedEvents;
//	}

	
	
	public static String getId() {
		return id;
	}

}

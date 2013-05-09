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

	
	public static List<Event> getAllEvents() throws Exception {
		// from XML:
		//String url1 = "https://timeplan.data.uib.no/KEYuhyhu9any/xml/timeplanliste/now/INF237";
		String url = "https://raw.github.com/livarb/uibmobilapp/master/Fadderukeappen/Docs/XML/e3.xml";		

		// eventsFromXML = XMLParser.getEventsInfoFromURL(url);
		DownloadInfoTask async = new DownloadInfoTask();
		List<Event> eventsFromXML = async.execute(url).get();
		
		List<Event> allEvents = new ArrayList<Event>();
		allEvents.addAll(eventsFromXML);

		return allEvents;
	}

	public static List<Event> getEventsOnDate(Date date) throws Exception {
		List<Event> eventlist = new ArrayList<Event>();
		for (Event e : getAllEvents()) {
			if (e.getDate().equals(date)) {
				eventlist.add(e);
			}
		}
		return eventlist;
	}

	public static List<Event> getEventsOnDateSorted(Date date) throws Exception {
		List<Event> sortedEvents = getEventsOnDate(date);
		Collections.sort(sortedEvents);
		return sortedEvents;
	}

	public static void updateDB(DBEventDataSource db) {
		try {
			List<Event> events = getAllEvents();

			db.deleteAllEvents();
			for (Event e : events) {
				db.createEvent(e);
			}
		} catch (Exception e) {
			Log.e("PARSINGERROR", "Couldn't get events from XML");
			e.printStackTrace();
		}
	}
	
	public static String getId() {
		return id;
	}

}

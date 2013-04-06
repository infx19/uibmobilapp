package com.example.fadderukeappen;

import java.util.ArrayList;
import java.util.Collections;
import android.util.Log;

public class Controller {
	public static final Date FADDERUKE_START_DATE = new Date(2013, 8, 15);
	public static final Date FADDERUKE_END_DATE = new Date(2013, 8, 22);
	public static final int FADDERUKE_DURATION = 7;

	public static ArrayList<Event> getAllEvents() throws Exception {
		// from XML:
		String url1 = "https://timeplan.data.uib.no/KEYuhyhu9any/xml/timeplanliste/now/INF237";
		String url = "https://raw.github.com/livarb/uibmobilapp/master/Fadderukeappen/Docs/XML/e3.xml";

		ArrayList<Event> allEvents = new ArrayList<Event>();
		ArrayList<Event> eventsFromXML;

		// eventsFromXML = XMLParser.getEventsInfoFromURL(url);
		DownloadInfoTask async = new DownloadInfoTask();
		eventsFromXML = async.execute(url).get();

		allEvents.addAll(eventsFromXML);

		return allEvents;
	}

	public static ArrayList<Event> getEventsOnDate(Date date) throws Exception {
		ArrayList<Event> eventlist = new ArrayList<Event>();
		for (Event e : getAllEvents()) {
			if (e.getDate().equals(date)) {
				eventlist.add(e);
			}
		}
		return eventlist;
	}

	public static ArrayList<Event> getEventsOnDateSorted(Date date) throws Exception {
		ArrayList<Event> sortedEvents = getEventsOnDate(date);
		Collections.sort(sortedEvents);
		return sortedEvents;
	}

	public static void updateDB(DBEventDataSource db) {
		try {
			ArrayList<Event> events = getAllEvents();

			db.deleteAllEvents();
			for (Event e : events) {
				db.createEvent(e);
			}
		} catch (Exception e) {
			Log.e("PARSINGERROR", "Couldn't get events from XML");
			e.printStackTrace();
		}
	}

}

package com.example.fadderukeappen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import android.nfc.NfcAdapter.CreateBeamUrisCallback;
import android.util.Log;

public class Controller {
	static String[] names = {"aaa", "bbb", "ccc", "ddd", "eee", "fff"};
	//String[] times = {"00:00-03:00", "14:00-16:00", "21:00-23:00","01:00-03:00", "17:00-22:00", "23:00-03:00"};
	static String[] loc = {"p1", "p2", "p3","p4", "p5", "p6"};

	public static ArrayList<Event> getAllEventsOn(Date date) {

		return createEvents(date);
	}

	private static ArrayList<Event> createEvents(Date date) {
		ArrayList<Event> list = new ArrayList<Event>();
		for(int i = 0; i < 6; i++) {
			list.add(new Event(names[i], loc[i] + " " + date.toString(), date, new Time(i, 0, i+1, 0)));
		}
				for(int i = 0; i < 6; i++) {
					list.add(new Event(names[i], loc[i] + " " + date.toString(), date, new Time(i, 0, i+1, 0)));
			}
		return list;
	}

	//	public static ArrayList<Event> getAllEvents() {
	//		//from XML:
	//		String url = "https://raw.github.com/livarb/uibmobilapp/master/Fadderukeappen/Docs/XML/e3.xml";
	//		
	//		ArrayList<Event> allEvents = new ArrayList<Event>();
	//		ArrayList<Event> eventsFromXML;
	//
	//		try {
	//			eventsFromXML = XMLParser.getEventsInfoFromURL(url);
	//			allEvents.addAll(eventsFromXML);
	//		} catch (Exception e) {
	//			Log.e("PARSINGERROR", "Couldn't get events from XML");
	//			e.printStackTrace();
	//		}
	//		
	//		return allEvents;
	//	}

	public static ArrayList<Event> getAllEvents() throws Exception {
		//from XML:
		String url1 = "https://timeplan.data.uib.no/KEYuhyhu9any/xml/timeplanliste/now/INF237";
		String url = "https://raw.github.com/livarb/uibmobilapp/master/Fadderukeappen/Docs/XML/e3.xml";

		ArrayList<Event> allEvents = new ArrayList<Event>();
		ArrayList<Event> eventsFromXML;


		eventsFromXML = XMLParser.getEventsInfoFromURL(url);
		allEvents.addAll(eventsFromXML);

		return allEvents;
	}


	public static ArrayList<Event> getEventsOnDate(Date date) throws Exception {
		ArrayList<Event> eventlist = new ArrayList<Event>();
		for(Event e : getAllEvents()) {
			if(e.getDate().equals(date)) {
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
			for(Event e : events) {
				db.createEvent(e);
			}
		} catch (Exception e) {
			Log.e("PARSINGERROR", "Couldn't get events from XML");
			e.printStackTrace();
		}
	}

}

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
	
	public static ArrayList<Event> getAllEvents() {
		ArrayList<Event> day1 = createEvents(new Date(2013, 8, 15));
		ArrayList<Event> day2 = createEvents(new Date(2013, 8, 16));
		ArrayList<Event> day3 = createEvents(new Date(2013, 8, 17));
		ArrayList<Event> day4 = createEvents(new Date(2013, 8, 18));
		day1.addAll(day2);
		day1.addAll(day3);
		day1.addAll(day4);
		return day1;
	}
	
	public static ArrayList<Event> getEventsOnDate(Date date) {
		ArrayList<Event> eventlist = new ArrayList<Event>();
		for(Event e : getAllEvents()) {
			if(e.getDate().equals(date)) {
				eventlist.add(e);
			}
		}
		return eventlist;
	}
	
	public static ArrayList<Event> getEventsOnDateSorted(Date date) {
		ArrayList<Event> sortedEvents = getEventsOnDate(date);
		Collections.sort(sortedEvents);
		return sortedEvents;
	}
	
}

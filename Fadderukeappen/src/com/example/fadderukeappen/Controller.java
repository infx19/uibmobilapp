package com.example.fadderukeappen;

import java.util.ArrayList;

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
		Log.d("DEBUG", "returnerer " + list.size() + " elementer");
		return list;
	}
	
}

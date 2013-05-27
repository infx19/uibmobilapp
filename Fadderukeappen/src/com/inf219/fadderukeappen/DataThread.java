package com.inf219.fadderukeappen;

import java.util.ArrayList;

import android.os.AsyncTask;

/**
 * Denne klassen starter en separat tr�d for nedlasting av data.
 * Se http://developer.android.com/reference/android/os/AsyncTask.html for mer info * 
 * 
 * @author jru049,mgr090
 *
 */
class DataThread extends AsyncTask<String, Integer, ArrayList<Event>> {
	
	protected ArrayList<Event> doInBackground(String... urls) {
		int count = urls.length;
		ArrayList<Event> events = null;
		for (int i = 0; i < count; i++) {
			events = XMLParser.getEventsInfoFromURL(urls[i]);
		}
		return events;
	}

//	protected void onProgressUpdate(Integer... progress) {
//		 setProgressPercent(progress[0]);
//	}
//
//	protected void onPostExecute(Long result) {
//		 showDialog("Downloaded " + result + " bytes");
//	}
}

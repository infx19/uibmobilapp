package com.inf219.fadderukeappen;

import java.net.URL;
import java.util.ArrayList;

import android.os.AsyncTask;

class DownloadInfoTask extends AsyncTask<String, Integer, ArrayList<Event>> {
	protected ArrayList<Event> doInBackground(String... urls) {
		int count = urls.length;
		ArrayList<Event> events = null;
		for (int i = 0; i < count; i++) {
			events = XMLParser.getEventsInfoFromURL(urls[i]);
		}
		return events;
	}

	protected void onProgressUpdate(Integer... progress) {
		// setProgressPercent(progress[0]);
	}

	protected void onPostExecute(Long result) {
		// showDialog("Downloaded " + result + " bytes");
	}
}

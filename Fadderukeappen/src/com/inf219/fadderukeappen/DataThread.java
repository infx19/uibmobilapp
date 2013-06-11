package com.inf219.fadderukeappen;

import java.util.ArrayList;

import android.os.AsyncTask;
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


/**
 * Denne klassen starter en separat tråd for nedlasting av data.
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

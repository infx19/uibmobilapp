package com.example.fadderukeappen;

import java.net.URL;
import java.util.ArrayList;

import android.os.AsyncTask;

class DownloadInfoTask extends AsyncTask<String, Integer, ArrayList<Event>> {
    protected ArrayList<Event> doInBackground(String... urls) {
        int count = urls.length;
        ArrayList<Event> events = null;
        for (int i = 0; i < count; i++) {
				events = XMLParser.getEventsInfoFromURL(urls[i]);

//            publishProgress((int) ((i / (float) count) * 100));
//            // Escape early if cancel() is called
//            if (isCancelled()) break;
        }
        return events;
    }

    protected void onProgressUpdate(Integer... progress) {
//        setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
//        showDialog("Downloaded " + result + " bytes");
    }
}

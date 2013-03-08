package com.example.fadderukeappen;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class DayActivity extends Activity {
	Date date;
	LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.date = new Date("23.12.1987");
		setContentView(R.layout.activity_day);
		for(EventLayout el : getAllEventViews(date)) {
			
			this.addContentView(el, lp);
		}

	}
	
	protected ArrayList<EventLayout> getAllEventViews(Date date) {
		ArrayList<EventLayout> eventLayouts = new ArrayList<EventLayout>();
		eventLayouts.add(new EventLayout(this));
		eventLayouts.add(new EventLayout(this));
		eventLayouts.add(new EventLayout(this));
		
		return eventLayouts;
		
	}
}

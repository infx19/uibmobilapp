package com.example.fadderukeappen;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class DayActivity extends Activity {
	Date date;
	LinearLayout listLayout;
	LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.date = new Date("23.12.1987");
		setContentView(R.layout.activity_day);
		
		listLayout.setOrientation(LinearLayout.VERTICAL);
		listLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		
		for(EventLayout el : getAllEventViews(date)) {
			
			this.addContentView(el, lp);
		}

	}
	
	protected ArrayList<EventLayout> getAllEventViews(Date date) {
		ArrayList<EventLayout> eventLayouts = new ArrayList<EventLayout>();
		eventLayouts.add(new EventLayout(this, "programmøte", "12:00-14.00", "store auditorium"));
		eventLayouts.add(new EventLayout(this, "kurs1", "05:00-18.00", "sted"));
		eventLayouts.add(new EventLayout(this, "kurs1", "05:00-18.00", "sted"));
		return eventLayouts;
		
	}
}

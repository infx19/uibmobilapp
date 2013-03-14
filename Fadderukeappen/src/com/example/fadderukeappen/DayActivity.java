package com.example.fadderukeappen;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class DayActivity extends Activity {
	
	//bruke onFling() ?
	Date date;
	LinearLayout listLayout;
	LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_day);
		listLayout = (LinearLayout) findViewById(R.id.activity_day_lin_lay);
		listLayout.setOrientation(LinearLayout.VERTICAL);
		listLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
		
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String date = extras.getString("com.example.fadderukeappen.daylist");
		    Date d = new Date(date);
		    displayEventsOnDate(d);
		    Log.d("DEBUG", "Intent date is " + date);
		} else {
		
			Date d = new Date("18.08.2013");
			displayEventsOnDate(d);
		}
	}

	protected void displayEventsOnDate(Date date) {
		this.date = date;

		insertEventViews(getAllEventViews(date));
//		insertEventViews(getAllEventViewsTest(date));	
	}

	protected void insertEventViews(ArrayList<EventLayout> eventViews) {
		for(EventLayout el : eventViews) {
			FrameLayout borderParent = new FrameLayout(this);
			borderParent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			borderParent.setPadding(0, 1, 0, 1);
			borderParent.setBackgroundColor(Color.GRAY);
			borderParent.addView(el);
			//listLayout.addView(borderParent, lp);
			this.addContentView(borderParent, lp);
		}
		//this.addContentView(listLayout, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

	}

	protected ArrayList<EventLayout> getAllEventViewsTest(Date date) {
		ArrayList<EventLayout> eventLayouts = new ArrayList<EventLayout>();
		for(int i = 1; i < 5; i++) {
			eventLayouts.add(new EventLayout(this, "programmøte", "12:00-14.00", "store auditorium"));
			eventLayouts.add(new EventLayout(this, "forelesning", "05:00-18.00", "auditorium 1, RFB"));
			eventLayouts.add(new EventLayout(this, "kurs1", "05:00-18.00", "sted"));
		}
		return eventLayouts;

	}

	protected ArrayList<EventLayout> getAllEventViews(Date date) {
		ArrayList<Event> events = Controller.getAllEventsOn(date);
		ArrayList<EventLayout> eventLayouts = new ArrayList<EventLayout>();
		for(int i = 1; i < events.size(); i++) {
			eventLayouts.add(new EventLayout(this, events.get(i).getTitle(), events.get(i).getTime().toString(), events.get(i).getLocation()));
		}
		return eventLayouts;
	}
}

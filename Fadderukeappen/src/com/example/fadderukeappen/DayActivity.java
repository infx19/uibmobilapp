package com.example.fadderukeappen;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class DayActivity extends Activity {
	Date date;
	LinearLayout listLayout;
	LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.date = new Date("18.08.2013");
		setContentView(R.layout.activity_day);

		listLayout = new LinearLayout(this);
		listLayout.setOrientation(LinearLayout.VERTICAL);
		listLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

		for(EventLayout el : getAllEventViewsTest(date)) {
			FrameLayout borderParent = new FrameLayout(this);
			borderParent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			borderParent.setPadding(0, 1, 0, 1);
			borderParent.setBackgroundColor(Color.GRAY);
			borderParent.addView(el);
			listLayout.addView(borderParent, lp);
		}
		this.addContentView(listLayout, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));

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

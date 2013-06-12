package com.inf219.fadderukeappen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

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
 * @author Marianne
 *
 * This activity contains an overview of the days in Fadderuken
 * The days are clickable and leads to the events for the day on the clicked button
 */
public class DayListActivity extends Activity implements OnClickListener{
	
	private final static String[] DAY_NAMES = {"Søndag", "Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag"};
	private LinearLayout linLay;
	private DBEventDataSource dbEventDataSource; 
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * 
	 * When this activity is created, the database is updated
	 */
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_daylist);
		linLay = (LinearLayout) findViewById(R.id.activity_daylist_linear_layout);
		linLay.setOrientation(LinearLayout.VERTICAL);
		
		addDaysFromDate(Controller.FADDERUKE_START_DATE, 7);
		
		dbEventDataSource = new DBEventDataSource(this);
		dbEventDataSource.open();
		Controller.updateDB(dbEventDataSource);
		dbEventDataSource.close();

	}

	/**
	 * Adds the given number of days, starting on the given date,
	 * to the overview of the days in Fadderuken
	 * 
	 * @param date The starting date of Fadderuken
	 * @param numberOfDays The duration of Fadderuken
	 */
	private void addDaysFromDate(Date date, int numberOfDays) {
		for(int i = 0; i < numberOfDays; i++) {
			Button b = new Button(this);
		
			b.setText(DAY_NAMES[i%7]);
			b.setHint(date.toString());
			b.setOnClickListener(this);
			linLay.addView(b, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
			date = date.nextDate();
		}

	}
	

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 * 
	 * When the user clicks a button, 
	 * he is sent to an overview of the events belonging to that day
	 */
	@Override
	public void onClick(View v) {
		if(v instanceof Button) {
			Button b = (Button) v;
			
			String date = b.getHint().toString();
		
			Intent intent = new Intent(DayListActivity.this, DayActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			intent.putExtra("com.inf219.fadderukeappen.daylist", date);
		    startActivity(intent);
		}
	}
}

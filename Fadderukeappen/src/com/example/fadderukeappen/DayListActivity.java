package com.example.fadderukeappen;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class DayListActivity extends Activity implements OnClickListener{
	final static String[] DAY_NAMES = {"Søndag", "Mandag", "Tirsdag", "Onsdag", "Torsdag", "Fredag", "Lørdag"};
	ArrayList<Button> dayButtons;
	LinearLayout linLay;
	DBEventDataSource dbEventDataSource; 
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_daylist);
		linLay = (LinearLayout) findViewById(R.id.activity_daylist_linear_layout);
		linLay.setOrientation(LinearLayout.VERTICAL);
		
		Date date = new Date(2013, 8, 15);
		addDaysFromDate(date, 7);
		
		
		dbEventDataSource = new DBEventDataSource(this);
		dbEventDataSource.open();
		Controller.updateDB(dbEventDataSource);
		dbEventDataSource.close();

	}

	private void addDaysFromDate(Date date, int numberOfDays) {
		dayButtons = new ArrayList<Button>();
		for(int i = 0; i < numberOfDays; i++) {
			Button b = new Button(this);
		
			b.setText(DAY_NAMES[i%7]);
			b.setHint(date.toString());
			b.setOnClickListener(this);
			linLay.addView(b, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
			date = date.nextDate();
		}

	}
	

	@Override
	public void onClick(View v) {
		if(v instanceof Button) {
			Button b = (Button) v;
			
			String date = b.getHint().toString();
		
			 Intent intent = new Intent(DayListActivity.this, DayActivity.class);
			 intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			 intent.putExtra("com.example.fadderukeappen.daylist", date);
		     startActivity(intent);
			
			
		}
		
	}
}

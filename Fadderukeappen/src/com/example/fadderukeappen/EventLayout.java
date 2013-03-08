package com.example.fadderukeappen;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EventLayout extends RelativeLayout {
	
	TextView tvTime;
	TextView tvName;
	TextView tvLocation;
	public EventLayout(Context context) {
		super(context);
		LayoutParams lp = new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);
		
		tvTime = new TextView(context);
		tvName = new TextView(context);
		tvLocation = new TextView(context);
		
		LayoutParams rlp1 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		LayoutParams rlp2 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		rlp2.addRule(RIGHT_OF,tvTime.getId());
		LayoutParams rlp3 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		rlp3.addRule(BELOW, tvTime.getId());
		
		
		this.setLayoutParams(lp);
		this.addView(tvTime, rlp1);
		this.addView(tvName,rlp2);
		this.addView(tvLocation, rlp3);
		
		tvTime.setText("00:00 - 03:00");
		tvName.setText("programmøte");
		tvLocation.setText("store auditorium");
	}

}

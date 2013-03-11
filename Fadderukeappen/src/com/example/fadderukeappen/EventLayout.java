package com.example.fadderukeappen;

import android.content.Context;
import android.graphics.Color;
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
		
		tvTime.setId(1);
		tvName.setId(2);
		tvLocation.setId(3);
		
		
		LayoutParams rlp1 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		LayoutParams rlp2 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		rlp2.addRule(BELOW,tvTime.getId());
		rlp2.addRule(ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		LayoutParams rlp3 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		rlp3.addRule(ALIGN_TOP,tvTime.getId());
		rlp3.addRule(ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

		this.setLayoutParams(lp);
		this.addView(tvTime, rlp1);
		this.addView(tvName,rlp2);
		this.addView(tvLocation, rlp3);
		tvName.setTextSize(20);
		this.setBackgroundColor(Color.WHITE);
		this.setPadding(5, 5, 5, 5);
		
		
	}
	
	public EventLayout(Context context, String name, String time,
			String place) {
		this(context);
		
		tvTime.setText(time);
		tvName.setText(name);
		tvLocation.setText(place);
		// TODO Auto-generated constructor stub
	}

}

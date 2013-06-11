package com.inf219.fadderukeappen;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
 *	Layout to show an Event's information.
 *	Contains textfields for the name, time and location of the event.
 */
public class EventLayout extends RelativeLayout {

	private TextView tvTime;
	private TextView tvName;
	private TextView tvLocation;

	public EventLayout(Context context) {
		super(context);
		makeEventLayout(context);
	}

	public EventLayout(Context context, String name, String time, String place) {
		this(context);

		setInformation(name, time, place);
	}

	private void setInformation(String name, String time, String place) {
		tvTime.setText(time);
		tvName.setText(name);
		tvLocation.setText(place);
	}

	private void makeEventLayout(Context context) {
		LayoutParams lp = new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		this.setLayoutParams(lp);

		tvTime = new TextView(context);
		tvName = new TextView(context);
		tvLocation = new TextView(context);

		tvTime.setId(1);
		tvName.setId(2);
		tvLocation.setId(3);

		LayoutParams rlp1 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		LayoutParams rlp2 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		rlp2.addRule(BELOW, tvTime.getId());
		rlp2.addRule(ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		LayoutParams rlp3 = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		rlp3.addRule(ALIGN_TOP, tvTime.getId());
		rlp3.addRule(ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

		this.setLayoutParams(lp);
		this.addView(tvTime, rlp1);
		this.addView(tvName, rlp2);
		this.addView(tvLocation, rlp3);
		tvName.setTextSize(20);
		this.setBackgroundColor(Color.WHITE);
		this.setPadding(1, 1, 1, 1);
	}

}

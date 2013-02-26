package com.example.opnedatatestapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.webkit.WebView.FindListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class CourseLayout extends LinearLayout{
	Context context;
	
	public CourseLayout(Context context, String course, String[] tagList) {
		super(context);
		this.context = context;
		this.setOrientation(VERTICAL);
		
		if(course.equals("new")) return;
		setCourseInfo(course, tagList);
		

	}

	public void setCourseInfo(String course, String[] tagList) {
		removeAllViews();
		LayoutParams lp = new LayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		String[][] info;
		try {
			info = XMLreader.getInfo(course, tagList);

			TextView tv = new TextView(context);
			tv.setText("COURSE: " + course);

			tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 26);
			this.addView(tv,lp);

			for(String[] s: info) {
				LinearLayout line = new LinearLayout(context);
				line.setOrientation(HORIZONTAL);
				TextView tag = new TextView(context);
				TextView value = new TextView(context);
				tag.setText(s[0] + "  ");
				value.setText(" " + s[1]);
				line.addView(tag);
				line.addView(value);

				this.addView(line, lp);
			}

		} catch (Exception e) {
			TextView errorMsg = new TextView(context);
			errorMsg.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 26);
			errorMsg.setTextColor(Color.RED);
			errorMsg.setText("INVALID REQUEST");

		}	
	}
}

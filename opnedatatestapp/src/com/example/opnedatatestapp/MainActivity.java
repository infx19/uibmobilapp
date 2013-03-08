package com.example.opnedatatestapp;

import java.io.IOException;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Canvas.VertexMode;
import android.graphics.Path.FillType;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	final public static String tagList[] = {"topic", "year", "semester", "uri"};
	
	TextView inputMsg;
	EditText inputfield;
	
	Button bInput;
	Button bBack;
	CourseLayout courseLayout;
	LayoutParams lp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		inputMsg = (TextView) findViewById(R.id.test);
		inputMsg.setText("Type the course name to get information.");
		inputfield = (EditText) findViewById(R.id.inputField);
		inputfield.setHint("course name");
		inputfield.setLines(1);

		bInput = (Button) findViewById(R.id.inputbutton);
		bInput.setOnClickListener(this);

		bBack = new Button(this);
		bBack.setVisibility(View.INVISIBLE);
		bBack.setOnClickListener(this);
		bBack.setText("New Search");

		lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		courseLayout = new CourseLayout(this, "new", tagList);
		courseLayout.setVisibility(View.INVISIBLE);

		this.addContentView(courseLayout, lp);
		this.addContentView(bBack, lp);


	}

	public void makeInformationLayout(String course) {
		courseLayout.setCourseInfo(course, tagList);
		courseLayout.refreshDrawableState();
		bBack.setText(bBack.getText() + " :(");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		if(!(v instanceof Button))  {

			inputMsg.setText("something wrong happened. try again.");
		} else {
			Button b = (Button) v;
			if(b == bInput) {
				this.inputfield.setVisibility(View.INVISIBLE);
				this.inputMsg.setVisibility(View.INVISIBLE);
				this.bInput.setVisibility(View.INVISIBLE);
				makeInformationLayout(inputfield.getText().toString());
				
				inputfield.setText("");
				this.courseLayout.setVisibility(View.VISIBLE);
				
				this.bBack.setVisibility(View.VISIBLE);

			} else {
				this.courseLayout.setVisibility(View.INVISIBLE);
				this.bBack.setVisibility(View.INVISIBLE);
				this.inputfield.setVisibility(View.VISIBLE);
				this.inputMsg.setVisibility(View.VISIBLE);
				this.bInput.setVisibility(View.VISIBLE);

			}


		}

	}

}






package com.example.fadderukeappen;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

public class DBEventDataSource {
	
	private SQLiteDatabase database;
	private DBEventHelper dbEventHelper;
	private String[] allColumns;
	
	public DBEventDataSource(Context context) {
		dbEventHelper = new DBEventHelper(context);
		allColumns = dbEventHelper.getColumns();
	}
	
	public void open() {
		database = dbEventHelper.getWritableDatabase();
	}
	
	public void close() {
		database.close();
	}
	
	public Event createEvent(Event event) {
		
	}
	
	private Event cursorToEvent(Cursor cursor) {
		Event event = new Event();
	}
}

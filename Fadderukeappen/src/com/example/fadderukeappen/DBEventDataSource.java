package com.example.fadderukeappen;

import android.content.ContentValues;
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
		ContentValues values = new ContentValues();
		values.put(allColumns[1], event.getTitle());
		values.put(allColumns[2], event.getLocation());
		values.put(allColumns[3], event.getDate().toString());
		HoursAndMins start = event.getTime().getStart();
		values.put(allColumns[4], start.toString());
		HoursAndMins duration = event.getTime().getDuration();
		values.put(allColumns[5], duration.toString());
		long insertId = database.insert(dbEventHelper.getTableName(), null, values);
		Cursor cursor = database.query(dbEventHelper.getTableName(), allColumns, 
				allColumns[0]+" = "+insertId, null, null, null, null);
		cursor.moveToFirst();
		Event newEvent = cursorToEvent(cursor);
		cursor.close();
		return newEvent;
	}
	
	private Event cursorToEvent(Cursor cursor) {
		Event event = new Event();
		event.setId(cursor.getLong(0));
		event.setTitle(cursor.getString(1));
		event.setLocation(cursor.getString(2));
		event.setDate(new Date(cursor.getString(3)));
		String[] start = cursor.getString(4).split(":");
		String[] duration = cursor.getString(5).split(":");
		Time time = new Time(Integer.parseInt(start[0]), Integer.parseInt(start[1]), 
				Integer.parseInt(duration[0]), Integer.parseInt(duration[1]));
		event.setTime(time);
		return event;
	}
}

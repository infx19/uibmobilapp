package com.inf219.fadderukeappen;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

public class DBEventDataSource {
	
	private SQLiteDatabase database;
	private DBEventHelper dbEventHelper;
	private String[] allColumns;
	
	public DBEventDataSource() {}
	
	public DBEventDataSource(Context context) {
		dbEventHelper = new DBEventHelper(context);
		allColumns = dbEventHelper.getColumns();
	}
	
	public void open() throws SQLException {
		database = dbEventHelper.getWritableDatabase();
	}
	
	public void close() {
		database.close();
	}
	
	/**
	 * Oppretter og fyller en ContentValues objekt.
	 * Dette objektet blir brukt for å opprette et event i databasen.
	 * 
	 * @param event Eventet som skal lagres i databasen
	 * @return Eventet som har blitt lagret i databasen
	 */
	public ContentValues setEventValuesForStorage(Event event) {
		
		ContentValues values = new ContentValues();
		Log.e("content_values",".......");
		values.put(allColumns[1], event.getTitle());
		values.put(allColumns[2], event.getLocation());
		values.put(allColumns[3], event.getDate().toString());
		HoursAndMins start = event.getTime().getStart();
		values.put(allColumns[4], start.toString());
		HoursAndMins duration = event.getTime().getDuration();
		values.put(allColumns[5], duration.toString());
		return values;
	}
	
	public Event createEvent(Event event) {
		ContentValues values = setEventValuesForStorage(event);
		long insertId = database.insert(dbEventHelper.getTableName(), null, values);
		Cursor cursor = database.query(dbEventHelper.getTableName(), allColumns, 
				allColumns[0]+" = "+insertId, null, null, null, null);
		cursor.moveToFirst();
		Event newEvent = cursorToEvent(cursor);
		cursor.close();
		return newEvent;
	}
	
	public void deleteEvent(Event event) {
		long id = event.getId();
		System.out.println("Event deleted with id: "+id);
		database.delete(dbEventHelper.getTableName(), allColumns[0]+" = "+id, null);
	}
	
	public void deleteAllEvents() {
		System.out.println("All events deleted");
		database.delete(dbEventHelper.getTableName(), null, null);
	}
	
	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<Event>();
		Cursor cursor = database.query(dbEventHelper.getTableName(), allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()) {
			Event event = cursorToEvent(cursor);
			events.add(event);
			cursor.moveToNext();
		}
		cursor.close();
		return events;
	}
	
	public List<Event> getAllEventsOnDate(Date date) {
		List<Event> events = new ArrayList<Event>();
		Cursor cursor = database.query(dbEventHelper.getTableName(), 
				allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()) {
			Event event = cursorToEvent(cursor);
			if(event.getDate().equals(date)) {
				events.add(event);
			}
			
			cursor.moveToNext();
		}
		cursor.close();
		return events;
	}
	
	private Event cursorToEvent(Cursor cursor) {
		Event event = new Event();
		event.setId(cursor.getLong(0));
		event.setTitle(cursor.getString(1));
		event.setLocation(cursor.getString(2));
		event.setDate(new Date(cursor.getString(3)));
		Time time = new Time(cursor.getString(4), cursor.getString(5));
		
		event.setTime(time);
		return event;
	}
	
	public String[] getAllColumns() {
		return allColumns;
	}
}

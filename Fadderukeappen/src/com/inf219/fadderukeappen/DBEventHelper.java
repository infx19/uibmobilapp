package com.inf219.fadderukeappen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

public class DBEventHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 3;	
	private static final String DATABASE_NAME_EVENT = "fadderukeappen.db";
	
	private static final String TABLE_NAME_EVENT = "events";
	
	private static final String COLUMN_ID = "_id";
	private static final String COLUMN_TITLE = "title";
	private static final String COLUMN_LOCATION = "location";
	private static final String COLUMN_DATE = "date"; // DD.MM.YYYY
	private static final String COLUMN_START = "start"; // HH:MM
	private static final String COLUMN_DURATION = "duration"; // HH:MM
	
	private static final String COLUMN_ID_SPECS = COLUMN_ID+" integer primary key autoincrement";
	private static final String COLUMN_TITLE_SPECS = COLUMN_TITLE+" text not null";
	private static final String COLUMN_LOCATION_SPECS = COLUMN_LOCATION+" text not null";
	private static final String COLUMN_DATE_SPECS = COLUMN_DATE+" text not null";
	private static final String COLUMN_START_SPECS = COLUMN_START+" text not null";
	private static final String COLUMN_DURATION_SPECS = COLUMN_DURATION+" text not null";
	
	private static final String DATABASE_CREATE = "create table "+DATABASE_NAME_EVENT+"("+COLUMN_ID_SPECS+", "+COLUMN_TITLE_SPECS+", "+
													COLUMN_LOCATION_SPECS+", "+COLUMN_DATE_SPECS+", "+COLUMN_START_SPECS+", "+COLUMN_DURATION_SPECS+");";
	
	public DBEventHelper(Context context)  {
		super(context, DATABASE_NAME_EVENT, null, DATABASE_VERSION);
	}
	

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.w(DBEventHelper.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data!");
		    database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EVENT);
		    onCreate(database);		
	}
	
	public String[] getColumns() {
		return new String[] {COLUMN_ID, COLUMN_TITLE, COLUMN_LOCATION, COLUMN_DATE, COLUMN_START, COLUMN_DURATION};
	}
	
	public String getTableName() {
		return TABLE_NAME_EVENT;
	}
}

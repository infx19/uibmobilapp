package com.example.fadderukeappen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBEventHelper extends SQLiteOpenHelper {
	
	private static final int DATABASE_VERSION = 3;	
	private static final String DATABASE_NAME_EVENT = "fadderukeappen.db";
	
	private static final String TABLE_NAME_EVENT = "events";
	private static final String COLUMN_ID = "_id integer primary key autoincrement";
	private static final String COLUMN_TITLE = "title text not null";
	private static final String COLUMN_LOCATION = "location text not null";
	private static final String COLUMN_START = "start text not null";
	private static final String COLUMN_DURATION = "duration text not null";
	
	private static final String DATABASE_CREATE = "create table "+DATABASE_NAME_EVENT+"("+COLUMN_ID+", "+COLUMN_TITLE+", "+
													COLUMN_LOCATION+", "+COLUMN_START+", "+COLUMN_DURATION+");";
	
	public DBEventHelper(Context context)  {
		super(context, DATABASE_NAME_EVENT, null, DATABASE_VERSION);
	}
	
	/*public void storeEventOnDevice(List<File> files) {
		FileOutputStream fileOutputStream = null;
		Resources
		try {
			for(File file : files) {
				fileOutputStream = openFileOutput(file.getName(), Context.MODE_PRIVATE);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}*/

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
}

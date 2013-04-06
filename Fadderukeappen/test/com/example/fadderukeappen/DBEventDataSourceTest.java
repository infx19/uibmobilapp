//package com.example.fadderukeappen;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
////import static org.mockito.Mockito.*;
//
//import android.content.ContentValues;
//
//public class DBEventDataSourceTest {
//	
//	DBEventDataSource dbEventDataSource;
////	SQLiteDatabase mockedDatabase; 
////	DBEventHelper dbEventHelper;
//	
//	private Event testEvent;
//	private String testTitle;
//	private String testLocation;
//	private Date testDate;
//	private Time testTime;
//	private long idFirst;
//	
//	@Before
//	public void setup() {
//		dbEventDataSource = new DBEventDataSource();
////		dbEventHelper = new DBEventHelper(getInstrumentation().getContext());
////		dbEventDataSource.dbEventHelper = dbEventHelper;
////		dbEventDataSource.database = mock(SQLiteDatabase.class);
////		mockedDatabase = dbEventDataSource.database;
//		
//		testTitle = "TestEvent";
//		testLocation = "Somewhere";
//		testDate = new Date("01.01.2013");
//		testTime = new Time(4,4,4,4);
//		testEvent = new Event(testTitle,testLocation, testDate, testTime);
//		
//	}
//	
//	@Test
//	public void testSetEventValuesForStorage() {
//		ContentValues values = new ContentValues();
//		values = dbEventDataSource.setEventValuesForStorage(testEvent);
//		assertTrue(values.size() == dbEventDataSource.allColumns.length);
//	}
//}

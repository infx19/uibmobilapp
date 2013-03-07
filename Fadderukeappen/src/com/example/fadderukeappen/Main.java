package com.example.fadderukeappen;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Time time = new Time(10, 15, 12, 0);
		Date date = new Date(2012,8,16);
		Event event = new Event("tittel", "her", date, time);

		
		System.out.println(time.toString());
		System.out.println(date.toString());
	}

}

package com.inf219.fadderukeappen;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
	private final static String[] EVENT_TAGS = { "date", "start", "duration", "title", "location" };

	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}

	public static ArrayList<Event> getEventsInfoFromURL(String url) {
		Document doc = null;
		try {
			doc = getDocument(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		NodeList nodes = doc.getElementsByTagName("event");
		ArrayList<Event> allEvents = new ArrayList<Event>();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String date = getValue(EVENT_TAGS[0], element);
				String start = getValue(EVENT_TAGS[1], element);
				String duration = getValue(EVENT_TAGS[2], element);
				String title = getValue(EVENT_TAGS[3], element);
				String location = getValue(EVENT_TAGS[4], element);

				Event event = new Event(title, location, date, start, duration);
				allEvents.add(event);
			}
		}

		return allEvents;
	}

	private static Document getDocument(String url1) throws Exception {
		URL url = new URL(url1);
		URLConnection conn = url.openConnection();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = factory.newDocumentBuilder();

		InputStream is = null;
		try {
			is = conn.getInputStream();
			is = new BufferedInputStream(is);
			Document doc = builder.parse(is);
			doc.getDocumentElement().normalize();

			return doc;
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

}

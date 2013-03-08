package com.example.opnedatatestapp;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XMLreader {

	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}

	public static String[][] getInfo(String course, String[] taglist) throws Exception {
		String[][] txt;
		String api = "KEYuhyhu9any";
		
		Document doc = getDocument("https://timeplan.data.uib.no/" + api + "/xml/timeplanliste/now/" + course);

		System.out.println("root of xml file" + doc.getDocumentElement().getNodeName());
		NodeList nodes = doc.getElementsByTagName("info");
		System.out.println("==========================");

		txt = new String[taglist.length][2];

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;

				int tagNum = 0;
				for(int j = 0; j < taglist.length; j++) {
					txt[tagNum][0] = taglist[tagNum];
					txt[tagNum][1] = getValue(taglist[tagNum], element);
					tagNum++;
				}

			}
		}



		return txt;

	}

	public static Document getDocument(String url1) throws Exception {
		URL url = new URL(url1);

		URLConnection conn = url.openConnection();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(conn.getInputStream());

		doc.getDocumentElement().normalize();

		return doc;
	}

}

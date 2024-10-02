import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class OldConvert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
		public static void convertFile(String fileName) {
			
			try {
//			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			FileReader gpx = new FileReader(fileName);

//			BufferedWriter writer = new BufferedWriter(new FileWriter("triplog.csv"));
			FileWriter csv = new FileWriter("triplog.csv");
			
//			writer.write("Time, Latitude, Longitude\n");
				
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	        DocumentBuilder builder = factory.newDocumentBuilder();
//
	        Document document = builder.parse(fileName);
	        
	        NodeList track = document.getElementsByTagName("trkpt");
	        
//	        
	        FileWriter w = new FileWriter("triplog.csv");
//	        
			w.write("Time, Latitude, Longitude\n");
			
//			
	        int time = 0;
	        
	        for (int i = 0; i < track.getLength(); i++) {	  

	        	String lat = track.item(i).getAttributes().getNamedItem("lat").getTextContent().trim().replace("?", "");

	            String lon = track.item(i).getAttributes().getNamedItem("lon").getTextContent().trim().replace("?", "");
	                     	
	            	w.write(time + "," + lat + "," + lon + "\n");
	            	time += 5;	            	
	            	
	           }
				w.close();

			} catch (ParserConfigurationException | SAXException | IOException e) {
				e.printStackTrace();
			}
//								
//			//remove ? marks and extra white space
//									
//			//add if contains "?" remove or " " remove
		}

}

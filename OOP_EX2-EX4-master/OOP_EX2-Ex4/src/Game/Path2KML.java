package Game;

import java.io.IOException;
import java.util.Iterator;


public class Path2KML {
	 public static void path2kml(Packman packman) throws IOException {
		 String kmlFile="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +  "<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n";
		 for (int i = 0; i < packman.getPath().getPath().size();i++) {
			 kmlFile+="<Placemark><Point><coordinates>"+packman.getPath().getPath().get(i).getFruit().y()+","+packman.getPath().getPath().get(i).getFruit().x()+"</coordinates></Point><styleUrl>#red</styleUrl><description><![CDATA[BSSID: <b></b><br/>Capabilities: </b><br/>Frequency: <b></b><br/>Timestamp: <b></b><br/>Date: <b>"+"</b>]]></description></Placemark>";
		 }
		 kmlFile+="\n"+"</Folder>\r\n" + "</Document></kml>";
		 String fileName="packman_"+packman.ID+"_path";
			 stringToKml(kmlFile, fileName);   //call the function that create the KML file
		      
	 }
	 
	 /**
		 * Get string and create KML file.
		 * we were helped by the following link:
		 * https://stackoverflow.com/questions/17853541/java-how-to-convert-a-xml-string-into-an-xml-file
		 * @param csv2kml
		 * @param fileName
		 * @throws IOException
		 */
		public static void stringToKml(String csv2kml, String fileName) throws IOException {
		    java.io.FileWriter fw = new java.io.FileWriter(System.getProperty("user.home") + "\\Desktop\\" +fileName+".kml");
		    fw.write(csv2kml);
		    fw.close();
		    System.out.println("saved to desktop!");
		}
}

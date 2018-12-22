package GIS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;





public class Project extends  HashSet<Layer>{
	/**
	 * Get string and create KML file.
	 * we were helped by the following link:
	 * https://stackoverflow.com/questions/17853541/java-how-to-convert-a-xml-string-into-an-xml-file
	 * @param csv2kml
	 * @param fileName
	 * @throws IOException
	 */
	public HashSet<Layer> layers;
	public Layer lay;
	public Project() {
	this.layers=new HashSet<Layer>();
	}
	public Project(Layer lay) {
		this.lay=lay;
	}
	/*public void project2CSV() {
		project2CSV(this.layers);
	}*/
	
	/*public void layer2csv() throws IOException {
		FileWriter writer = new FileWriter(this.lay.getName()+".csv");
		writer.append("MAC");
		writer.append(',');
		writer.append("SSID");
		writer.append(',');
		writer.append("AuthMode");
		writer.append(',');
		writer.append("FirstSeen");
		writer.append(',');
		writer.append("Channel");
		writer.append(',');
		writer.append("RSSI");
		writer.append(',');
		writer.append("CurrentLatitude");
		writer.append(',');
		writer.append("CurrentLongitude");
		writer.append(',');
		writer.append("AltitudeMeters");
		writer.append(',');
		writer.append("AccuracyMeters");
		writer.append(',');
		writer.append("Type");
		writer.append('\n');
		Iterator<Element> iter=this.lay.iterator();
		while(iter.hasNext()) {
			Element elm =iter.next();
			writer.append(elm.getMAC());
			writer.append(',');
			writer.append(elm.getName());
			writer.append(',');
			writer.append(elm.getAuthMode());
			writer.append(',');
			writer.append(elm.getChannel());
			writer.append(',');
			writer.append(elm.getRSSI());
			writer.append(',');
			writer.append(""+elm.getCurrentLatitude());
			writer.append(',');
			writer.append(""+elm.getCurrentLongitude());
			writer.append(',');
			writer.append(""+elm.getAltitudeMeters());
			writer.append(',');
			writer.append(elm.getAccuracyMeters());
			writer.append(',');
			writer.append(elm.getType());
			writer.append('\n');
		}
		writer.flush();
		writer.close();
		
	}        */
}
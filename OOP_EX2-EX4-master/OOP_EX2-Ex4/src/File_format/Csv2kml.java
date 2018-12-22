package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import GIS.Element;
import GIS.Layer;
import GIS.Project;
import File_format.csvBuilder;
/**
 * This class read CSV file and create KML file
 * @author Gil && Amilt
 *
 */
public class Csv2kml extends csvBuilder {
	public static Project project;
	private static Scanner sc;
	 /**
	  * read all the csv file that he get from MultiCSV.
	  * @param csvFillArr
	  * @throws IOException
	  */
	public static void csvFiles(ArrayList<String> csvFillArr) throws IOException {
		project=new Project();
		for (int i = 0; i < csvFillArr.size(); i++) {
			try {
				csv2kml(csvFillArr.get(i));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		project2csv(project);
	}
	/**
	 * Read CSV file and create layer from him.
	 * @param fileName
	 * @throws IOException
	 */
	 public static void csv2kml(String fileName) throws IOException {
		 	String csvFile;
		 	if(fileName.substring(fileName.length()-4).equals(".csv")){
		 		csvFile = fileName;
		 	}
		 	else {
		 		csvFile = fileName+".csv";
		 	}
	        String line = "";
	        Layer layer = new Layer(fileName);

	        //Read the file.
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
	        {
	        	line = br.readLine();
	        	line = br.readLine();
	            while ((line = br.readLine()) != null) 
	            {	
	            	String[] csvLine= line.split(",");       //create element
	            	double lat=Double.parseDouble(csvLine[6]);
	            	double lon=Double.parseDouble(csvLine[7]);
	            	double alt=Double.parseDouble(csvLine[8]);
	            	Element element = new Element(csvLine[3],lat,lon,alt);
	            	layer.add(element);
	            }

	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }
	        project.add(layer);
	        layer2kml(layer);
	        
	  }
	 /**
	  * create String from layer.
	  * this String is a KML file.
	  * @param layer
	  * @throws IOException
	  */
	 public static void layer2kml(Layer layer) throws IOException {
		 String kmlFile="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +  "<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\r\n";
		 Iterator<Element> iter=layer.iterator();
		 while(iter.hasNext()) {
			 Element element =iter.next();
			 kmlFile+="<Placemark><Point><coordinates>"+element.getCurrentLongitude()+","+element.getCurrentLatitude()+"</coordinates></Point><styleUrl>#red</styleUrl><description><![CDATA[BSSID: <b></b><br/>Capabilities: </b><br/>Frequency: <b></b><br/>Timestamp: <b></b><br/>Date: <b>"+element.getTime() +"</b>]]></description></Placemark>";
		 }
		 kmlFile+="\n"+"</Folder>\r\n" + "</Document></kml>";
		 String fileName=layer.getName().substring(0, layer.getName().length()-4);
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
		    java.io.FileWriter fw = new java.io.FileWriter(fileName+".kml");
		    fw.write(csv2kml);
		    fw.close();
		}

}

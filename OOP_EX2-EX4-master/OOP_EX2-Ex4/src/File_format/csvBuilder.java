package File_format;

import GIS.Project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import GIS.Element;
import GIS.Layer;
/**
 * this class get project and craet from him csv files.
 * @author Amit-PC
 *
 */
public class csvBuilder {
	/**
	 * get project and send evrey layer to layer2csv.
	 * @param project
	 * @throws IOException
	 */
	public static void project2csv(Project project) throws IOException {
		Iterator<Layer> iter=project.iterator();
		while(iter.hasNext()) {
			Layer layer=iter.next();
			layer2csv(layer);
		}
	}
	/**
	 * craete from layer csv file.
	 * @param layer
	 * @throws IOException
	 */
	public static void layer2csv(Layer layer) throws IOException {
		//write file.
		FileWriter writer = new FileWriter(layer.getName()+".csv");
		writer.append("WigleWifi-1.4");
		writer.append(',');
		writer.append("appRelease=2.26");
		writer.append(',');
		writer.append("model=SM-G950F");
		writer.append(',');
		writer.append("release=7.0");
		writer.append(',');
		writer.append("device=dreamlte");
		writer.append(',');
		writer.append("display=NRD90M.G950FXXU1AQJ5");
		writer.append(',');
		writer.append("board=universal8895");
		writer.append(',');
		writer.append("CurrentLongitude");
		writer.append(',');
		writer.append("brand=samsung");
		writer.append(',');
		writer.append("");
		writer.append(',');
		writer.append("");
		writer.append('\n');
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
		Iterator<Element> iter=layer.iterator();
		//write all the elements to the file.
		while(iter.hasNext()) {
			Element elm =iter.next();
			writer.append("");
			writer.append(',');
			writer.append("");
			writer.append(',');
			writer.append("");
			writer.append(',');
			writer.append(elm.getTime());
			writer.append(',');
			writer.append("");
			writer.append(',');
			writer.append("");
			writer.append(',');
			writer.append(""+elm.getCurrentLatitude());
			writer.append(',');
			writer.append(""+elm.getCurrentLongitude());
			writer.append(',');
			writer.append(""+elm.getAltitudeMeters());
			writer.append(',');
			writer.append("");
			writer.append(',');
			writer.append("");
			writer.append('\n');
		}
		writer.flush();
		writer.close();
		
	}
}

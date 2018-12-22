package GIS;

import Coords.MyCoords;

import Geom.Point3D;

import java.text.ParseException;
import java.text.SimpleDateFormat;
public class metaData extends MyCoords implements Meta_data{
	private SimpleDateFormat dateFormat;
	public String UTC;
	public double CurrentLatitude;
	public double CurrentLongitude;
	public double AltitudeMeters;
	public String color;
	
	/** returns the Universal Time Clock associated with this data;
	 *  http://timestamp.online/
	 */
	public long getUTC() {
		dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		long longUTC = 0;
		try {
			longUTC = dateFormat.parse(this.UTC).getTime()/1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return longUTC;
	}
	
	public metaData(String UTC, double CurrentLatitude, double CurrentLongitude,double AltitudeMeters ) {
		this.UTC=UTC;
		this.CurrentLatitude=CurrentLatitude;
		this.CurrentLongitude=CurrentLongitude;
		this.AltitudeMeters=AltitudeMeters;
		this.color=null;
 	}
	
	public void setCurrentLatitude(double currentLatitude) {
		CurrentLatitude = currentLatitude;
	}
	public void setCurrentLongitude(double currentLongitude) {
		CurrentLongitude = currentLongitude;
	}
	public void setAltitudeMeters(double altitudeMeters) {
		AltitudeMeters = altitudeMeters;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public double getCurrentLatitude() {
		return CurrentLatitude;
	}
	public double getCurrentLongitude() {
		return CurrentLongitude;
	}
	public double getAltitudeMeters() {
		return AltitudeMeters;
	}
	/**
	 * @return the orientation: yaw, pitch and roll associated with this data;
	 */
	public Point3D get_Orientation() {
		return null;
	}
	public String get_Color() {
		return this.color;
	}
	/** return a String representing this data */
	public String toString() {
		return "UTC"+this.UTC+","+"CurrentLatitude"+CurrentLatitude+","+"CurrentLongitude"+CurrentLongitude+","+"AltitudeMeters"+AltitudeMeters+","+"color"+this.color;
	}

}

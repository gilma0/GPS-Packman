package GIS;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;

public class Element extends MyCoords implements GIS_element  {
	public String time;
	public double CurrentLatitude;
	public double CurrentLongitude;
	public double AltitudeMeters;
	public metaData data;
	
	public Geom_element getGeom() {
		Point3D element=new Point3D(this.CurrentLatitude,this.CurrentLongitude,this.AltitudeMeters);
		return element;
	}

	public Meta_data getData() {
		return this.data;
	}

	public void translate(Point3D vec) {
		Point3D gps =new Point3D(this.CurrentLatitude,this.CurrentLongitude,this.AltitudeMeters);
		Point3D newgps=add(gps,vec);
		this.CurrentLatitude=newgps.x();
		this.CurrentLongitude=newgps.y();	
		this.AltitudeMeters=newgps.z();
		this.data.setCurrentLatitude(this.CurrentLatitude);
		this.data.setCurrentLongitude(this.CurrentLongitude);
		this.data.setAltitudeMeters(this.AltitudeMeters);
	}

	public Element(String time, double CurrentLatitude,double CurrentLongitude,double AltitudeMeters) {
		this.time=time;
		this.CurrentLatitude=CurrentLatitude;
		this.CurrentLongitude=CurrentLongitude;
		this.AltitudeMeters=AltitudeMeters;
		this.data=new metaData(time,CurrentLatitude,CurrentLongitude,AltitudeMeters);
	
	}
	
	
	public String getTime() {
		return time;
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
	public String toString() {
		return "Element [time=" + time + ", CurrentLatitude=" + CurrentLatitude + ", CurrentLongitude="
				+ CurrentLongitude + ", AltitudeMeters=" + AltitudeMeters + ", data=" + data + "]";
	}
	
}

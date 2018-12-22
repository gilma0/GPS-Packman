package Coords;

import Geom.Point3D;
/**
 * This class represents a basic coordinate system converter, including:
 * 1. The 3D vector between two lat,lon, alt points 
 * 2. Adding a 3D vector in meters to a global point.
 * 3. convert a 3D vector from meters to polar coordinates
 *@author Gil && Amilt
 */
public class MyCoords implements coords_converter{

	/**
	 * computes a new point which is the gps point transformed by a 3D vector (in meters)
	 *  @param gps
	 *  @param local_vector_in_meter
	 *  @return Point3D
	 */
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		double EARTH_RADIUS =6371000;
		double x=gps.x()+Math.toDegrees(Math.asin(local_vector_in_meter.x()/EARTH_RADIUS));
		double LonNorm= Math.cos(Math.toRadians(x));
		double y=gps.y()+Math.toDegrees(Math.asin(local_vector_in_meter.y()/LonNorm/EARTH_RADIUS));
		double z=gps.z()+local_vector_in_meter.z();
		Point3D p2=new Point3D(x,y,z);
		return  p2;
	}
	/** computes the 3D distance (in meters) between the two gps like points
	 * @param gps0
	 * @param gps1
	 * @return Point3D
	 */
	public double distance3d(Point3D gps0, Point3D gps1) {
		double EARTH_RADIUS =6371000;
		double lonNorm=Math.cos(Math.toRadians(gps0.x()));
		double alt = gps1.z() - gps0.z();
		double dx=Math.toRadians(gps1.x()-gps0.x());
		double dy=Math.toRadians(gps1.y()-gps0.y());
		dx=Math.sin(dx)*EARTH_RADIUS;
		dy=Math.sin(dy)*EARTH_RADIUS*lonNorm;
		double temp = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
		double ans=  Math.sqrt(Math.pow(temp, 2)+Math.pow(alt, 2));
		return ans;
	}
	
	/** computes the 3D vector (in meters) between two gps like points 
	 * @param gps0
	 * @param gps1
	 * @return Point3D
	 */
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		double EARTH_RADIUS =6371000;
		double LonNorm= Math.cos(Math.toRadians(gps0.x()));
		double x = Math.sin(Math.toRadians(gps1.x() -gps0.x()))*EARTH_RADIUS;
		double y = Math.sin(Math.toRadians(gps1.y() -gps0.y()))*EARTH_RADIUS*LonNorm;
		double z = gps1.z() -gps0.z();
		Point3D p = new Point3D(x,y,z);
		return p;
	}
	/** computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance
	 * @param gps0
	 * @param gps1
	 * @return double[]
	 */
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double EARTH_RADIUS =6371000;
		double[] azimuth_elevation_dist=new double[3];
		azimuth_elevation_dist[2] =distance3d(gps0,gps1);
		double LonNorm= Math.cos(Math.toRadians(gps0.x()));
		double alt = gps1.z() - gps0.z();
		double dx=Math.sin(Math.toRadians(gps1.x()-gps0.x()))*EARTH_RADIUS;
		double dy=Math.sin(Math.toRadians(gps1.y()-gps0.y()))*EARTH_RADIUS*LonNorm;
		double dz=gps1.z()-gps0.z();
		double temp = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
		azimuth_elevation_dist[0]=Math.toDegrees(Math.atan(dy/dx));
		if(azimuth_elevation_dist[0]<0) {
			azimuth_elevation_dist[0]=360 +azimuth_elevation_dist[0];
		}
		double altDiff = gps1.z()-gps0.z();
		azimuth_elevation_dist[1] = Math.toDegrees(Math.tan(altDiff/temp));
		return azimuth_elevation_dist;
	}
	/**
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p
	 * @return Boolean
	 */
	public boolean isValid_GPS_Point(Point3D p) {
		if((p.x()>-180 && p.x()<180) && (p.y()>-90 && p.y()<90) && (p.z()>-450)) {
			return true;
		}
		return false;
	}
	
}



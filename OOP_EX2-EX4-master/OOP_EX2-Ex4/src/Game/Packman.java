package Game;

import Geom.Point3D;
/**
 * 
 * @author Gil&Amit
 * this is the packman class
 *
 */
public class Packman {
	//packman attributes
	public int ID;
	public Point3D packman;
	public int Speed; //the speed the packman moves
	public int Radius; //the packman eating radius
	public double timer;
	public Path path; //the path of the fruits this packman has eaten
	public Point3D packmanPixels; //the packman place changed into pixels
	
	/**
	 * getting the packman timer
	 * @return timer
	 */
	public double getTimer() {
		return timer;
	}
	/**
	 * setting this packmans timer
	 * @param timer
	 */
	public void setTimer(double timer) {
		this.timer = timer;
	}
	/**
	 * setting this packman pixels
	 * @param packmanPixels the pixels given
	 */
	public void setPackmanPixels(Point3D packmanPixels) {
		this.packmanPixels = packmanPixels;
	}
	/**
	 * getting X pixels
	 * @return X pixels
	 */
	public int getX() {
	    return (int) packmanPixels.x();
	}
	/**
	 * getting Y pixels
	 * @return Y pixels
	 */
	public int getY() {
	    return (int) packmanPixels.y();
	}
	
	/**
	 * this is a packman constructor
	 * @param ID given ID
	 * @param Lat given latitude
	 * @param Lon given longitude
	 * @param Alt given altitude
	 * @param Speed given speed
	 * @param Radius given eat radius
	 */
	public Packman(int ID, double Lat ,double Lon,double Alt ,int Speed, int Radius  ) {
		this.ID =ID;
		packman = new Point3D(Lat,Lon,Alt);
		this.Speed=Speed;
		this.Radius=Radius;
		this.path = new Path();
		this.path.add(new Fruit(999, Lat, Lon, Alt));
		this.timer = 0;
		this.packmanPixels=Map.LatLon2Pixels(Lon,Lat);
	}
	/**
	 * another form of packman constructor
	 * @param ID given ID
	 * @param pack given Place
	 */
	public Packman(int ID, Point3D pack) {
		this.ID = ID;
		this.Speed = 1;
		this.Radius = 1;
		packman = pack;
		this.timer = 0;
		this.packmanPixels = Map.LatLon2Pixels(pack.y(),pack.x());
		this.path = new Path();
		this.path.add(new Fruit(999, pack));
	}
	/**
	 * packman to string with all its attributes
	 */
	@Override
	public String toString() {
		return "Packman [ID=" + ID + ", packman=" + packman + ", Speed=" + Speed + ", Radius=" + Radius + ", timer="
				+ timer + ", path=" + path + "]";
	}
	/**
	 * getting this packman path
	 * @return path
	 */
	public Path getPath() {
		return path;
	}
	/**
	 * getting this packman ID
	 * @return ID
	 */
	public int getID() {
		return ID;
	}
	/**
	 * getter for this packman coordinates
	 * @return coordinates object
	 */
	public Point3D getPackman() {
		return packman;
	}
	/**
	 * getting this packman speed
	 * @return speed
	 */
	public int getSpeed() {
		return Speed;
	}
	/**
	 * getting this packman eating radius
	 * @return radius
	 */
	public int getRadius() {
		return Radius;
	}
	/**
	 * setting this packman coordinates
	 * @param packman given coordinates
	 */
	public void setPackman(Point3D packman) {
		this.packman = packman;
	}

	
	

	
}

package Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Geom.Point3D;
/**
 * Represent image of map and convert pixels to lat lon and lat lon to pixels.
 * @author Amit & Gil
 *
 */
public class Map {
	
	static final int mapWidth = 1433, mapHeight = 642;
	static final double mapLongitudeStart = 35.20250000, mapLatitudeStart = 32.10555556;
	static final double mapLongitudeEnd = 35.21222222, mapLatitudeEnd = 32.10194444;
	static final double mapLongitude =mapLongitudeEnd-mapLongitudeStart, mapLatitude = mapLatitudeStart-mapLatitudeEnd;

	/**
	 * convert from lon lat to pixels.
	 * we used this web:
	 * https://stackoverflow.com/questions/38748832/convert-longitude-and-latitude-coordinates-to-image-of-a-map-pixels-x-and-y-coor
	 * @param longitude
	 * @param latitude
	 * @return
	 */
	public static Point3D LatLon2Pixels(double longitude, double latitude){

	    int x = (int) (mapWidth*((longitude-mapLongitudeStart)/mapLongitude));
	    int y = (int) (mapHeight*((mapLatitudeStart-latitude)/mapLatitude));

	    return new Point3D(x, y);
	}
	
	/**
	 * convert pixels to lat lon.
	 * @param x
	 * @param y
	 * @return
	 */
	public static Point3D Pixsels2LatLon(double x, double y){
		double longitude = (x/mapWidth)*mapLongitude + mapLongitudeStart;
		double latitude = (y/mapHeight)*mapLatitude + mapLatitudeStart;
		
 	    return new Point3D(latitude, longitude);
	}
	
	
	/**
	 * Represent an map image and show convert from pixel tow lat and  lon.
	 * we used this web:
	 * https://www.dummies.com/programming/java/how-to-write-java-code-to-show-an-image-on-the-screen/
	 * @param args
	 */
	
	 public static void main(String args[]) {
		  JFrame frame = new JFrame();
		  ImageIcon icon = new ImageIcon("Ariel1.png"); //show image.
		  JLabel label = new JLabel(icon);
		  frame.add(label);
		  frame.setDefaultCloseOperation
		         (JFrame.EXIT_ON_CLOSE);
		  frame.pack();
		  frame.setVisible(true);		  

		  label.addMouseListener(new MouseAdapter() { 
			    @Override
			    public void mouseClicked(MouseEvent e) { //when you press on the map image take the pixels and convert them.
			         double x = e.getX();
			         double y = e.getY();
			         System.out.println(x+","+y);
			         System.out.println(Pixsels2LatLon(x,y));
			    }
			});
		 
	 }
	

	
}


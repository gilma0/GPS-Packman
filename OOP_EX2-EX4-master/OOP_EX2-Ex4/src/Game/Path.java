package Game;
import javax.swing.JFrame;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GIS.Element;
import GIS.Layer;
/**
 * this is the path class
 * @author Gil & Amit
 *
 */
public class Path {
	
	public ArrayList<Fruit> path;
	/**
	 * path constructor
	 */
	public Path() {
		this.path = new ArrayList<Fruit>();
	}
	/**
	 * getter for the path list
	 * @return path
	 */
	public ArrayList<Fruit> getPath() {
		return path;
	}
	/**
	 * adding a step for the path
	 * @param fruit
	 */
	public void add (Fruit fruit) {
		this.path.add(fruit);
	}
	/**
	 * to string function for the path
	 */
	@Override
	public String toString() {
		return "Path [path=" + path + "]";
	}
	
}


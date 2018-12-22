package GIS;

import java.util.Collection;
import java.util.HashSet;

public class Layer extends  HashSet<Element> {
	public HashSet<Element> hashset;
	public String name="";
	public Layer(String name) {
		this.hashset =new HashSet<Element>();
		this.name+=name;
	}
	/*public boolean add(Element element) {
		hashset.add(element);
		return true;
	}*/
	public String getName() {
		return name;
	}
	
	
}

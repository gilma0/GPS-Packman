package Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Represent Packman game.
 * can read and write CSV File.
 * @author Amit & Gil
 *
 */
public class Game {
	
	public ArrayList<Packman> packmans;
	public ArrayList<Fruit> fruits;
	
	public Game() {
		this.packmans= new  ArrayList<Packman>();
        this.fruits= new  ArrayList<Fruit>();
	}
	
	public  Game(String csvFile) throws IOException {
	        String line = "";
	        this.packmans= new  ArrayList<Packman>();
	        this.fruits= new  ArrayList<Fruit>();
	        //Read CSV file.
	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
	        {
	        	line = br.readLine();
	            while ((line = br.readLine()) != null) 
	            {	
	            	String[] csvLine= line.split(",");   //create packman or fruit.
	            	if(csvLine[0].equals("P")) {
	            		this.packmans.add(new Packman(Integer.parseInt(csvLine[1]), Double.parseDouble(csvLine[2]) ,Double.parseDouble(csvLine[3]) ,Double.parseDouble(csvLine[4]) ,Integer.parseInt(csvLine[5]), Integer.parseInt(csvLine[6]) ));
	            	}
	            	else if(csvLine[0].equals("F")) {
	            		this.fruits.add(new Fruit(Integer.parseInt(csvLine[1]), Double.parseDouble(csvLine[2]) ,Double.parseDouble(csvLine[3]) ,Double.parseDouble(csvLine[4])));
	            	}
	            }            
	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }    
	  }
	/**
	 * get game and create csv file from him.
	 * @param number
	 * @throws IOException
	 */
	public void game2CSV(int number) throws IOException {
		//write file.
		 FileWriter writer = new FileWriter(System.getProperty("user.home") + "\\Desktop\\" + "game"+ number + ".csv");
			writer.append("Type");
			writer.append(',');
			writer.append("id");
			writer.append(',');
			writer.append("Lat");
			writer.append(',');
			writer.append("Lon");
			writer.append(',');
			writer.append("Alt");
			writer.append(',');
			writer.append("Speed");
			writer.append(',');
			writer.append("Radius");
			writer.append(',');
			writer.append(this.packmans.size()+"");
			writer.append(',');
			writer.append(this.fruits.size()+"");
			writer.append(',');
			writer.append('\n');
			//write all packmans to the file.
			for(int i=0;i<this.packmans.size();i++) {
				writer.append("P");
				writer.append(',');
				writer.append(this.packmans.get(i).getID()+"");
				writer.append(',');
				writer.append(this.packmans.get(i).getPackman().x()+"");
				writer.append(',');
				writer.append(this.packmans.get(i).getPackman().y()+"");
				writer.append(',');
				writer.append(this.packmans.get(i).getPackman().z()+"");
				writer.append(',');
				writer.append(this.packmans.get(i).getSpeed()+"");
				writer.append(',');
				writer.append(this.packmans.get(i).getRadius()+"");
				writer.append(',');
				writer.append('\n');
			}
			//write all fruits to the file.
			for(int i=0;i<this.fruits.size();i++) {
				writer.append("F");
				writer.append(',');
				writer.append(this.fruits.get(i).getID()+"");
				writer.append(',');
				writer.append(this.fruits.get(i).getFruit().x()+"");
				writer.append(',');
				writer.append(this.fruits.get(i).getFruit().y()+"");
				writer.append(',');
				writer.append(this.fruits.get(i).getFruit().z()+"");
				writer.append(',');
				writer.append('\n');
			}
			writer.flush();
			writer.close();
	}
	
	public ArrayList<Packman> getPackmans() {
		return this.packmans;
	}
	
	public ArrayList<Fruit> getFruits() {
		return this.fruits;
	}
}

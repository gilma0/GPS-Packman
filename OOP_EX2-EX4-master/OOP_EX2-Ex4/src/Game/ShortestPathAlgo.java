package Game;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 
 * @author Gil&Amit
 *	this is the algorithm we created for the game
 *	its not 100% perfect but its almost accurate all the time
 */

public class ShortestPathAlgo {
	/**
	 * this is the algorithm function its getting the game and do its calculation for it
	 * @param game
	 */
	public static void shortest (Game game) {
		ArrayList<Packman> pacmans = game.getPackmans();
		ArrayList<Fruit> fruits = game.getFruits();
		while(!fruits.isEmpty()) { //working while there are still fruits to eat
			Packman temp = pacmans.get(0); //loading a packman for calculations
			Fruit shortest = fruits.get(0); //loading a fruit for calculations
			double min = eat(temp, shortest); //loading a min for the calculations
			int Findex = 0; //fruit index
			for(int i = 0; i<fruits.size(); i++) { //getting the closest fruit
				if (min > eat(temp, fruits.get(i))) {
					min = eat(temp, fruits.get(i));
					shortest = fruits.get(i);
					Findex = i; //getting its index
				}
			}
			int Pindex = 0; //packman index
			for (int i = 0; i<pacmans.size(); i++) { //getting the closest packman in relation to the fruit
				if (min > eat(pacmans.get(i), shortest)) {
					min = eat(pacmans.get(i), shortest);
					Pindex = i; //getting its index
				}
			}
			pacmans.get(Pindex).setTimer(pacmans.get(Pindex).getTimer()+eat(pacmans.get(Pindex), shortest)); //updating the current packman timer
			pacmans.get(Pindex).setPackman(shortest.getFruit()); //updating the packman position
			pacmans.get(Pindex).setPackmanPixels(shortest.fruitPixels);
			pacmans.get(Pindex).getPath().add(shortest); //adding the eaten fruit to the packman path
			fruits.remove(shortest); //removing the fruit from the list after its eaten
		}
	}
	/**
	 * this function calculates the time for the packman to get to the fruit according to its position and time used beforehand
	 * @param pacman
	 * @param fruit
	 * @return time calculation for the packman to eat the fruit
	 */
	private static double eat (Packman pacman, Fruit fruit) { //getting the time for the packman to eat the fruit
		return pacman.getTimer() + Math.sqrt(Math.pow(pacman.getX()-fruit.getX(), 2) + Math.pow(pacman.getY()-fruit.getY(), 2)/pacman.Speed);
	}
}

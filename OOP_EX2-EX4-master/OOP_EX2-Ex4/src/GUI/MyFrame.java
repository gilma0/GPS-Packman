package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.java.swing.plaf.windows.resources.windows;

import Game.Fruit;
import Game.Game;
import Game.Packman;
import Game.Path2KML;
import Geom.Point3D;
import Game.Map;
import Game.ShortestPathAlgo;
import sun.swing.SwingUtilities2.RepaintListener;
/**
 * 
 * @author Gil&Amit
 * this is the gui, it loads the ariel map given to us and use's all the methods we created ending in the game
 *
 */

public class MyFrame extends JFrame implements MouseListener
{
	public BufferedImage myImage;
	public BufferedImage pacman;
	public BufferedImage fruit;
	public Game game;
	public int test = 0; //flag
	public String selected;
	public int pacCounter = 0;
	public int fruitCounter = 0;
	public int pacSelect = 0; //flag
	public int fruitSelect = 0; //flag
	public int fileCounter = 1;
	
	public MyFrame() 
	{
		initGUI();		
		this.addMouseListener(this); 
	}
	
	private void initGUI() 
	{
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu"); 
		MenuItem item2 = new MenuItem("Load Game");
		MenuItem item3 = new MenuItem("Path to kml");
		MenuItem item4 = new MenuItem("Save Game");
		MenuItem item5 = new MenuItem("Start Game");
		MenuItem item6 = new MenuItem("Restart");
		MenuItem item7 = new MenuItem("Packman");
		MenuItem item8 = new MenuItem("Packman Stop");
		MenuItem item9 = new MenuItem("Fruit");
		MenuItem item10 = new MenuItem("Fruit Stop");
		
		
		menuBar.add(menu);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		menu.add(item5);
		menu.add(item6);
		menu.add(item7);
		menu.add(item8);
		menu.add(item9);
		menu.add(item10);
		
		//buttons actions
		
		item4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pacSelect = 0; //flags
				fruitSelect = 0;
				System.out.println("Save pressed");
				if(game != null) { //saving file
					try {
						game.game2CSV(fileCounter++);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Saved to desktop");
				}
				else {
					System.out.println("nothing to save");
				}
			}
			
		});
		
			item7.addActionListener(new ActionListener() {
			//adding packmans to a new game
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pacSelect = 1; //flags
				fruitSelect = 0;
				if(pacCounter == 0 && fruitCounter == 0) {
					game = new Game();
					
				}
				
				
				repaint();
			}
			
		});
			item8.addActionListener(new ActionListener() {
				//stopping for packmans
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pacSelect = 0; //flags
				fruitSelect = 0;
				repaint();
			}
			
		});
			item9.addActionListener(new ActionListener() {
				//adding fruits to a new game
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(pacCounter == 0 && fruitCounter == 0) {
					game = new Game();
					
				}
				fruitSelect = 1; //flags
				pacSelect = 0;
				
				
				repaint();
			}
			
		});
			
			item10.addActionListener(new ActionListener() {
				//stopping for fruits
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pacSelect = 0;//flags
				fruitSelect = 0;
				repaint();
			}
			
		});
		
			item5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("start pressed");
				ShortestPathAlgo.shortest(game);
				pacSelect = 0;//flags
				fruitSelect = 0;
				repaint();
			}
			
		});
			
			item3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i = 0; i<game.getPackmans().size(); i++) {
						try {
							Path2KML.path2kml(game.getPackmans().get(i));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					pacSelect = 0;
					fruitSelect = 0;
				}
				
			});
			
			item2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("Load pressed");
					  JFileChooser chooser = new JFileChooser(); //java file chooser
				        //filtering the right files
					  FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files (*csv)", "csv");
				        chooser.setFileFilter(filter);
				        int returnVal = chooser.showOpenDialog(null);
				        if(returnVal == JFileChooser.APPROVE_OPTION) {
				            System.out.println("You chose to open this file: " +
				                    chooser.getSelectedFile().getName());
				        }
				        try {
							game = new Game(chooser.getSelectedFile().toString());
							selected = chooser.getSelectedFile().toString();
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
				        pacSelect = 0; //flags
						fruitSelect = 0;
				        test = 1;
					repaint();
				}
				
			});
			item6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//clearing the game
					System.out.println("Restart pressed");
						game.packmans.clear();
						game.fruits.clear();
						pacSelect = 0; //flags
						fruitSelect = 0;
						test = 1;
						repaint();
					
				}
				
			});
		
		this.setMenuBar(menuBar);
		// images for the game
		try {
			 myImage = ImageIO.read(new File("Ariel1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		try {
			pacman = ImageIO.read(new File("pacman_image.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fruit = ImageIO.read(new File("fruit.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	int x = -1;
	int y = -1;
	
	public void paint(Graphics g)
	{
		g.drawImage(myImage, 0, 0, this);
		if (test == 1) {
			g.setColor(Color.CYAN);
			for (int i = 0; i < game.getPackmans().size(); i++) { //getting each packman and placing it
				double lat= game.getPackmans().get(i).getPackman().x();
				double lon= game.getPackmans().get(i).getPackman().y();
				for(int j = 1; j<game.getPackmans().get(i).getPath().getPath().size(); j++) { //getting each packman path and drawing it
					g.drawLine(game.getPackmans().get(i).getPath().getPath().get(j-1).getX(), game.getPackmans().get(i).getPath().getPath().get(j-1).getY(), game.getPackmans().get(i).getPath().getPath().get(j).getX(), game.getPackmans().get(i).getPath().getPath().get(j).getY());
				}
				g.drawImage(pacman, game.getPackmans().get(i).getX(), game.getPackmans().get(i).getY(), this);
			}
			for (int i = 0; i < game.getFruits().size(); i++) { //getting each fruit and placing it
			    g.drawImage(fruit, game.getFruits().get(i).getX(), game.getFruits().get(i).getY(), this);
			}
			
		}
		
	
		if(x!=-1 && y!=-1)
		{
			int r = 10;
			x = x - (r / 2);
			y = y - (r / 2);
			g.fillOval(x, y, r, r);
		}
	}
	
	//events
	@Override
	public void mouseClicked(MouseEvent arg) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		if (pacSelect != 0) { //flag check
			Point3D shula = Map.Pixsels2LatLon(x, -y); //placing the packmans
			Packman temp = new Packman (pacCounter++, shula);
			game.packmans.add(temp); //adding the packman to the game array
			test = 1; //flag
		}
		if (fruitSelect != 0) { //flag check
			Point3D shula = Map.Pixsels2LatLon(x, -y); //placing the fruits
			Fruit temp = new Fruit (fruitCounter++, shula);
			game.fruits.add(temp); //adding the fruit to the game array
			test = 1; //flag
		}

		repaint();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		/////////System.out.println("mouse entered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}

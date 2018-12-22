package GUI;

import javax.swing.JFrame;
/**
 * 
 * @author Gil&Amit
 * this is the main that loads the gui
 *
 */
public class Main 
{
	public static void main(String[] args)
	{
		MyFrame window = new MyFrame();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

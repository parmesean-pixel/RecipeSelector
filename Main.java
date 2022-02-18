import javax.swing.*;

public class Main 
{
	public static void main (String [] args)
	{
		JFrame frame = new JFrame();
	    GUI gui = new GUI();
		frame.setTitle("Recipe Search");
	    frame.setBounds(10,10,500,600);
	    frame.add(gui);
	    frame.setVisible(true);
	}
}	

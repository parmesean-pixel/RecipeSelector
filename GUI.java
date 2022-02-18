import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")

public class GUI extends JPanel implements ActionListener
{
	private JPanel centerPanel;
	private JCheckBox veganBox;
	private JCheckBox vegBox;
	private JCheckBox thirtyBox;
	private JCheckBox onePotBox;
	private JCheckBox asianBox;
	private JCheckBox mexicanBox;
	private JCheckBox americanBox;
	private JCheckBox compBox;
	private JCheckBox hourBox;
	private JCheckBox easeBox;
	private JCheckBox frenchBox;
	private JCheckBox italianBox;
	private JCheckBox seafoodBox;
	private JCheckBox cheeseBox;
	private JCheckBox chickenBox;
	private JCheckBox beefBox;
	private JCheckBox grainBox;
	private JCheckBox beanBox;
	private  JLabel welcome;
	private JLabel decision;
	private JLabel title;
	private JLabel linkLabel;
	String choice;
	String link;
	ArrayList <String> qualities = new ArrayList<String>();
	Recipe recipe = new Recipe();
	
  public GUI ()
  {
	Color header = Color.decode("#363636");
	Color main = Color.decode("#363636");
	Color text = Color.decode("#E6E6E9");
    Font defaultFont = new Font("Gill Sans MT",Font.BOLD,14);
    
    setLayout(new BorderLayout());
    JPanel southPanel = new JPanel();
      JButton exitButton = new JButton("EXIT");
      exitButton.addActionListener(this);
      	exitButton.setForeground(Color.BLACK);
      	exitButton.setFont(defaultFont);
      	exitButton.setBorderPainted(false);
      	exitButton.setOpaque(false);
      southPanel.add(exitButton);
      
      JButton searchRecipe = new JButton("SEARCH");
      	searchRecipe.addActionListener(this);
      	searchRecipe.setForeground(Color.BLACK);
      	searchRecipe.setFont(defaultFont);
      	searchRecipe.setBorderPainted(false);
      	searchRecipe.setOpaque(false);
      southPanel.add(searchRecipe);
      
      southPanel.setBackground(main);
      
    add(southPanel,BorderLayout.SOUTH);
    
    JPanel northPanel = new JPanel();
      welcome = new JLabel("PLEASE SELECT CRITERION FOR YOUR RECIPE");
      	welcome.setFont(new Font("Serif",Font.BOLD,17));
      	welcome.setForeground(text);
      northPanel.add(welcome);
      
      northPanel.setBackground(header);
      
    add(northPanel,BorderLayout.NORTH);

    centerPanel = new JPanel();
      veganBox = new JCheckBox("VEGAN");
      	centerPanel.add(veganBox);
      vegBox = new JCheckBox("VEGETARIAN");
      	centerPanel.add(vegBox);
      thirtyBox = new JCheckBox("<30 MINS");
      	centerPanel.add(thirtyBox);
      onePotBox = new JCheckBox("ONE POT");
      	centerPanel.add(onePotBox);
      asianBox = new JCheckBox("ASIAN FOOD");
      	centerPanel.add(asianBox);
      mexicanBox = new JCheckBox("LATIN AMERICAN FOOD");
      	centerPanel.add(mexicanBox);
      americanBox = new JCheckBox("AMERICAN FOOD");
      	centerPanel.add(americanBox);
      compBox = new JCheckBox("COMPLICATED");
      	centerPanel.add(compBox);
      hourBox = new JCheckBox("> 1 HOUR");
      	centerPanel.add(hourBox);
      easeBox = new JCheckBox("EASY");
      	centerPanel.add(easeBox);
      frenchBox = new JCheckBox("FRENCH FOOD");
      	centerPanel.add(frenchBox);
      italianBox = new JCheckBox("ITALIAN FOOD");
      	centerPanel.add(italianBox);
      seafoodBox = new JCheckBox("SEAFOOD");
      	centerPanel.add(seafoodBox);
      cheeseBox = new JCheckBox("CHEESE");
      	centerPanel.add(cheeseBox);
      beefBox = new JCheckBox("BEEF");
      	centerPanel.add(beefBox);
      chickenBox = new JCheckBox("CHICKEN");
      	centerPanel.add(chickenBox);
      grainBox = new JCheckBox("GRAIN");
      	centerPanel.add(grainBox);
      beanBox = new JCheckBox("BEANS"); 
      	centerPanel.add(beanBox);
      	
      decision = new JLabel("The best meal would be: ");
      decision.setFont(new Font("Serif",Font.BOLD,25));
      decision.setForeground(text);
      
      title = new JLabel("hello");
      title.setFont(new Font("Serif",Font.BOLD,17));
      title.setForeground(text);
      
      linkLabel = new JLabel("there");
      linkLabel.setFont(new Font("Serif",Font.BOLD,17));
      linkLabel.setForeground(text);
      
     centerPanel.setBackground(main);
      
    add(centerPanel,BorderLayout.CENTER);

  }
  public void getQualities() {
	  
	  if(veganBox.isSelected())
		  qualities.add("Vegan");
	  if(vegBox.isSelected())
		  qualities.add("Vegetarian");
	  if(thirtyBox.isSelected())
		  qualities.add("<30 mins");
	  if(onePotBox.isSelected())
		  qualities.add("One Pot Meal");
	  if(asianBox.isSelected())
		  qualities.add("Asian");
	  if(mexicanBox.isSelected())
		  qualities.add("Latin American");
	  if(americanBox.isSelected())
		  qualities.add("American");
	  if(compBox.isSelected())
		  qualities.add("Complicated");
	  if(hourBox.isSelected())
		  qualities.add(">1 hour");
	  if(easeBox.isSelected())
		  qualities.add("Easy");
	  if(frenchBox.isSelected())
		  qualities.add("French");
	  if(italianBox.isSelected())
		  qualities.add("Italian");
	  if(cheeseBox.isSelected())
		  qualities.add("Cheese");
	  if(beefBox.isSelected())
		  qualities.add("Beef");
	  if(chickenBox.isSelected())
		  qualities.add("Chicken");
	  if(beanBox.isSelected())
		  qualities.add("Bean");
	  if(grainBox.isSelected())
		  qualities.add("Grain");
	  if(seafoodBox.isSelected())
		  qualities.add("Seafood");
	 getRecipe();
	 
  }
  public void getRecipe()
  {
	  int i = 0;
	  int z = recipe.getLength();
	  // while there is still another recipe left to read on the file
	  while(i<z)
	  {
		recipe.readFile();
		recipe.compareRecipe(qualities);
		i++;
	  }
	  recipe.findMatch();
	  getChoice();
  }
  public void actionPerformed(ActionEvent e)
  {
    String word = e.getActionCommand();
    if(word.equals("EXIT"))
    {
      System.exit(0);
    } else if(word.equals("SEARCH"))
    {
    	getQualities();
    }
  }
  public void getChoice()
  {
	choice = recipe.setChoice();
	link = recipe.getLink();
	reFormat();
  }
  public void reFormat()
  {
	centerPanel.removeAll();
	centerPanel.revalidate();
	centerPanel.repaint();
	centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
	title.setAlignmentX(Component.CENTER_ALIGNMENT);
	decision.setAlignmentX(Component.CENTER_ALIGNMENT);
	linkLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	welcome.setText("A RECIPE HAS BEEN FOUND");
	title.setText(choice);
	linkLabel.setText("The recipe can be found at " +link);
	centerPanel.add(decision);
	centerPanel.add(title);
	centerPanel.add(linkLabel);
  }
}
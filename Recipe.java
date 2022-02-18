import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Recipe 
{
	private static ArrayList <String> tags = new ArrayList<String>();
	private static ArrayList <Integer> similarities = new ArrayList<Integer>();
	private static ArrayList <String> titles = new ArrayList<String>();
	private static ArrayList <String> links = new ArrayList<String>();
	private String data;
	private int b = 1;
	private static String link;
	String choice;
	File myObj = new File("recipes.txt");

	int length = 0;

	public Recipe() 
	{
		
	} 	
 
	public void readFile()
	{
		try {
		  
		  Scanner myReader = new Scanner(myObj);
	      int a = 0;
	      getLength();
	      while (a<b)
	      {
	    	 data = myReader.nextLine();
	    	 a++;
	      }
	      b++;
		  checkRecipe(data);
	      myReader.close();
	      } catch (FileNotFoundException e) 
		  {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	      } 
    }
	public static void checkRecipe(String data) 
	{
		String recipe = data;
		String comp = null;
		int start = 1;
	
		for(int i =recipe.length(); i>0; i--)
		{
			if(recipe.charAt(i-1)=='|')
			{
				links.add(recipe.substring(i+1,recipe.length()));
				break;
			}
		}
	
		for(int i = 0; i<recipe.length(); i++)
		{
			if(recipe.charAt(i)==';')
			{
				titles.add(recipe.substring(0,i-1));
				comp = recipe.substring(i+1,recipe.length());
			}
		}
	
		for(int i = 0; i<comp.length(); i++)
		{
			if(comp.charAt(i) == ',')
			{
				tags.add(comp.substring(start,i));
				start = i+2;
			}
		}
	
	}
	public void compareRecipe(ArrayList<String> qualities)
	{
		int similarity = 0;
		if (tags.size()<qualities.size())
		{
			for(int i =0; i<qualities.size();i++)
			{
				for(int l = 0; l<tags.size(); l++)
				{
					if(qualities.get(i).equals(tags.get(l)))
						similarity++;
				}
			}
		}
		else
			for(int i =0; i<tags.size();i++)
			{
				for(int l = 0; l<qualities.size(); l++)
				{
					if(tags.get(i).equals(qualities.get(l)))
						similarity++;	
				}
			}
		similarities.add(similarity);
		tags.clear();
	}
	public void findMatch()
	{
		int max = similarities.get(0);
		for(int i = 1; i<similarities.size(); i++)
		{
			if(similarities.get(i)>max)
				max = similarities.get(i);
		}
		System.out.println("Similarities: " +max);
		choice = titles.get(similarities.indexOf(max));
		link = links.get(similarities.indexOf(max));
		System.out.println(links);
		System.out.println("Choice: " +choice);
		System.out.println("Link: " + link);
	}
	public int getLength()
	{
		Scanner secondReader;
		try {
			secondReader = new Scanner(myObj);
			while(secondReader.hasNextLine())
			{
				length++;
				secondReader.nextLine();
			}
			secondReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return length;
 }
	public String setChoice()
	{
		return choice;
	}
	public String getLink()
	{
		return link;
	}
}


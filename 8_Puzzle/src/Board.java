import java.awt.Component;
import java.awt.Graphics;
import java.util.*;

import javax.swing.ImageIcon;

public class Board implements Drawable {

	//Variables
	private ArrayList<Grid> grids;
	private ArrayList<Integer> list;
	ImageIcon board;
	
	//Constructor	
    public Board(){
    	initializeGrids();    	
    	board = new ImageIcon("src/chessboard.png");
    }  
    	
    //Functions
    public void initializeGrids() {
    	grids = new ArrayList<Grid>();    	
    	Grid newOne;
    	
    	list = new ArrayList<Integer>();    	
    	for(int i = 1; i <= 8; i++)
    		list.add(i);
    	    	
    	for(int i = 1; i <= 8; i++){
        	Random generator = new Random(); 
        	int randomIndex = generator.nextInt(list.size());
        	int randomNum = list.get(randomIndex);
        	//System.out.println(randomNum);
        	
        	list.remove(randomIndex);
        	//printArray();
        	
        	int x = randomNum % 3;
        	int y = (int)Math.floor(randomNum / 3);
        	
    		newOne = new Grid(x, y, i);
    		grids.add(newOne);
    	}
    }
    
    public void printArray() {
    	for(int i = 0; i < list.size(); i++)
    		System.out.print(list.get(i) + " ");
    	System.out.println();
    }
    
    //Draw
    @Override
	public void draw(Component c, Graphics g)
	{
    	board.paintIcon(c, g, 10, 10);						
	}    

	public void drawAllGrids(Component c, Graphics g)
	{
		for(int i = 0; i < grids.size(); i++)
			grids.get(i).draw(c, g);						
	}
}

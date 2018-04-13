import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Board implements Drawable{
	
	//Variables
	private Grid[][] grids;
	private Grid blank;
	private Icons icons;
	private ArrayList<Integer> nums;
	
	//Constructor
	public Board()
	{
		grids = new Grid[3][3];
		initializeGrids();
				    
		nums = new ArrayList<Integer>();
		initializeNums();
		
		icons = new Icons();
		
		assignValues();
	   	setBlankGrid();
	}
	
	//Initializers
	public void initializeGrids() {		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grids[i][j] = new Grid(i,j);
			} 
		}
	}
		
	public void initializeNums() {
		for(int i = 1; i <= 8; i++)
			nums.add(i);
	}
	
	//Other Functions
	public void assignValues() {
		Random generator = new Random();
		int randIndex;
		int randNum;
			
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i!=2 || j!=2) {
			    	randIndex = generator.nextInt(nums.size());
			    	randNum = nums.get(randIndex);
			    	nums.remove(randIndex);
			    	grids[i][j].setValue(randNum);
				}				
			} 
		}
	}
	
	public void setBlankGrid() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(grids[i][j].getValue() == 0)
					blank =  grids[i][j];
			} 
		}
	}
	
	public int calcBoardCost() {
		int cost = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
	    		cost = cost + grids[i][j].calcOneGridCost();
			}				
		} 
				
		System.out.println("Cost is: " + cost);			
		return cost;
	}
	
	//Move Grids
	public void right() {
		int value = grids[blank.getX()-1][blank.getY()].getValue();	
		grids[blank.getX()-1][blank.getY()].setValue(blank.getValue());
		blank.setValue(value);
		setBlankGrid();
	}
	
	public void left() {
		int value = grids[blank.getX()+1][blank.getY()].getValue();	
		grids[blank.getX()+1][blank.getY()].setValue(blank.getValue());
		blank.setValue(value);
		setBlankGrid();
	}
	
	public void up() {
		int value = grids[blank.getX()][blank.getY()+1].getValue();	
		grids[blank.getX()][blank.getY()+1].setValue(blank.getValue());
		blank.setValue(value);
		setBlankGrid();
	}
	
	public void down() {
		int value = grids[blank.getX()][blank.getY()-1].getValue();	
		grids[blank.getX()][blank.getY()-1].setValue(blank.getValue());
		blank.setValue(value);
		setBlankGrid();
	}
		
	//Getters
	public Grid[][] getGrids(){
		return grids;
	}
		
	public Grid getGrid(int x, int y) {
		return grids[x][y];
	}
		
	public Grid getBlank() {
		return blank;
	}
	
	//Print Methods	
	public void printGrids() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(grids[j][i].getValue() + " ");
			}
			System.out.println();
		} 	
		System.out.println();
	}
	
	//Draw	Methods
	public void drawAllPieces(Component c, Graphics g){
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				draw(c, g, grids[i][j].getValue(), i, j);
			}
		}				
	}
	
	@Override
	public void draw(Component c, Graphics g, int i, int x, int y) {
		icons.getIcon(i).paintIcon(c, g, x*121 + 10, y*121 + 10);
	}
}

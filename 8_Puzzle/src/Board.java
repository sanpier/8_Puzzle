import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	//Variables
	private static Grid[][] grids;
	private static Grid blank;
	private ArrayList<Integer> nums;
	
	//Constructor
	public Board()
	{
		grids = new Grid[3][3];
		initializeGrids();
			
		nums = new ArrayList<Integer>();
		initializeNums();
	    	
		assignValues();
	   	setBlankGrid();
	   	//printGrids();
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
	public int calcBoardCost() {
		int cost = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
	    		cost = cost + grids[i][j].calcOneGridCost();
			}				
		} 
		
		/*
		System.out.println();
		System.out.println("Cost is: " + cost);
		*/    	
		return cost;
	}
	
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
	
	//Move Grids
	public void changeTwo(Grid a, Grid b) {
		int value = a.getValue();		
		grids[a.getX()][a.getY()].setValue(b.getValue());
		grids[b.getX()][b.getY()].setValue(value);
		setBlankGrid();
	}
	
	public void right() {
		int value = blank.getValue();		
		grids[blank.getX()][blank.getY()].setValue(grids[blank.getX()-1][blank.getY()].getValue());
		grids[blank.getX()-1][blank.getY()].setValue(value);
		setBlankGrid();
	}
	
	public void left() {
		int value = blank.getValue();		
		grids[blank.getX()][blank.getY()].setValue(grids[blank.getX()+1][blank.getY()].getValue());
		grids[blank.getX()+1][blank.getY()].setValue(value);
		setBlankGrid();
	}
	
	public void up() {
		int value = blank.getValue();		
		grids[blank.getX()][blank.getY()].setValue(grids[blank.getX()][blank.getY()+1].getValue());
		grids[blank.getX()][blank.getY()+1].setValue(value);
		setBlankGrid();
	}
	
	public void down() {
		int value = blank.getValue();		
		grids[blank.getX()][blank.getY()].setValue(grids[blank.getX()][blank.getY()-1].getValue());
		grids[blank.getX()][blank.getY()-1].setValue(value);
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
	
	//Draw	
	public void drawAllPieces(Component c, Graphics g){
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grids[i][j].draw(c, g);	
			}
		}				
	}
}

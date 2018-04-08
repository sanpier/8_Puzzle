import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	//Variables
	private Grid[][] grids;
	private ArrayList<Integer> nums;
	private ArrayList<Piece> pieces;	
	
	//Constructor
	public Board()
	{
		grids = new Grid[3][3];
		initializeGrids();
		
		nums = new ArrayList<Integer>();
		for(int i = 1; i <= 8; i++)
			nums.add(i);
				
		pieces = new ArrayList<Piece>();
    	initializePieces();  
    	
    	assignPiecesToGrids();
	}
	
	//Initializers
	public void initializeGrids() {		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grids[i][j] = new Grid(i,j);
			} 
		}
	}
	
	public void initializePieces() {
		Piece newOne;
		for(int i = 1; i <= 8; i++) {
			newOne = new Piece(i);
			pieces.add(newOne);
		}			
	}
	
	public void assignPiecesToGrids() {
		Random generator = new Random();
		int randIndex;
		int randNum;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i!=2 || j!=2) {
			    	randIndex = generator.nextInt(nums.size());
			    	randNum = nums.get(randIndex);
			    	nums.remove(randIndex);
			    	grids[i][j].setValue(pieces.get(randNum-1));
				}				
			} 
		}
	}
	
	//Getters
	public Grid getGrid(int x, int y) {
		return grids[x][y];
	}
	
	//Calculations
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
	
	//Draws
	public void drawAllGrids(Component c, Graphics g){
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grids[i][j].draw(c, g);	
			}				
		} 					
	}
}

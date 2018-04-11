import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
//import javax.swing.ImageIcon;

public class Board /*implements Drawable*/{
	
	//Variables
	//private ImageIcon board;
	private Grid[][] grids;
	private Grid blank;
	private ArrayList<Integer> nums;
	private ArrayList<Piece> pieces;	
	
	//Constructor
	public Board()
	{
		//board = new ImageIcon("src/board.png");
		
		grids = new Grid[3][3];
		initializeGrids();
		
		nums = new ArrayList<Integer>();
		for(int i = 1; i <= 8; i++)
			nums.add(i);
				
		pieces = new ArrayList<Piece>();
    	initializePieces();  
    	
    	assignPiecesToGrids();
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
	
	public Grid getBlankGrid() {
		return blank;
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
	
	//Move Grids
	public void setBlankGrid() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(grids[i][j].getValue() == 0)
					blank =  grids[i][j];
			} 
		}
	}
	
	public void moveRight() {
		Grid mover = getGrid(blank.getX()-1, blank.getY());
		exchangeGrids(mover, blank);
	}
	
	public void moveLeft() {
		Grid mover = getGrid(blank.getX()+1, blank.getY());
		exchangeGrids(mover, blank);
	}
	
	public void moveUp() {
		Grid mover = getGrid(blank.getX(), blank.getY()+1);
		exchangeGrids(mover, blank);
	}
	
	public void moveDown() {
		Grid mover = getGrid(blank.getX(), blank.getY()-1);
		exchangeGrids(mover, blank);
	}
	
	public void exchangeGrids(Grid a, Grid b) {
		a.setXandY(b.getX(), b.getY());
		b.setXandY(a.getX(), a.getY());
		setBlankGrid();
	}
	
	//Draws
	/*@Override
	public void draw(Component c, Graphics g) {
		board.paintIcon(c, g, 0, 0);
	}*/
		
	public void drawAllGrids(Component c, Graphics g){
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				grids[i][j].draw(c, g);	
			}				
		} 					
	}
}

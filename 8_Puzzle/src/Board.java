import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	//Variables
	private static Grid[][] grids;
	private static Grid blank;
	private static ArrayList<Piece> pieces;
	private ArrayList<Integer> nums;
	
	//Constructor
	public Board()
	{
		grids = new Grid[3][3];
		initializeGrids();
			
		pieces = new ArrayList<Piece>();
		initializePieces();
	    
		nums = new ArrayList<Integer>();
		initializeNums();
		
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
	
	public void initializePieces() {
		for(int i = 0; i <= 8; i++)
			pieces.add(new Piece(i));
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
			    	grids[i][j].setPiece(pieces.get(randNum));
				}				
			} 
		}
		grids[2][2].setPiece(pieces.get(0));
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
	/*public void changeTwo(Grid a, Grid b) {
		int value = a.getValue();		
		grids[a.getX()][a.getY()].setValue(b.getValue());
		grids[b.getX()][b.getY()].setValue(value);
		setBlankGrid();
	}*/
	
	public void right() {
		Piece piece = grids[blank.getX()-1][blank.getY()].getPiece();	
		grids[blank.getX()-1][blank.getY()].setPiece(blank.getPiece());
		blank.setPiece(piece);
		setBlankGrid();
	}
	
	public void left() {
		Piece piece = grids[blank.getX()-1][blank.getY()].getPiece();	
		grids[blank.getX()+1][blank.getY()].setPiece(blank.getPiece());
		blank.setPiece(piece);
		setBlankGrid();
	}
	
	public void up() {
		Piece piece = grids[blank.getX()-1][blank.getY()].getPiece();	
		grids[blank.getX()][blank.getY()+1].setPiece(blank.getPiece());
		blank.setPiece(piece);
		setBlankGrid();
	}
	
	public void down() {
		Piece piece = grids[blank.getX()-1][blank.getY()].getPiece();	
		grids[blank.getX()][blank.getY()-1].setPiece(blank.getPiece());
		blank.setPiece(piece);
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
				if(grids[j][i].getValue() > 0)
					grids[i][j].draw(c, g);
			}
		}				
	}
}

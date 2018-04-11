import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	
	//Variables
	//private ImageIcon board;
	private Grid[][] grids;
	private ArrayList<Integer> nums;
	private ArrayList<Piece> pieces;	
	private Grid blank;
	
	//Constructor
	public Board()
	{
		//board = new ImageIcon("src/board.png");
			
		grids = new Grid[3][3];
		initializeGrids();
			
		nums = new ArrayList<Integer>();
		initializeNums();
					
		pieces = new ArrayList<Piece>();
	   	initializePieces();  
	    	
	   	assignPieces();
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
		
	public void initializePieces() {
		Piece newOne;
		for(int i = 1; i <= 8; i++) {
			newOne = new Piece(i);
			pieces.add(newOne);
		}			
	}
	
	//Other Functions
	public void assignPieces() {
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
			    	(pieces.get(randNum-1)).setXandY(i*121, j*121);
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
	
	public void changeTwo(Grid a, Grid b) {
		Grid c = grids[a.getX()][a.getY()];	
		
		grids[a.getX()][a.getY()] = grids[b.getX()][b.getY()];
		pieces.get(a.getValue()-1).setXandY(a.getX(), a.getY());
		
		grids[b.getX()][b.getY()] = c;
		pieces.get(b.getValue()-1).setXandY(b.getX(), b.getY());
		setBlankGrid()
	}
		
	//Getters
	public Grid[][] getGrids(){
		return grids;
	}
	
	public ArrayList<Piece> getPieces(){
		return pieces;
	}
	
	public Grid getGrid(int x, int y) {
		return grids[x][y];
	}
		
	public Grid getBlank() {
		return blank;
	}
	
	//Print Methods
	public void printPieces() {
		for(int i = 0; i < 8; i++)
			System.out.print(pieces.get(i) + " ");
		System.out.println();
	}
	
	public void printGrids() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(grids[i][j] + " ");
			}
			System.out.println();
		} 
	
		System.out.println();
	}
	
	//Draws
	/*@Override
	public void draw(Component c, Graphics g) {
		board.paintIcon(c, g, 0, 0);
	}*/
	
	public void drawAllPieces(Component c, Graphics g){
		for(int i = 0; i < 8; i++)
			pieces.get(i).draw(c, g);					
	}
}

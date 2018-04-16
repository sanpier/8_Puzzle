import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Board implements Drawable{
	
	//Variables
	private static Node activeNode;
	private static Grid[][] grids;
	private static Grid blank;
	private Icons icons;
	private ArrayList<Integer> nums;
	
	//Constructor
	public Board()
	{
		grids = new Grid[3][3];
		blank = new Grid();
		initializeGrids();
				    
		nums = new ArrayList<Integer>();
		initializeNums();
		
		icons = new Icons();
		
		assignValues();
	   	setBlankGrid();
	   	setActiveNode();
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
	
	public Node getActiveNode() {
		return activeNode;
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
					blank = grids[i][j];
			} 
		}
	}

	public void setActiveNode() {
		activeNode = new Node(getGrids(), calcBoardCost());
	}	
	
	public int calcBoardCost() {
		int cost = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
	    		cost = cost + grids[i][j].calcOneGridCost();
			}				
		} 
				
		//System.out.println("Cost is: " + cost);			
		return cost;
	}
	
	//Move Grids: return 1 if possible
	public int right() {
		if(blank.getX() != 0) {
			int value = grids[blank.getX()-1][blank.getY()].getValue();	
			grids[blank.getX()-1][blank.getY()].setValue(blank.getValue());
			blank.setValue(value);
			setBlankGrid();
			return 1;
		}
		else
			return -1;
	}
	
	public int left() {
		if(blank.getX() != 2) {
			int value = grids[blank.getX()+1][blank.getY()].getValue();	
			grids[blank.getX()+1][blank.getY()].setValue(blank.getValue());
			blank.setValue(value);
			setBlankGrid();
			return 1;
		}
		else
			return -1;
	}
	
	public int up() {
		if(blank.getY() != 2) {
			int value = grids[blank.getX()][blank.getY()+1].getValue();	
			grids[blank.getX()][blank.getY()+1].setValue(blank.getValue());
			blank.setValue(value);
			setBlankGrid();
			return 1;
		}
		else
			return -1;
	}
	
	public int down() {
		if(blank.getY() != 0) {
			int value = grids[blank.getX()][blank.getY()-1].getValue();	
			grids[blank.getX()][blank.getY()-1].setValue(blank.getValue());
			blank.setValue(value);
			setBlankGrid();
			return 1;
		}
		else
			return -1;
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
				//grids[i][j].printGrid();
				draw(c, g, grids[i][j].getValue(), i, j);
			}
		}				
	}
	
	@Override
	public void draw(Component c, Graphics g, int i, int x, int y) {
		icons.getIcon(i).paintIcon(c, g, x*121 + 10, y*121 + 10);
	}
}

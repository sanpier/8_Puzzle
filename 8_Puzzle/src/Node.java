import java.util.ArrayList;
import java.util.Random;

public class Node {

	// Variables
	private Grid[][] configuration;
	private Grid blank;
	private int cost;
	
	// Constructor
	public Node(boolean initial) {
		configuration = new Grid[3][3];
		initializeGrids();
		if(initial)
			setInitialRandomConfiguration();
		else {
			blank = new Grid();
			cost = -1;
		}
	}
	
	public Node(Grid[][] configuration) {
		setNode(configuration);
	}
	
	//Initializer
	public void initializeGrids() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				configuration[i][j] = new Grid();
			}
		}			
	}
	
	// Getters
	public Grid[][] getConfiguration() {
		return configuration;
	}
	
	public Grid getGrid(int x, int y) {
		return configuration[x][y];
	}

	public int getCost() {
		return cost;
	}
	
	// Setters
	public void setNode(Grid[][] grids) {
		setConfiguration(grids);
		boardCost();
		setBlank();
	}
	
	public void setConfiguration(Grid[][] grids) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
	    		configuration[i][j].setValue(grids[i][j].getValue());
    			configuration[i][j].setXandY(i,j);		    		
			}				
		} 	
	}
	
	public void setBlank() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
	    		if(configuration[i][j].getValue() == 0)
	    			blank = configuration[i][j];
			}				
		} 	
	}
	
	public void boardCost() {
		cost = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cost = cost + configuration[i][j].calcOneGridCost();
			}				
		} 			
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
			
	//Initial Configuration
	public void setInitialRandomConfiguration() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i<= 8; i++) 
			nums.add(i);
		
		Random generator = new Random();
		int randIndex, randVal;
		
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= 2; j++) {
				if(i != 2 || j != 2) {
					randIndex = generator.nextInt(nums.size());
					randVal = nums.get(randIndex);
					nums.remove(randIndex);
					configuration[i][j].setValue(randVal);
					configuration[i][j].setXandY(i,j);
				}
			}
		}
		configuration[2][2].setValue(0);
		configuration[2][2].setXandY(2,2);
		
		//printGrids();		
		boardCost();
		setBlank();
	}
	
	//Print Methods	
	public void printGrids() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(configuration[j][i].getValue() + " ");
			}
			System.out.println();
		} 	
		System.out.println("Cost is: " + cost + "  Blank grid: x=" + blank.getX() + " y=" + blank.getY());
		System.out.println();
	}
	
	//Move Grids
	public int right() {
		if(blank.getX() != 0) {
			int value = configuration[blank.getX()-1][blank.getY()].getValue();	
			configuration[blank.getX()-1][blank.getY()].setValue(blank.getValue());
			configuration[blank.getX()][blank.getY()].setValue(value);
			setBlank();
			boardCost();
			return 1;
		}
		else
			return -1;
	}
		
	public int left() {
		if(blank.getX() != 2) {
			int value = configuration[blank.getX()+1][blank.getY()].getValue();	
			configuration[blank.getX()+1][blank.getY()].setValue(blank.getValue());
			configuration[blank.getX()][blank.getY()].setValue(value);
			setBlank();
			boardCost();
			return 1;
		}
		else
			return -1;
	}
		
	public int up() {
		if(blank.getY() != 2) {
			int value = configuration[blank.getX()][blank.getY()+1].getValue();	
			configuration[blank.getX()][blank.getY()+1].setValue(blank.getValue());
			configuration[blank.getX()][blank.getY()].setValue(value);
			setBlank();
			boardCost();
			return 1;
		}
		else
			return -1;
	}
		
	public int down() {
		if(blank.getY() != 0) {
			int value = configuration[blank.getX()][blank.getY()-1].getValue();	
			configuration[blank.getX()][blank.getY()-1].setValue(blank.getValue());
			configuration[blank.getX()][blank.getY()].setValue(value);
			setBlank();
			boardCost();
			return 1;
	}
		else
			return -1;		
	}
}
import java.util.ArrayList;
import java.util.Random;

public class Node {

	// Variables
	private Grid[][] configuration;
	private Grid blank;
	private double cost;
	private ArrayList<String> actions;
	
	// Constructor
	public Node() {
		configuration = new Grid[3][3];
		initializeGrids();
		blank = new Grid();
		cost = -1;		
		actions = new ArrayList<String>(); 
		actions.add("no");
	}
	
	public Node(boolean initial) {
		configuration = new Grid[3][3];
		initializeGrids();
		actions = new ArrayList<String>(); 
		actions.add("no");
		initializeRandomFromSolved();
	}
	
	public Node(Node given) {
		configuration = new Grid[3][3];
		initializeGrids();
		setConfiguration(given.configuration);
		this.blank = given.blank;
		this.cost = given.cost;
		this.actions = new ArrayList<String>();
		for(int i = 0; i < given.actions.size(); i++)
			this.actions.add(given.actions.get(i));
	}
	
	//Initializer
	public void initializeGrids() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				configuration[i][j] = new Grid();
			}
		}			
	}
	
	public void initializeRandomFromSolved() {	//Randomized from solution configuration
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				configuration[i][j].setValue( (i+1+j*3) % 9 );
				configuration[i][j].setXandY(i,j);
			}
		}
			
		boardCost();
		setBlank();
		randomize();

		//Print initial grids
		System.out.println("Initial random grids:");
		printGrids();
	}
	
	public void randomize() {
		Random generator = new Random();
		int rand = 0;
		int prerand = 0;
		for(int i = 0; i < 100; i++) {	//Random 100 actions from the solution configuration
			rand = generator.nextInt(4);
			if(rand == 0 && prerand != 1)
				left();
			else if(rand == 1 && prerand != 0)
				right();
			else if(rand == 2 && prerand != 3)
				down();
			else if(rand == 3 && prerand != 2)
				up();	
			prerand = rand;
		}
	}
	
	// Getters
	public Grid[][] getConfiguration() {
		return configuration;
	}
	
	public Grid getGrid(int x, int y) {
		return configuration[x][y];
	}

	public double getCost() {
		return cost;
	}
	
	public int getActualCost() {
		int actual_cost = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				actual_cost = actual_cost + configuration[i][j].calcOneGridCost();
			}				
		} 	
		
		return actual_cost;
	}
	
	public ArrayList<String> getActions() {
		return actions;
	}
	
	public String getLastAction() {
		return actions.get(actions.size()-1);
	}
	
	public String getAction(int i) {
		return actions.get(i+1);
	}
	
	public int getActionSize() {
		return actions.size()-1;
	}
	
	// Setters
	public void setNode(Node given) {
		setConfiguration(given.configuration);
		this.blank = given.blank;
		this.cost = given.cost;
		this.actions.clear();
		for(int i = 0; i < given.actions.size(); i++)
			this.actions.add(given.actions.get(i));
	}
	
	public void setActions(Node given) {
		this.actions.clear();
		for(int i = 0; i < given.actions.size(); i++)
			this.actions.add(given.actions.get(i));
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
			
		//Step cost
		//System.out.println("Step cost " + getActions().size() + " added to " + cost);
		cost = cost + ( Double.valueOf(getActions().size() - 1) / 5.0 );
	}
	
	public void addAction(String action) {
		actions.add(action);
	}
	
	public void removeLastAction() {
		actions.remove(actions.size()-1);
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
		for(int i = 0; i < actions.size(); i++)
			System.out.print(actions.get(i) + ", ");
		System.out.println();
		System.out.println();
	}
	
	public void printFundamentals() {
		System.out.println("Cost is: " + cost + "  Blank grid: x=" + blank.getX() + " y=" + blank.getY());
		for(int i = 0; i < actions.size(); i++)
			System.out.print(actions.get(i) + ", ");
		System.out.println();
	}

	public void printActions() {
		for(int i = 0; i < actions.size(); i++)
			System.out.print(actions.get(i) + ", ");
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
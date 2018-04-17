public class Node {

	// Variables
	private static Grid[][] configuration;
	private static Grid blank;
	private int cost;
	
	// Constructor
	public Node() {
		this.configuration = new Grid[3][3];
		blank = new Grid();
		this.cost = -1;
	}
	
	public Node(Grid[][] configuration) {
		this.configuration = configuration;
		setBlank();
		boardCost();
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
	public void setConfiguration(Grid[][] grids) {
		configuration = grids;
		boardCost();
	}

	public void setCost(int cost) {
		this.cost = cost;
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
		int c = 0;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
	    		c = c + configuration[i][j].calcOneGridCost();
			}				
		} 				
		cost = c;
	}
	
	//Print Methods	
	public void printGrids() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(configuration[j][i].getValue() + " ");
			}
			System.out.println();
		} 	
		System.out.println();
	}
	
	//Move Grids
	public int right() {
		if(blank.getX() != 0) {
			int value = configuration[blank.getX()-1][blank.getY()].getValue();	
			configuration[blank.getX()-1][blank.getY()].setValue(blank.getValue());
			blank.setValue(value);
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
			blank.setValue(value);
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
			blank.setValue(value);
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
			blank.setValue(value);
			setBlank();
			boardCost();
			return 1;
	}
		else
			return -1;		
	}
}
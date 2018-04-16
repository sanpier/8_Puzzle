public class Node {

	// Variables
	private Grid[][] configuration;
	private int cost;
	
	// Constructor
	public Node() {
		this.configuration = new Grid[3][3];
		this.cost = -1;
	}
	
	public Node(Grid[][] configuration, int cost) {
		this.configuration = configuration;
		this.cost = cost;
	}
		
	// Getters
	public Grid[][] getConfiguration() {
		return configuration;
	}

	public int getCost() {
		return cost;
	}
	
	// Setters
	public void setConfiguration(Grid[][] grids) {
		configuration = grids;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}

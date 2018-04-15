public class Node {

	// Variables
	private Grid[][] configuration;
	private int cost;
	
	// Constructor
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
}

import java.util.ArrayList;

public class Tree {
	
	// Variables
	private ArrayList<Node> leaves;
	private Node minOne;
		
	// Constructors
	public Tree(Node root) {
		leaves = new ArrayList<Node>();
		leaves.add(root);
		setMinNode();
	}
			
	// Getters
	public ArrayList<Node> getTree() {
		return leaves;
	}
	
	public int getCostOfNode(int i) {
		return leaves.get(i).getCost();
	}
	
	public Node getMinNode() {
		return minOne;
	}
	
	//Tree functions
	public void addNode(Node newOne) {
		for(int i = 1; i < leaves.size(); i++) {
			if(newOne.getCost() <= getCostOfNode(i))
				leaves.add(i, newOne);
		}	
		leaves.add(newOne);
	}
	
	public void setMinNode() {		
		minOne = leaves.get(0);
	}
	
	public void removeMinNode() {		
		leaves.remove(0);
	}
}

import java.util.ArrayList;

public class Tree {
	
	// Variables
	private ArrayList<Node> leaves;
	private Node exploreNode, left, right, down, up;
	int lastDirection;
		
	// Constructors
	public Tree(Node root) {
		leaves = new ArrayList<Node>();
		leaves.add(root);
		exploreNode = root;
		lastDirection = 0;
	}
			
	// Getters
	public ArrayList<Node> getTree() {
		return leaves;
	}
	
	public int getCostOfNode(int i) {
		return leaves.get(i).getCost();
	}
	
	public Node getExploreNode() {
		return exploreNode;
	}
	
	//Tree functions
	public void addNode(Node newOne) {
		for(int i = 1; i < leaves.size(); i++) {
			if(newOne.getCost() <= getCostOfNode(i))
				leaves.add(i, newOne);
		}	
		leaves.add(newOne);
	}
	
	public void exploreNode()
	{
		if(lastDirection != 2 && exploreNode.left() == 1) {
			left.setConfiguration(exploreNode.getConfiguration());
			exploreNode.right();
		}
		else
			left.setCost(-1);
		if(lastDirection != 1 && exploreNode.right() == 1) {
			right.setConfiguration(exploreNode.getConfiguration());	
			exploreNode.left();
		}
		else
			right.setCost(-1);
		if(lastDirection != 3 && exploreNode.up() == 1) {
			up.setConfiguration(exploreNode.getConfiguration());	
			exploreNode.down();
		}
		else
			up.setCost(-1);
		if(lastDirection != 4 && exploreNode.down() == 1) {
			down.setConfiguration(exploreNode.getConfiguration());	
			exploreNode.up();
		}
		else
			down.setCost(-1);
	}
}

import java.util.ArrayList;

public class Tree {
	
	// Variables
	private ArrayList<Node> leaves;
	private Node exploreNode, left, right, down, up;
	int lastAction;
		
	// Constructors
	public Tree(Node root) {		
		leaves = new ArrayList<Node>();
		
		//Nodes
		exploreNode = new Node(false);
		exploreNode.setNode(root.getConfiguration());
		/*System.out.println("Explore node in tree:");
		exploreNode.printGrids();*/
		
		left = new Node(false);
		right = new Node(false);
		down = new Node(false);
		up = new Node(false);		
		
		//Set tree
		explore();
		lastAction = 0;
	}
			
	// Getters
	public ArrayList<Node> getTree() {
		return leaves;
	}
	
	public int getCostOfNode(int i) {
		return leaves.get(i).getCost();
	}
	
	public int getExploreNodeCost() {
		return exploreNode.getCost();
	}
	
	//Tree functions
	public void addNode(Node newOne) {
		leaves.add(newOne);
		System.out.println("Following node is added to tree:");
		newOne.printGrids();
	}
		
	public void setExploredOne() {		// Remove explored one and set new one
		int minIndex = 0;
		int minCost = 500;
		for(int i = 0; i < leaves.size(); i++) {
			if(getCostOfNode(i) <= minCost) {
				minCost = getCostOfNode(i);
				minIndex = i;				
			}
		}		

		//Print min node
		/*System.out.println("Min cost node in the tree:");
		leaves.get(minIndex).printGrids();*/
		
		exploreNode.setNode(leaves.get(minIndex).getConfiguration());
		leaves.remove(minIndex);
		
		//Print explore node
		System.out.println("Explore node is set to:");
		exploreNode.printGrids();
		
		//Tree after explore node is set
		System.out.println("Explore node is set and removed from tree!");
		printTree();
	}
	
	public void explore()				// Add all possible nodes
	{		
		System.out.println("Exploring:");
		//Add nodes
		if(lastAction != 2 && exploreNode.left() == 1) {	// Left
			left.setNode(exploreNode.getConfiguration());
			
			System.out.println("Left action is possible");
			addNode(left);
			
			//Backtrack
			exploreNode.right();										
			/*System.out.println("Left added, explore node backtracked");
			exploreNode.printGrids();*/
		}
		else
			left.setCost(-1);
		if(lastAction != 1 && exploreNode.right() == 1) {	// Right
			right.setNode(exploreNode.getConfiguration());
			
			System.out.println("Right action is possible");
			addNode(right);
			
			//Backtrack
			exploreNode.left();
			/*System.out.println("Right added, explore node backtracked");
			exploreNode.printGrids();*/
		}
		else
			right.setCost(-1);
		if(lastAction != 3 && exploreNode.up() == 1) {		// Up
			up.setNode(exploreNode.getConfiguration());
			
			System.out.println("Up action is possible");
			addNode(up);
			
			//Backtrack
			exploreNode.down();
			/*System.out.println("Up added, explore node backtracked");
			exploreNode.printGrids();*/
		}
		else
			up.setCost(-1);
		if(lastAction != 4 && exploreNode.down() == 1) {	// Down
			down.setNode(exploreNode.getConfiguration());	
			
			System.out.println("Down action is possible");
			addNode(down);
			
			//Backtrack
			exploreNode.up();
			/*System.out.println("Down added, explore node backtracked");
			exploreNode.printGrids();*/
		}
		else
			down.setCost(-1);
		
		//Set new explored node
		printTree();
		setExploredOne();
	}
	
	//Print
	public void printTree() {
		System.out.println("Whole tree:");		
		for(int i = 0; i < leaves.size(); i++) {
			System.out.println("Node number = " + i);
			leaves.get(i).printGrids();
		}		
	}
}

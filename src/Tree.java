import java.util.ArrayList;
public class Tree {

	// Variables
	private ArrayList<Node> tree;
	private Node exploredNode;
	private boolean printNode;
	private boolean printTree;
	
	// Constructor
	public Tree(Node root) {
		tree = new ArrayList<Node>();
		exploredNode = new Node(root);
		
		printNode = true;
		printTree = true;
	}
	
	// Getters
	public Node getNode() {
		return exploredNode;
	}
	
	public ArrayList<Node> getTree() {
		return tree;
	}
	
	public double getActualCost() {
		return exploredNode.getActualCost();
	}
	
	public int getMoveCount() {
		return exploredNode.getActionSize();
	}
	
	public String getMovement(int i) {
		return exploredNode.getAction(i);
	}
	
	// Methods
	public void addNode(Node given) {
		Node newOne = new Node(given);
		
		boolean added = false;
		for(int i = 0; i < tree.size(); i++) {
			if(newOne.getCost() < tree.get(i).getCost()) {
				tree.add(i, newOne);
				added = true;
				break;
			}				
		}
		if(!added) 
			tree.add(tree.size(), newOne);
		
		//Tree size is max = 6
		//if(tree.size() > 6)
		//	tree.remove(6);	// Remove most costly one
	}
	
	public void updateExploredNode() {
		exploredNode.setNode(tree.get(0));
		tree.remove(0);
		
		//Print
		if(printNode) {
			System.out.println("Explored Node is updated to following: ");
			exploredNode.printGrids();
		}
		if(printTree)
			printTree();	
	}
	
	public double getExploreNodeCost() {
		exploredNode.boardCost();
		return exploredNode.getCost();
	}
	
	public void explore() {
		//Print exploring node
		if(printNode) {
			System.out.println("Exploring the node:");
			exploredNode.printGrids();
		}
		
		if(exploredNode.left() == 1) {
			if( !exploredNode.getLastAction().equalsIgnoreCase("right") ) {
				if(printNode)
					System.out.println("Left action is possible, following node is added:");
				exploredNode.addAction("left");
				exploredNode.setBlank();
				exploredNode.boardCost();
				if(printNode)
					exploredNode.printGrids();
				addNode(exploredNode);
				
				exploredNode.removeLastAction();
			}
			//Reverse
			exploredNode.right();
			exploredNode.setBlank();
			exploredNode.boardCost();
		}
		if(exploredNode.right() == 1) {
			if( !exploredNode.getLastAction().equalsIgnoreCase("left") ) {
				if(printNode)
					System.out.println("Right action is possible, following node is added:");
				exploredNode.addAction("right");
				exploredNode.setBlank();
				exploredNode.boardCost();
				if(printNode)
					exploredNode.printGrids();
				addNode(exploredNode);
				
				exploredNode.removeLastAction();
			}
			//Reverse
			exploredNode.left();
			exploredNode.setBlank();
			exploredNode.boardCost();
		}
		if(exploredNode.down() == 1) {
			if( !exploredNode.getLastAction().equalsIgnoreCase("up") ) {
				if(printNode)
					System.out.println("Down action is possible, following node is added:");
				exploredNode.addAction("down");				
				exploredNode.setBlank();
				exploredNode.boardCost();
				if(printNode)
					exploredNode.printGrids();
				addNode(exploredNode);

				exploredNode.removeLastAction();
			}
			//Reverse
			exploredNode.up();
			exploredNode.setBlank();
			exploredNode.boardCost();
		}
		if(exploredNode.up() == 1) {
			if( !exploredNode.getLastAction().equalsIgnoreCase("down") ) {
				if(printNode)
					System.out.println("Up action is possible, following node is added:");
				exploredNode.addAction("up");
				exploredNode.setBlank();
				exploredNode.boardCost();
				if(printNode)
					exploredNode.printGrids();
				addNode(exploredNode);

				exploredNode.removeLastAction();
			}
			//Reverse
			exploredNode.down();			
			exploredNode.setBlank();
			exploredNode.boardCost();
		}
		
		//Update explored node
		updateExploredNode();
	}
	
	//Print Methods	
	public void printTree() {
		System.out.println("Whole tree is: ");
		for(int i = 0; i < tree.size(); i++) {
			System.out.println("Node number: " + i);
			tree.get(i).printGrids();
		}
		System.out.println();
	}
	
	public void printExploredNode() {
		exploredNode.printGrids();
	}
}
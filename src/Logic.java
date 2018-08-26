import java.awt.Component;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

public class Logic{
	
	//Variables
	private Node activeNode;	
	private Tree tree;
	private Board board;
			
	//Constructor
	public Logic()
	{		
		//Active Node
		activeNode = new Node(true);	// randomized from solution
		
		//Board
		board = new Board(activeNode);		
		
		//Tree
		tree = new Tree(activeNode);
	}
	
	//Getters
	public Board getBoard() {
		return board;
	}
	
	public int getMoveCount() {
		return tree.getMoveCount();
	}
	
	public String getMovement(int i) {
		return tree.getMovement(i);
	}
	
	//Functions
	public void updateActiveNode() { // Set active node by getting explore node from the Tree
		activeNode.setActions(tree.getNode());
		System.out.println("Logic is updating its active node to following: ");
		activeNode.printGrids();
	}
	
	//Solve using the tree
	public void solvePuzzle() {
		int step = 0;
		while(tree.getActualCost() != 0) {
			tree.explore();
			step++;
		}		
		System.out.println("Solution configuration is found: ");
		tree.printExploredNode();
		System.out.println("Solution found in " + step + " steps!");
		System.out.println("Solution has " + tree.getMoveCount() + " moves!");		
	}
	
	//Move Grids		
	public void moveRight() {
		activeNode.right();
		//activeNode.printGrids();
	}
	
	public void moveLeft() {
		activeNode.left();
		//activeNode.printGrids();
	}
	
	public void moveUp() {
		activeNode.up();
		//activeNode.printGrids();
	}
	
	public void moveDown() {
		activeNode.down();
		//activeNode.printGrids();
	}
	
	//Draw
	public void draw(Component c, Graphics g) {
		board.setActiveNode(activeNode);
		board.drawAllPieces(c,g);
	}
}

import java.awt.Component;
import java.awt.Graphics;

public class Logic{
	
	//Variables
	private Node activeNode;
	private Tree tree;
	private Board board;
			
	//Constructor
	public Logic()
	{		
		activeNode = new Node(true);	// Initial random positions
		System.out.println("Initial random grids:");
		activeNode.printGrids();

		board = new Board(activeNode);		
		tree = new Tree(activeNode);
	}
	
	//Getter
	public Board getBoard() {
		return board;
	}
	
	//Heuristic Functions
	public void solvePuzzle() {
		int maxStep = 50;
		while(tree.getExploreNodeCost() != 0 && maxStep != 0) {
			tree.explore();
			maxStep--;
		}
	}
	
	/*public void solvePuzzle() {
		int maxStep = 250;
		while(min != 0 && maxStep != 0) {
			lookLeastCost();
			maxStep--;
		}
		
		//Print the result
		if(min == 0)
			System.out.println("Success: at " + (250-maxStep) + " steps");
		else
			System.out.println("No solution exist for this configuration!");
	}
	
	public void lookLeastCost() {
		try {
		    /*Thread.sleep(300);	
		    draw(panel, panel.getGraphics());		
		    panel.repaint();*/
		/*}
		catch(Exception e) {
			System.out.println("Exception is catched");
		}
		
		currentCost = board.calcBoardCost();
		
		//Cost of each direction if previous direction is not opposite of it
		if(lastDirection != 2 && board.left() == 1) {
			leftCost = board.calcBoardCost();		
			board.right();
		}
		else 
			leftCost = 100;	
		
		if(lastDirection != 1 && board.right() == 1) {
			rightCost = board.calcBoardCost();
			board.left();
		}
		else 
			rightCost = 100;
		
		if(lastDirection != 3 && board.up() == 1) {
			upCost = board.calcBoardCost();
			board.down();
		}
		else 
			upCost = 100;
		
		if(lastDirection != 4 && board.down() == 1) {
			downCost = board.calcBoardCost();
			board.up();
		}
		else
			downCost = 100;
			
		System.out.println("Costs: left=" + leftCost + " right=" + rightCost 
				+ " down=" + downCost + " up=" + upCost);
		
		//Direction is determined
		int direction = minCostDirection();
		System.out.println("Min cost: " + min + "  Direction: " + direction + "  Current Cost: " + currentCost);
		
		//Take action
		if(direction == 1) { //Left
			moveLeft();
		}
		else if(direction == 2) { //Right
			moveRight();
		}
		else if(direction == 3) { //Down
			moveDown();		
		}
		else if(direction == 4) { //Up
			moveUp();
		}
		
		lastDirection = direction;
	}
	
	public int minCostDirection() { //Calculates min cost / returns that direction as 1,2,3,4		
		if(leftCost <= rightCost) {
			minx = leftCost;
			xdirection = 1;
		}
		else {
			minx = rightCost;
			xdirection = 2;
		}
		if(downCost <= upCost) {
			miny = downCost;
			ydirection = 3;
		}
		else {
			miny = upCost;
			ydirection = 4;
		}
		if(minx <= miny) { //Return 1=LEFT / 2=RIGHT OR 3=DOWN / 4=UP
			min = minx;
			return xdirection;
		}
		else {
			min = miny;
			return ydirection;
		}
	}*/
	
	//Move Grids	
	public void moveRight() {
		activeNode.right();
		activeNode.printGrids();
	}
	
	public void moveLeft() {
		activeNode.left();
		activeNode.printGrids();
	}
	
	public void moveUp() {
		activeNode.up();
		activeNode.printGrids();
	}
	
	public void moveDown() {
		activeNode.down();
		activeNode.printGrids();
	}
	
	//Draw
	public void draw(Component c, Graphics g) {
		board.setActiveNode(activeNode);
		board.drawAllPieces(c,g);
	}
}

import java.awt.Component;
import java.awt.Graphics;

public class Logic{
	
	//Variables
	private Board board;
	int currentCost, leftCost, rightCost, upCost, downCost;
	int min, minx, miny, xdirection, ydirection;
	
	//Constructor
	public Logic()
	{
		board = new Board();
		min = 100;
	}
	
	//Getter
	public Board getBoard() {
		return board;
	}
	
	//Heuristic Functions
	public void solvePuzzle() {
		while(min != 0) {
			if(lookLeastCost().equalsIgnoreCase("Fail"))
				break;
		}
		if(min == 0)
			System.out.println("Success");
		else
			System.out.println("Fail");
	}
	
	public String lookLeastCost() {
		currentCost = board.calcBoardCost();
		
		//Cost of each direction
		if(board.left() == 1) {
			leftCost = board.calcBoardCost();		
			board.right();
		}
		else 
			leftCost = 100;	
		
		if(board.right() == 1) {
			rightCost = board.calcBoardCost();
			board.left();
		}
		else 
			rightCost = 100;
		
		if(board.up() == 1) {
			upCost = board.calcBoardCost();
			board.down();
		}
		else 
			upCost = 100;
		
		if(board.down() == 1) {
			downCost = board.calcBoardCost();
			board.up();
		}
		else
			downCost = 100;
			
		System.out.println("Costs: left=" + leftCost + " right=" + rightCost 
				+ " down=" + downCost + " up=" + upCost);
		
		//Move one step	
		int direction = minCostDirection();
		System.out.println("Min cost: " + min + "  Direction: " + direction + "  Current Cost: " + currentCost);
		
		if(min <= currentCost) {
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
			
			return "Success";
		}
		else
			return "Fail";		
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
	}
	
	//Move Grids	
	public void moveRight() {
		board.right();
		board.printGrids();
		board.calcBoardCost();
	}
	
	public void moveLeft() {
		board.left();
		board.printGrids();
		board.calcBoardCost();
	}
	
	public void moveUp() {
		board.up();
		board.printGrids();
		board.calcBoardCost();
	}
	
	public void moveDown() {
		board.down();
		board.printGrids();
		board.calcBoardCost();
	}
	
	public void draw(Component c, Graphics g) {
		board.drawAllPieces(c,g);
	}
}

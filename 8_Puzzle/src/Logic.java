import java.awt.Component;
import java.awt.Graphics;

public class Logic{
	
	//Variables
	private Board board;
	
	//Constructor
	public Logic()
	{
		board = new Board();
	}
	
	//Getter
	public Board getBoard() {
		return board;
	}
	
	//Heuristic Function
	public void solvePuzzle() {
		
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

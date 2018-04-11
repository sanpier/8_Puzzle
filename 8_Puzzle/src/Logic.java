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
		
	//Move Grids	
	public void moveRight() {
		board.right();
		board.printGrids();
	}
	
	public void moveLeft() {
		board.left();
		board.printGrids();
	}
	
	public void moveUp() {
		board.up();
		board.printGrids();
	}
	
	public void moveDown() {
		board.down();
		board.printGrids();
	}
}

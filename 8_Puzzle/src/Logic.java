import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
//import javax.swing.ImageIcon;

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
	
	//Calculations
	public int calcBoardCost() {
    	int cost = 0;
    	for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
	    		cost = cost + board.getGrid(i,j).calcOneGridCost();
			}				
		} 
    	
    	/*
    	System.out.println();
		System.out.println("Cost is: " + cost);
		*/    	
    	return cost;
    }
	
	//Move Grids	
	public void moveRight() {
		Grid mover = board.getGrid(board.getBlank().getX()-1, board.getBlank().getY());
		exchangeGrids(mover, board.getBlank());
	}
	
	public void moveLeft() {
		Grid mover = board.getGrid(board.getBlank().getX()+1, board.getBlank().getY());
		exchangeGrids(mover, board.getBlank());
	}
	
	public void moveUp() {
		Grid mover = board.getGrid(board.getBlank().getX(), board.getBlank().getY()+1);
		exchangeGrids(mover, board.getBlank());
	}
	
	public void moveDown() {
		Grid mover = board.getGrid(board.getBlank().getX(), board.getBlank().getY()-1);
		exchangeGrids(mover, board.getBlank());
	}
	
	public void exchangeGrids(Grid a, Grid b) {
		a.setXandY(b.getX(), b.getY());
		b.setXandY(a.getX(), a.getY());
		
		board.setBlankGrid();
	}
}

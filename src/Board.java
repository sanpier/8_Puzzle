import java.awt.Component;
import java.awt.Graphics;

public class Board implements Drawable{
	
	//Variables
	private Node activeNode;
	private Icons icons;
	
	//Constructor
	public Board(Node given)
	{
		activeNode = new Node();
		setActiveNode(given);				
		icons = new Icons();
	}
				
	//Setter
	public void setActiveNode(Node given) {
		activeNode.setNode(given);
	}
	
	//Draw	Methods
	public void drawAllPieces(Component c, Graphics g){
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				//grids[i][j].printGrid();
				draw(c, g, activeNode.getGrid(i, j));
			}
		}				
	}
		
	@Override
	public void draw(Component c, Graphics g, Grid grid) {
		icons.getIcon(grid.getValue()).paintIcon(c, g, grid.getX()*121 + 10, grid.getY()*121 + 10);
	}
}
import java.awt.Component;
import java.awt.Graphics;

public class Board implements Drawable{
	
	//Variables
	private Node activeNode;
	private Icons icons;
	
	//Constructor
	public Board()
	{
		activeNode = new Node();				
		icons = new Icons();
	}
	
	//Other Functions
	/*public void assignValues() {
		Random generator = new Random();
		int randIndex;
		int randNum;
			
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i!=2 || j!=2) {
			    	randIndex = generator.nextInt(nums.size());
			    	randNum = nums.get(randIndex);
			    	nums.remove(randIndex);
			    	grids[i][j].setValue(randNum);
				}				
			} 
		}
	}*/
			
	//Setter
	public void setActiveNode(Node given) {
		activeNode = given;
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
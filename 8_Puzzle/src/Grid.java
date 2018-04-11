/*import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;*/

public class Grid{
	
	// Variables
	private int x, y;
	private int value;
	
	// Constructors
	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
		value = 0;
	}
	
	public Grid(int x, int y, int val) {
		this.x = x;
		this.y = y;
		value = val;
	}
	
	// Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}	
	
	public int getValue() {
		return value;
	}
		
	//Setter
	public void setValue(int val) {
		value = val;
	}
	
	public void setXandY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Functions
	public int calcOneGridCost() { // Heuristic Function *
		if(value != 0) {
			int solX = getValue() % 3;
			int solY = (int) Math.floor(getValue() / 3);

			// System.out.print(number + " cost: " + (Math.abs(x - solX) + Math.abs(y - solY)) + " " );
			return Math.abs(x - solX) + Math.abs(y - solY);
		}
		return 0;
	}
	
	// Draw
	/*@Override
	public void draw(Component c, Graphics g) {
		if(value != 0)
			getImage().paintIcon(c, g, x*121 + 10, y*121 + 10);
	}*/
}

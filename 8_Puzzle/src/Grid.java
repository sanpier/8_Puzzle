import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Grid implements Drawable{
	
	// Variables
	private int x, y;
	private Piece value;
	
	// Constructors
	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
		value = null;
	}
	
	public Grid(int x, int y, Piece val) {
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
		return value.getValue();
	}
	
	public ImageIcon getImage() {
		return value.getImage();
	}
	
	//Setter
	public void setValue(Piece val) {
		value = val;
	}
	
	// Functions
	public int calcOneGridCost() { // Heuristic Function *
		if(value != null) {
			int solX = getValue() % 3;
			int solY = (int) Math.floor(getValue() / 3);

			// System.out.print(number + " cost: " + (Math.abs(x - solX) + Math.abs(y - solY)) + " " );
			return Math.abs(getX() - solX) + Math.abs(getY() - solY);
		}
		return 0;
	}
	
	// Draw
	@Override
	public void draw(Component c, Graphics g) {
		if(value != null)
			getImage().paintIcon(c, g, getX() * 121 + 10, getY() * 121 + 10);
	}
}

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Piece implements Drawable{

	// Variables
	private int value, x, y;
	private ImageIcon icon;

	// Constructor
	public Piece(int val) {
		value = val;
		icon = new ImageIcon("src/" + val + ".png");
	}
	
	//Getters
	public int getValue() {
		return value;
	}
	
	public ImageIcon getImage() {
		return icon;
	}
	
	//Setter
	public void setXandY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Draw
	@Override
	public void draw(Component c, Graphics g) {
		if(value != 0)
			getImage().paintIcon(c, g, x + 10, y + 10);
	}
}

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Grid implements Drawable{
	
	// Variables
	private int x, y;
	private Piece piece;
	
	// Constructors
	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}	
	
	public Piece getPiece() {
		return piece;
	}
	
	public int getValue() {
		return piece.getValue();
	}
	
	public ImageIcon getIcon() {
		return piece.getIcon();
	}
		
	//Setter
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	// Functions
	public int calcOneGridCost() {
		if(piece.getValue() > 0) {
			int solX = (getValue()-1) % 3;
			int solY = (int) Math.floor((getValue()-1) / 3);

			// System.out.print(number + " cost: " + (Math.abs(x - solX) + Math.abs(y - solY)) + " " );
			return Math.abs(x - solX) + Math.abs(y - solY);
		}
		return 0;
	}
	
	// Draw
	@Override
	public void draw(Component c, Graphics g) {
		if(getValue() > 0)
			getIcon().paintIcon(c, g, x*121 + 10, y*121 + 10);
	}
}

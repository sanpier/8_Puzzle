import javax.swing.ImageIcon;

public class Piece{

	// Variables
	private int value;
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
}

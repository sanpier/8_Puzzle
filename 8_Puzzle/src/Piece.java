import javax.swing.ImageIcon;

public class Piece{
	private int value;
	private ImageIcon icon;
	
	//Constructor
	public Piece(int value) {
		value = 0;
		icon = new ImageIcon("src/" + value + ".png");
	}
	
	//Getters
	public int getValue() {
		return value;
	}	
	
	public ImageIcon getIcon() {
		return icon;
	}
}

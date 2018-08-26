import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Icons{
	private ArrayList<ImageIcon> icons;
	
	//Constructor
	public Icons() {
		icons = new ArrayList<ImageIcon>();
		for(int i = 0; i <= 8; i++) 
			icons.add(new ImageIcon("src/" + i + ".png"));		
	}
	
	//Getter
	public ImageIcon getIcon(int i) {
		return icons.get(i);
	}	
}

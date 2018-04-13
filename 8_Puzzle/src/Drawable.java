import java.awt.Component;
import java.awt.Graphics;

public interface Drawable 
{
	public void draw(Component c, Graphics g, int i, int x, int y); 
	/*All classes that implement this interface
    must have draw method in this structure, 
	but body can be different.*/
}

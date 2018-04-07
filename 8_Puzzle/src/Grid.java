import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Grid implements Drawable {

	//Variables 
	private int x, y, number; 
	ImageIcon icon;
				
	//Constructor
	public Grid(int x, int y, int num) {
	    this.x = x;
	    this.y = y;
	    number = num;
	    
	    if(num != 0)
	    	icon = new ImageIcon("src/" + num + ".png");
	    else
	    	icon = null;
	}	
	
	//Getters
    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    } 
    
	//Draw
    @Override
	public void draw(Component c, Graphics g)
	{
    	if(icon != null)
    		icon.paintIcon(c, g, getX()*121+10, getY()*121+10);						
	}
}

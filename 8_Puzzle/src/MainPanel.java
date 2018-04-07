import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel{

	//Properties
	JFrame frame;
	Board board;
				
	//Constructor
    public MainPanel(Board given) {
    	
    	//Panel Constructured
		setLayout(null);
		setPreferredSize(new Dimension(383,450));
		setBackground(Color.WHITE);
		
    	//Frame initialized
    	frame = new JFrame("Puzzle");			
		frame.setSize(383,450);		
		frame.setResizable(false);//Not changable	
		frame.setVisible(true);			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(this);//Panel is added to frame		
    	frame.pack();//Size  
    	    	
    	//Board
    	board = given;    	
    }
    
    //Paint
    public void paintComponent(Graphics g)//Drawing cards
	{
		super.paintComponent(g);//Default (must)	
				
		board.draw(this, g);	
		board.drawAllGrids(this, g);
	}
    
    //Listeners
    public class ButtonListener implements ActionListener//Inner class, listener for Buttons
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				Object current = event.getSource();
							
				/*if(current == exit)
					frame.dispose();
				else if(current == solveB){
							
				}	*/				
			}
			catch(Exception e)
			{
				System.out.println("Exception is catched");
			}				
		}	
	}	
    						    
    //Functions
    public Board getBoard()
    {
		return board;
	}
	
    public void exit()//dispose() method exit from frame
	{
		frame.dispose();
	}	
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel{

	//Properties
	JFrame frame;
	Logic logic;
				
	//JButtons
	JButton right, left, up, down, solve, exit;
	
	//Constructor
    public MainPanel(Logic given) {
    	
    	//Panel Constructured
		setLayout(null);
		setPreferredSize(new Dimension(500,450));
		setBackground(Color.white);
		
    	//Frame initialized
    	frame = new JFrame("Puzzle");			
		frame.setSize(500,450);		
		frame.setResizable(false);//Not changable	
		frame.setVisible(true);			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add(this);//Panel is added to frame		
    	frame.pack();//Size  
    	    
    	//JButtons initialized
    	right = new JButton("Right");
    	right.setSize(new Dimension(80,40));
    	right.setLocation(402,50);
    	right.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
    	right.setBackground(new Color(238,232,170));
    			
    	left = new JButton("Left");
    	left.setSize(new Dimension(80,40));
    	left.setLocation(402,120);
    	left.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
    	left.setBackground(new Color(238,232,170));
    	
    	up = new JButton("Up");
    	up.setSize(new Dimension(80,40));
    	up.setLocation(402,190);
    	up.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
    	up.setBackground(new Color(238,232,170));
    	
    	down = new JButton("Down");
    	down.setSize(new Dimension(80,40));
    	down.setLocation(402,260);
    	down.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
    	down.setBackground(new Color(238,232,170));
    	
    	solve = new JButton("Solve");
    	solve.setSize(new Dimension(80,40));
    	solve.setLocation(100,402);
    	solve.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
    	solve.setBackground(new Color(238,232,170));
    	
    	exit = new JButton("Exit");
    	exit.setSize(new Dimension(80,40));
    	exit.setLocation(200,402);
    	exit.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
    	exit.setBackground(new Color(238,232,170));
    	
    	//Add listener to buttons
    	right.addActionListener(new ButtonListener());
    	left.addActionListener(new ButtonListener());
    	up.addActionListener(new ButtonListener());
    	down.addActionListener(new ButtonListener());
    			
    	//Add components in panel
    	add(right);
    	add(left);
    	add(up);
    	add(down);
    			
    	//Board
    	logic = given;    	
    }
    
    //Paint
    public void paintComponent(Graphics g)//Drawing cards
	{
		super.paintComponent(g);//Default (must)	
		//board.draw(this, g);		
		logic.getBoard().drawAllPieces(this, g);
	}
    
    //Listeners
    public class ButtonListener implements ActionListener//Inner class, listener for Buttons
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				Object current = event.getSource();
							
				if(current == right)
					logic.moveRight();
				else if(current == left)
					logic.moveLeft();
				else if(current == up)
					logic.moveUp();
				else if(current == down)
					logic.moveDown();
				else if(current == solve)
					logic.solvePuzzle();
				else if(current == exit)
					exit();
				
				repaint();
			}
			catch(Exception e)
			{
				System.out.println("Exception is catched");
			}				
		}	
	}	
    						    
    //Functions
    public Logic getLogic()
    {
		return logic;
	}
	
    public void exit()//dispose() method exit from frame
	{
		frame.dispose();
	}	
}
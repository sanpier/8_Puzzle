import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel{

	//Properties
	JFrame frame;
	Logic logic;
	
	boolean solution;
	
	Timer timer;
	int time;
	
	String action;
	int index;
	
	//JButtons
	JButton right, left, up, down, solve, exit;
	
	//Constructor
    public MainPanel() {

    	//Logic
    	logic = new Logic(); 
    	
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
    	solve.setLocation(100,392);
    	solve.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
    	solve.setBackground(new Color(238,232,170));
    	
    	exit = new JButton("Exit");
    	exit.setSize(new Dimension(80,40));
    	exit.setLocation(210,392);
    	exit.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
    	exit.setBackground(new Color(238,232,170));
    	
    	//Add listener to buttons
    	ButtonListener listener = new ButtonListener();
    	right.addActionListener(listener);
    	left.addActionListener(listener);
    	up.addActionListener(listener);
    	down.addActionListener(listener);
    	solve.addActionListener(listener);
    	exit.addActionListener(listener);
    		
    	//Timer
    	TimerListener timeListener = new TimerListener();
    	timer = new Timer(500, timeListener);
    	time = 0;	
    	
    	action = "no";
    	index = 0;
    	
    	//Add components in panel
    	add(right);
    	add(left);
    	add(up);
    	add(down);
    	add(solve);
    	add(exit);   	
    }
    
    //Paint
    public void paintComponent(Graphics g)//Drawing cards
	{
		super.paintComponent(g);//Default (must)	
		logic.draw(this, g);
		
		if(solution){
			if(time % 3 == 0){
				if(index < logic.getMoveCount()) {
					try {
						action = logic.getMovement(index);
					}
					catch(Exception e){						
						timer.stop();
						solution = false;
					}
					index++;
					
					if(action.equalsIgnoreCase("left"))
						logic.moveLeft();
					else if(action.equalsIgnoreCase("right"))
						logic.moveRight();
					else if(action.equalsIgnoreCase("down"))
						logic.moveDown();
					else if(action.equalsIgnoreCase("up"))
						logic.moveUp();	
				}
				else {
					System.out.println("Anasýný SÝKTÝM!");								
					timer.stop();
					solution = false;
				}
			}	
		}
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
				else if(current == solve) {
					logic.solvePuzzle();
					logic.updateActiveNode();
					solution = true;
					
					time = 0;	
        			timer.start();
					repaint();		
				}
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
	
    public class TimerListener implements ActionListener//Listener for timer
   	{
   		public void actionPerformed(ActionEvent event)//Time passing
   		{			
   			repaint();								
   			time++;	
   		}		
   	}	
    
    public void exit()//dispose() method exit from frame
	{
		frame.dispose();
	}	
}
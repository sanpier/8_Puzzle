public class Grid{
	
	// Variables
	private int x, y, value;
	
	// Constructors
	public Grid() {
		x = 0;
		y = 0;
		value = 0;
	}
	
	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
		value = 0;
	}
	
	// Getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}	
	
	public int getValue() {
		return value;
	}
		
	//Setter
	public void setValue(int value) {
		this.value = value;
	}
	
	// Functions
	public int calcOneGridCost() {
		if(value > 0) {
			int solX = (getValue()-1) % 3;
			int solY = (int) Math.floor((getValue()-1) / 3);

			// System.out.print(number + " cost: " + (Math.abs(x - solX) + Math.abs(y - solY)) + " " );
			return Math.abs(x - solX) + Math.abs(y - solY);
		}
		return 0;
	}
	
	public void printGrid() {
		System.out.println(value + ": x=" + x + " y=" + y);
	}
}
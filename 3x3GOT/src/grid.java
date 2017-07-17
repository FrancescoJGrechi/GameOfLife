import java.io.*;

public class grid {
	
	///// WE DEFINE OUR CONSTANTS /////
	public static final int NUMNEIGHBORS = 4;
	public static final int WIDTH  = 3;
	public static final int HEIGHT = 3;
	
	
	///// WE DEFINE OUR NON-CONSTANT PARAMETERS /////
	public cell[] gridCurrent;

	
	// constructor method
	public grid (boolean[] seed) throws IOException, NullPointerException {
		// we initialize the cell array 
		gridCurrent = new cell[WIDTH*HEIGHT];
		
		for (int i = 0; i < gridCurrent.length; ++i)
		{
			// we initialize each cell in the array to false
			boolean alive = false;
			gridCurrent[i] = new cell(alive, i);
			
			// we initialize the grid to match the seed
			if (seed[i])
			{
				gridCurrent[i].flipStatus();
			}
			
			// we initialize each cell's neighbors
			gridCurrent[i].findNeighbors();
		}
		
	}// end of constructor method
	
	
	// method which updates the grid according to Conway's rules
	public void updateGrid(){
		
		// we create a copy of the current grid
		cell[] gridCopy = new cell[gridCurrent.length];
		deepCopy(gridCurrent, gridCopy);
				
		// we cycle through our array, and update each element
		for (int i = 0; i < gridCopy.length; ++i){
			updateCell(gridCurrent, gridCopy, i);
		}
		
		// we store this updated array as our current array
		System.arraycopy(gridCopy, 0, gridCurrent, 0, HEIGHT*WIDTH);
		
	}// end of updateGrid() method
	
	
	// method which prints out the current grid, using A for alive and D for dead
	public void printGrid(){
		System.out.println("-------------");
		for (int i = 0; i < HEIGHT; ++i){
			System.out.print("| ");
			for (int j = 0; j < WIDTH; ++j){
				gridCurrent[i*WIDTH + j].printCellStatus();
				System.out.print(" | ");
			}
			if(i < 2){
				System.out.print("\n");
			}
		}
		System.out.println("\n-------------");
	}// end of printGrid() method
	
	
	// method which prints out statistics about the current board
	public void printStats(){
		// we define the parameters to print out
		float lifeValue = 0;
		
		// we sum all values (counting alive as 1 and dead as 0), and average them
		for (int i = 0; i < WIDTH*HEIGHT; ++i){
			if (gridCurrent[i].returnCellStatus()){
				lifeValue += 1.0f;
			}
		}
		lifeValue = (1.0f * lifeValue) / (WIDTH*HEIGHT);
		
		// we print out the parameters
		System.out.printf("LifeValue = %.2f \n", lifeValue);
	}// end of printStats() method
	
	
	// static method which updates a particular cell
	private static void updateCell(cell[] gridCurrent, cell[] gridCopy, int i){
		int numAliveNeighbors = aliveNeighbors(gridCurrent, i);
		
		// if the cell is alive, we enter this branch
		if (gridCurrent[i].returnCellStatus()){
			if (numAliveNeighbors < 2 || numAliveNeighbors > 3){
				gridCopy[i].flipStatus();
			}
		}// end of cell status checking statement
		
		// if the cell is not alive, we enter this branch
		else{
			if (numAliveNeighbors == 3){
				gridCopy[i].flipStatus();
			}
		}// end of else statement
		
	}// end of updateCell() method
	
	
	// static method which returns the number of alive neighbors a given cell has
	private static int aliveNeighbors(cell[] currentGrid, int i){
		// we define the number alive neighbors
		int numAliveNeighbors = 0;
		
		// we loop through and find which neighbors are alive
		for (int j = 0; j < NUMNEIGHBORS; ++j){
			if (currentGrid[currentGrid[i].neighborIndices[j]].returnCellStatus()){
				++numAliveNeighbors;
			}
		}
		// we send back the number of alive neighbors
		return numAliveNeighbors;
	}// end of aliveNeighbors method
	
	// static method which makes a deep copy of a grid
	private static void deepCopy(cell[] currentGrid, cell[] gridCopy){
		for (int i = 0; i < WIDTH*HEIGHT; ++i){
			gridCopy[i] = new cell(currentGrid[i].returnCellStatus(), i);
			gridCopy[i].findNeighbors();
		}// end of for loop
	}// end of deepCopy() method
	

}// end of grid object

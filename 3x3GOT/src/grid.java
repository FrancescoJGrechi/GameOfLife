import java.io.*;

public class grid {
	
	///// WE DEFINE OUR CONSTANTS
	public static final int NUMNEIGHBORS = 4;
	public static final int WIDTH  = 3;
	public static final int HEIGHT = 3;
	public cell[] gridCurrent;

	public grid (boolean[] stati) throws IOException, NullPointerException {
		// we initialize the cell array 
		gridCurrent = new cell[WIDTH*HEIGHT];
		
		for (int i = 0; i < gridCurrent.length; ++i)
		{
			// we initialize each cell in the array to false
			boolean alive = false;
			gridCurrent[i] = new cell(alive);
			
			// if the input dictates alive, we flip the cell's "status"
			if (stati[i])
			{
				gridCurrent[i].flipStatus();
			}
			
			// we intialize each cell's neighbors
			gridCurrent[i].findNeighbors(i);
		}
		
	}// we initialize our grid of cells
	
	public void updateGrid(){
		// we create a copy of the current system
		cell[] gridCopy = new cell[gridCurrent.length];
		System.arraycopy(gridCurrent, 0, gridCopy, 0, WIDTH*HEIGHT);
		
		// we cycle through our array, and update each element
		for (int i = 0; i < gridCopy.length; ++i){
			updateCell(gridCurrent, gridCopy, i);
		}
		
		// we store this updated array as our current array
		System.arraycopy(gridCopy, 0, gridCurrent, 0, WIDTH*HEIGHT);
	}
	
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
	}// end of printGrid method
	
	public void printStats(){
		// we define the parameters to print out
		int lifeValue = 0;
		
		// we sum all values (counting alive as 1 and dead as 0), and average them
		for (int i = 0; i < WIDTH*HEIGHT; ++i){
			if (gridCurrent[i].returnCellStatus()){
				++lifeValue;
			}
		}
		lifeValue = lifeValue / WIDTH*HEIGHT;
		
		// we print out the parameters
		System.out.println("LifeValue = " + lifeValue);
	}
	
	private static void updateCell(cell[] gridCurrent, cell[] gridCopy, int i){
		// if the cell is alive, we enter this branch
		if (gridCurrent[i].returnCellStatus()){
			if (aliveNeighbors(gridCurrent, i) < 2 || aliveNeighbors(gridCurrent, i) > 3){
				gridCopy[i].flipStatus();
			}
		}// end of cell status checking statement
		
		// if the cell is not alive, we enter this branch
		else{
			if (aliveNeighbors(gridCurrent, i) == 3){
				gridCopy[i].flipStatus();
			}
		}// end of else statement
		
	}// end of updateCell method
	
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
	}

}// end of grid object

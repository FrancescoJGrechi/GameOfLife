import java.io.*;

public class grid {
	
	///// WE DEFINE OUR CONSTANTS /////
	private static int width;
	private static int height;
	
	///// WE DEFINE OUR NON-CONSTANT PARAMETERS /////
	public cell[][] gridCurrent;
	
	// constructor method
	public grid (boolean[][] seed, int height, int width) throws IOException, NullPointerException {
		
		// we initialize the height and width parameters
		grid.width = width;
		grid.height = height;
		
		// we initialize the cell array 
		gridCurrent = new cell[grid.width][grid.height];
		
		// we cycle through the grid and initialize the cells based on the seed
		for (int i = 0; i < grid.height; ++i)
		{
			for (int j = 0; j < grid.width; ++j){
				gridCurrent[i][j] = new cell(seed[i][j]);	
			}// we cycle through the rows
		}// we cycle through the columns

	}// end of constructor method
	
	// method which updates the grid according to Conway's rules
	public void updateGrid(){
		
		// we create a copy of the current grid
		cell[][] gridCopy = new cell[grid.width][grid.height];
		deepCopy(gridCurrent, gridCopy);
				
		// we cycle through our array, and update each element
		for (int i = 0; i < grid.height; ++i){
			for (int j = 0; j < grid.width; ++j){
				updateCell(gridCurrent, gridCopy, i, j);
			}
		}
		
		// we store this updated array as our current array
		for (int i = 0; i < grid.height; ++i){
			gridCurrent[i] = gridCopy[i].clone();
		}
		
	}// end of updateGrid() method
	
	// method which prints out the current grid, using A for alive and D for dead
	public void printGrid(){
		System.out.println("-------------");
		for (int i = 0; i < grid.height; ++i){
			System.out.print("| ");
			for (int j = 0; j < grid.width; ++j){
				gridCurrent[i][j].printCellStatus();
				System.out.print(" | ");
			}
			if(i < width-1){
				System.out.print("\n");
			}
		}
		System.out.println("\n-------------");
	}// end of printGrid() method	
	
	// static method which updates a particular cell
	private static void updateCell(cell[][] gridCurrent, cell[][] gridCopy, int i, int j){
		int numAliveNeighbors = aliveNeighbors(gridCurrent, i, j, grid.height);
		
		// if the cell is alive, we enter this branch
		if (gridCurrent[i][j].returnCellStatus()){
			if (numAliveNeighbors < 2 || numAliveNeighbors > 3){
				gridCopy[i][j].flipStatus();
			}
		}// end of cell status checking statement
		
		// if the cell is not alive, we enter this branch
		else{
			if (numAliveNeighbors == 3){
				gridCopy[i][j].flipStatus();
			}
		}// end of else statement
		
	}// end of updateCell() method
	
	// static method which returns the number of alive neighbors a given cell has
	private static int aliveNeighbors(cell[][] currentGrid, int i, int j, int height){
		// we define the number alive neighbors
		int numAliveNeighbors = 0;
		
		// we loop through and find which neighbors are alive
		for (int k = -1; k < 2; ++k){
			for (int l = -1; l < 2; ++l){
				if (k != 0 || l != 0){
					if (currentGrid[findCoordinate(i, k)]
							[findCoordinate(j, l)].returnCellStatus()){
						++numAliveNeighbors;
					}
				}
			}// we cycle through columns
		}// we cycle through rows
			
		// we send back the number of alive neighbors
		return numAliveNeighbors;
	}// end of aliveNeighbors method
	
	// static method which makes a deep copy of a grid
	private static void deepCopy(cell[][] currentGrid, cell[][] gridCopy){
		
		for (int i = 0; i < grid.height; ++i){
			for (int j = 0; j < grid.width; ++j){
				gridCopy[i][j] = new cell(currentGrid[i][j].returnCellStatus());
			}// we cycle through the columns
		}// we cycle through the rows
		
	}// end of deepCopy() method
	
	// static method which calculates the wrap-around coordinates of squares on a grid
	private static int findCoordinate(int x, int y){
		// note that for simplicity, since we are using a square grid, we use the width constant
		// to find both the x and y coordinates
		
		if (x + y < 0){
			return (x+y) % grid.width + grid.width;
		}
		else{
			return (x+y) % width;
		}
		
	}// end of findCoordinate() method

}// end of grid object

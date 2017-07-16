public class cell {
	
	// we define the cell's constant parameters
	public static final int NUMNEIGHBORS = 4;
	public static final int WIDTH = 3;
	public static final int HEIGHT = 3;
	
	// we define the cell's non-constant parameters
	private boolean alive;
	public int[] neighborIndices = new int[NUMNEIGHBORS];// we store up, below, left, and right neighbors
	
	// constructor method
	public cell (boolean alive){
		// we initialize all our cells and determine its neighbors
		this.alive = alive;
	}// end of constructor 
	
	public boolean returnCellStatus(){
		return this.alive;
	}// method which returns a given cell's status
	
	public void printCellStatus(){
		if (alive){
			System.out.print("A");
		}
		else{
			System.out.print("D");
		}
	}// method which prints out the current cell's status (alive or dead)
	
	public void flipStatus(){
		// we flip the status of the cell 
		alive = !alive;
	}// end of method to flip a given cell's status
	
	public void findNeighbors(int i){
		// in this function we initialize the values of the neighbors
		if (i < WIDTH){
			neighborIndices[0] = (i - 3) % 9 + 9;
		}
		else{
			neighborIndices[0] = i - 3;
		}
		
		neighborIndices[1] = (i + 3) % 9;
		
		// we find the left neighbor
		if (i % 3 == 0){
			neighborIndices[2] = i + 2;
		}
		else{
			neighborIndices[2] = i - 1;
		}
		
		// we find the right neighbor
		if (i % 3 == 2){
			neighborIndices[3] = i - 2;
		}
		else{
			neighborIndices[3] = i + 1;
		}
		
	}// end of method
	
}// end of class

public class cell{
	
	///// WE DEFINE OUR CONSTANT PARAMETERS /////
	public static final int NUMNEIGHBORS = 4;
	public static final int WIDTH = 3;
	public static final int HEIGHT = 3;
	public final int coordinate;
	
	///// WE DEFINE OUR NON-CONSTANT PARAMETERS /////
	private boolean alive;
	public int[] neighborIndices = new int[NUMNEIGHBORS];
	// we store up, below, left, and right neighbors
	
	// constructor method
	public cell (boolean alive, int i){
		// we initialize all our cells and determine its neighbors
		this.alive = alive;
		this.coordinate = i;
	}// end of constructor 
	
	// method which returns the cell's alive parameter
	public boolean returnCellStatus(){
		return this.alive;
	}// end of returnCellStatus() method
	
	// method which prints a given cell's alive parameter, (A=alive & B=dead)
	public void printCellStatus(){
		if (alive){
			System.out.print("A");
		}
		else{
			System.out.print("D");
		}
	}// end of printCellStatus() method
	
	// method which flips a cell's alive status (i.e. A->D, D->A)
	public void flipStatus(){
		// we flip the status of the cell 
		alive = !alive;
	}// end of flipStatus() method 
	
	// method which a given cell's neighbor's indices
	public void findNeighbors(){
		
		// we find the upper neighbor's coordinates
		if (coordinate < WIDTH){
			neighborIndices[0] = (coordinate - 3) % 9 + 9;
		}
		else{
			neighborIndices[0] = coordinate - 3;
		}
		
		// we find the left lower neighbor's coordinates
		neighborIndices[1] = (coordinate + 3) % 9;
		
		// we find the left neighbor's coordinates
		if (coordinate % 3 == 0){
			neighborIndices[2] = coordinate + 2;
		}
		else{
			neighborIndices[2] = coordinate - 1;
		}
		
		// we find the right neighbor's coordinates
		if (coordinate % 3 == 2){
			neighborIndices[3] = coordinate - 2;
		}
		else{
			neighborIndices[3] = coordinate + 1;
		}
		
	}// end of findNeighbors() method
	
}// end of class

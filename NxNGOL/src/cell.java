public class cell{
	
	///// WE DEFINE OUR NON-CONSTANT PARAMETERS /////
	private boolean alive;
	
	// constructor method
	public cell (boolean alive){
		// we initialize all our cells and determine its neighbors
		this.alive = alive;
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
	
}// end of class

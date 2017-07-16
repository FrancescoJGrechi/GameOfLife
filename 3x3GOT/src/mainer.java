import java.io.*;

// main method in which we make use of the cell grid
public class mainer {
	
	// we define our constant parameters
	public static final int WIDTH = 3;
	public static final int HEIGHT = 3;
	public static final boolean ALIVE = true;
	public static final boolean DEAD = false;
	
	public static void main(String[] args){
		
		// we define our non-constant parameters
		int generations = 6;
		
		// we define how we want to initialize our grid
		boolean[] stati = {
							ALIVE, DEAD, DEAD, 
							ALIVE, ALIVE, DEAD,
							ALIVE, DEAD, ALIVE
						};
		try{
			// we define our grid 
			grid map = new grid(stati);
		
			// we loop through our grid, each time updating 
			for (int i = 0; i < generations; ++i){
				System.out.println("Generation #" + (i+1));
				map.updateGrid();
				map.printGrid();
				map.printStats();
				System.out.println("*************");
				System.out.println("*************");
			} // end of for loop
			
		}// end of try statement
		catch(IOException e){
			System.out.println("IOException when creating the grid!");
			e.printStackTrace();
		}// end of IO catch statement
		catch(NullPointerException e){
			System.out.println("NP exception when creating the grid!");
			e.printStackTrace();
		}// end of NP catch statement
		
		
		
	}// end of main method
	
}// end of main class

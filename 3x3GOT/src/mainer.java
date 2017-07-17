import java.io.*;
// import java.util.Arrays; --> used for neighbor testing

// main method in which we make use of the cell grid
public class mainer {
	
	///// WE DEFINE OUR NON-CONSTANT PARAMETERS /////
	public static final int WIDTH = 3;
	public static final int HEIGHT = 3;
	public static final boolean ALIVE = true;
	public static final boolean DEAD = false;
	
	///// ENTRY POINT /////	
	public static void main(String[] args){
		
		// we define our non-constant parameters
		int generations = 5;
		
		// we define the seed of our game
		boolean[] seed = {
							ALIVE, DEAD, ALIVE, 
							ALIVE, ALIVE, ALIVE,
							ALIVE, DEAD, ALIVE
						};
		
		try{
			// we define our grid 
			grid map = new grid(seed);
			
			// we print out the seed generation
			System.out.println("(Seed) Generation #0:");
			map.printGrid();
			map.printStats();
			System.out.println("*************");
			System.out.println("*************");
			
			/* THIS IS USED TO TEST TO SEE WHAT THE NEIGHBORS ARE
			for (int i = 0; i < WIDTH*HEIGHT; ++i){
				System.out.println(Arrays.toString(map.gridCurrent[i].neighborIndices));
			}
			*/
		
			// we loop through our grid, each time updating 
			for (int i = 0; i < generations; ++i){
				System.out.println("Generation #" + (i+1) + ":");
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

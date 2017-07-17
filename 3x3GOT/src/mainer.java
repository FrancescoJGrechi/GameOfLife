import java.io.IOException;
import java.util.Random;

// main method in which we make use of the cell grid
public class mainer {
	
	///// WE DEFINE OUR NON-CONSTANT PARAMETERS /////
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	///// ENTRY POINT /////	
	public static void main(String[] args){
		
		// we define our non-constant parameters
		final int generations = 30;
		Random randomizer = new Random();
		
		// we define the seed of our game
		boolean[][] seed = new boolean[HEIGHT][WIDTH];
		for (int i = 0; i < HEIGHT; ++i){
			for(int j = 0; j < WIDTH; ++j){
				seed[i][j] = randomizer.nextBoolean();
			}
		}
		
		try{
			// we define our grid 
			grid map = new grid(seed, HEIGHT, WIDTH);
			
			// we print out the seed generation
			System.out.println("(Seed) Generation #0:");
			mapPrint(map);
					
			// we loop through our grid, each time updating 
			for (int i = 0; i < generations; ++i){
				System.out.println("Generation #" + (i+1) + ":");
				map.updateGrid();
				mapPrint(map);
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
	
	// method which prints out the current map
	private static void mapPrint(grid map){
		map.printGrid();
		System.out.println("*************");
		System.out.println("*************");
	}// end of mapPrint() method
	
}// end of main class

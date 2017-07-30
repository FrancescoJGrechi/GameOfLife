#we import the necessary modules for the project
import grid as grid
import numpy as np
import random

#main method
def main():
    
    #we define our non-constant parameters
    generations = 20
    width = 5
    height = 5

    #we randomize the seed of the game
    seed = np.empty([width, height], dtype=bool)
    for i in range(width):
        for j in range(height):
            seed[i][j] = random.choice([True, False])

    #we define our grid
    gridMap = grid.grid(seed, height, width)

    #we print out the seed generation
    print("(Seed) Generation #0:")
    gridMap.printGrid()
    print("*************")
    print("*************")

    #we loop through our grid, each time updating
    for i in range(generations):
        print("Generation #", (i+1), ":")
        gridMap.updateGrid()
        gridMap.printGrid()
        print("*************")
        print("*************")
        

if __name__ == "__main__":
   main()


        
            

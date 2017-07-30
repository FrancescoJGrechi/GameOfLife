#we import the cell class previously created
import cell as cell
import numpy as np
import copy as copy

class grid:

    #constructor method, initializes based upon boolean seed array
    def __init__(self, seed, height, width):
                
        #initialize the width and height parameters
        self.height = height
        self.width = width

        #we define the grid to be a 2D numpy array of object
        self.gridCurrent = [[cell.cell(seed[i][j]) for i in range(self.width)] for j in range(self.height)]

        #we initialize the array based upon the seed
        for i in range(self.height):
            for j in range(self.width):
                self.gridCurrent[i][j] = cell.cell(seed[i][j])


    #method which returns the number of alive neighbors a given cell has
    def aliveNeighbors(self, i, j):
        #we define the number of alive neighbors
        numAliveNeighbors = 0

        #we loop through and find which neighbors are alive
        for k in range (-1,2):
            for l in range (-1,2):
                if (k != 0 or l != 0):
                    if (self.gridCurrent[(i+k)%self.height][(j+l)%self.width].returnCellStatus()):
                        numAliveNeighbors += 1

        #we return the number of alive neighbors 
        return numAliveNeighbors
    

        #method which updates the Grid based upon Conway's rules
    def updateGrid(self):
        #we create a copy of the current grid
        gridCopy = copy.deepcopy(self.gridCurrent)

        #we cycle through our array and update each element
        for i in range(self.height):
            for j in range(self.width):
                self.updateCell(gridCopy,i,j)

        #we cycle through and store this as our current array
        self.gridCurrent = copy.deepcopy(gridCopy)
    

    #method which updates a particular cell 
    def updateCell(self, gridCopy, i, j):
        #we find the number of alive neighbors via a static method
        numAliveNeighbors = self.aliveNeighbors(i, j)

        #if the cell is alive, we enter this branch
        if self.gridCurrent[i][j].returnCellStatus():
            if (numAliveNeighbors < 2 or numAliveNeighbors > 3):
                gridCopy[i][j].flipStatus()
                
        #if the cell is dead, we enter this branch
        else:
            if numAliveNeighbors == 3:
                gridCopy[i][j].flipStatus()
                

    #method which prints out the current grid, using A for alive and D for dead
    def printGrid(self):
        print("-------------")
        for i in range(self.height):
            print("| ", end='')
            for j in range (self.width):
                self.gridCurrent[i][j].printCellStatus()
                print(" | ", end='')
            if i < (self.width - 1):
                print("\n")
        print("\n")


            
    


        

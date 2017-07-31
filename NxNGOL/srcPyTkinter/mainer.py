#we import the necessary modules for the project
import grid as grid
import numpy as np
import random
import tkinter as tk

#we create our Tk object
root = tk.Tk()
root.title("Game of life")

#we create our frame and canvas
framePixelWidth = 720
framePixelHeight = 720
frame = tk.Frame(root, width=framePixelWidth, height=framePixelHeight)
frame.pack()
canvas = tk.Canvas(frame, width=framePixelWidth, height=framePixelHeight)
canvas.pack()

#we define the width and height in pixels of each cell & work out the number of cells in each direction
cellPixelWidth = 10
cellPixelHeight = 10
numberOfCells_x = int(framePixelWidth/cellPixelWidth)
numberOfCells_y = int(framePixelHeight/cellPixelHeight)

# we define our list of rectangles
rectangles = []

#we randomize the seed of the game
seed = []
for i in range(numberOfCells_y):
    seed.append([])
    for j in range(numberOfCells_x):
        seed[i].append(random.choice([True, False]))

#we define & initialize our grid
gridMap = grid.grid(seed, numberOfCells_y, numberOfCells_x)

#we define this method to change the grid coloring based upon
def gameStart():
    for i in range(numberOfCells_y):
        for j in range(numberOfCells_x):
            #white = dead, black = alive
            if gridMap.gridCurrent[i][j].alive:
                canvas.itemconfig(rectangles[i][j], fill="black")
            else:
                canvas.itemconfig(rectangles[i][j], fill="white")
                
    #we update the grid for the next call of gameStart
    gridMap.updateGrid()

    #we recall the gameStart method
    global restarter
    restarter = root.after(100, gameStart)


#method which quits our root TK object
def gameEnd():
    root.after_cancel(restarter)
    root.quit()
    

#main method
def main():

    #we fill the rectangle list to contain the rectangle objects
    for i in range(numberOfCells_y):
        
        #we add a new row to the rectangles list
        rectangles.append([])

        for j in range(numberOfCells_x):
            #we create the rectangle, initialize it & place it on the canvas
            rectangle = canvas.create_rectangle(j*cellPixelWidth, i*cellPixelHeight, 
                (j+1)*cellPixelWidth, (i+1)*cellPixelHeight, fill="white")
            rectangles[i].append(rectangle)


    #we use the following buttons to receive input for the beginning and ending
    #of the game
    start = tk.Button(root, text="Begin Game", command=gameStart)
    start.pack(side = tk.LEFT)
    stop = tk.Button(root, text="Terminate Game", command=gameEnd)
    stop.pack(side = tk.RIGHT)

    root.mainloop()


if __name__ == "__main__":
   main()


        
            

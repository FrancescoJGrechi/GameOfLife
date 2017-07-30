class cell:
 
    #constructor method for the obejct 
    def __init__(self, alive=False):
        self.alive = alive

    #method which returns the cell's alive parameter --> Is this nec. if not private variables?
    def returnCellStatus(self):
        return self.alive

    #method which prints a given cell's __alive parameter
    def printCellStatus(self):
        if self.alive:
            print("A", end='')
        else:
            print("D", end='')

    #method which flips a cell's alive parameter (i.e. A->D, D->A)
    def flipStatus(self):
        self.alive = not (self.alive)

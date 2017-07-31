class cell:
 
    #constructor method for the obejct 
    def __init__(self, alive=False):
        self.alive = alive

    #method which flips a cell's alive parameter (i.e. A->D, D->A)
    def flipStatus(self):
        self.alive = not (self.alive)

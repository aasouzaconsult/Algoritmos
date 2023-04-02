##################################
### Title: Shortest Path  ########
### Author: GuoChen Hou   ########
##################################

# Task statement at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab5/ex1_ShortestPath/ShortestPath.pdf
# Test inputs at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab5/ex1_ShortestPath/input/
# Test outputs at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab5/ex1_ShortestPath/output/
import StackADT

class Path:
	def __init__(self, maze):
		self.maze = maze
		self.path = StackADT.Stack()

	def path_finder(self, coord):
		x = coord[0]
		y = coord[1]

		# add step to path if path is empty
		if self.path.size() == 0:
			self.path.push(coord)
			self.maze[x][y] = 2

		# base case: reach maze's exit
		if x == 0 or x == len(self.maze)-1 or y == len(self.maze)-1:
			self.path.push(coord)
			self.maze[x][y] = 2
			return self.path
		elif self.maze[x][y] == 0:
			self.path.push(coord)
			self.maze[x][y] = 2
		
		# case 1: move UP
		if self.maze[x-1][y] == 0:
			new_coord = [x-1, y]
		# case 2: move RIGHT
		elif self.maze[x][y+1] == 0:
			new_coord = [x, y+1]
		# case 3: move DOWN
		elif self.maze[x+1][y] == 0:
			new_coord = [x+1, y]
		# case 4: move LEFT
		elif self.maze[x][y-1] == 0:
			new_coord = [x, y-1]
		return self.path_finder(new_coord)

	def print_maze(self):
		for row in range(len(self.maze)):
			print self.maze[row]
		return None
	def print_path(self):
		steps = []
		for index in range(self.path.size()):
			steps.append(self.path.pop())
			print steps
		for step in reversed(steps):
			print step
		return None

maze = []
#cmd line inputs
#size = int(raw_input())
#for i in range(size):
#	grids = map(int, raw_input().split())
#	maze.append(grids)
# test inputs
#maze = [[1, 1, 1, 0, 1, 1, 1, 1, 1, 1],
#		[0, 0, 1, 0, 1, 1, 1, 1, 1, 1],
#		[1, 0, 1, 0, 0, 1, 1, 1, 1, 1], 
#		[1, 0, 1, 1, 0, 1, 1, 1, 1, 1], 
#		[1, 0, 0, 0, 0, 1, 1, 1, 1, 1], 
#		[1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 
#		[1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 
#		[1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 
#		[1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 
#		[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]
#maze = [[1, 1, 1, 0, 1, 1, 1, 1, 1, 1], 
#		[0, 0, 1, 0, 1, 1, 1, 1, 1, 1], 
#		[1, 0, 1, 0, 0, 1, 1, 1, 1, 1], 
#		[1, 0, 1, 1, 0, 1, 1, 1, 1, 1], 
#		[1, 0, 0, 0, 0, 0, 0, 1, 1, 1], 
#		[1, 0, 1, 1, 1, 1, 0, 1, 0, 0], 
#		[1, 0, 1, 1, 1, 1, 0, 0, 0, 1], 
#		[1, 0, 1, 1, 1, 1, 1, 1, 1, 1], 
#		[1, 0, 0, 0, 0, 0, 0, 0, 0, 0], 
#		[1, 1, 1, 1, 1, 1, 0, 1, 1, 1]]
f = open('maze.txt')
for line in f:
	line = line.split(' ')
	line.pop()
	line = map(int, line)
	maze.append(line)
path = Path(maze)
start = [1,0]
path.path_finder(start)
path.print_maze()
path.print_path()
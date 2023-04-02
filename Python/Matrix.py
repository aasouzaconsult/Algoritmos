##################################
### Title: Matrix         ########
### Author: GuoChen Hou   ########
##################################

# Given a square matrix, output the final state of the matrix after performing the given operations. 
# There are 3 valid operations:
# 1. Rotate r: Rotate the matrix clockwise by r degree (r can be 90, 180, or 270). 
# 2. Reflect x: Reflect the matrix across the x-axis. 
# 3. Reflect y: Reflect the matrix across the y-axis. 
# The first line of the input contains an integer N (1 <= N <= 100). The subsequent N lines contain the 
# values of the N x N elements. The following line is an integer K (1 <= K <= 100), where K is the 
# number of operations to be performed. The next line is the query with format "Rotate r", (r = {90, 
# 180, 270}), "Reflect x" or "Reflect y". 

import copy

class Matrix:
	"""
	Matrix class instantiates a 2-dimensional matrix and performs adjustment operations on the
	matrix.
	"""
	def __init__(self, new_size):
		self.size = new_size
		self.matrix = [[None for i in range(self.size)] for j in range(self.size)]

	def __rotate(self, degree):
		"Rotate the matrix by degree"		
		while degree != 0: 
			temp = copy.deepcopy(self.matrix)
			for row in range(self.size):
				for col in range(self.size):
					self.matrix[row][col] = temp[self.lastIndex(temp) - col][row]
			degree -= 90
		return self.matrix 

	def __reflectX(self):
		"Reflect the matrix around x-axis"
		temp = copy.deepcopy(self.matrix)
		for row in range(self.size):
			for col in range(self.size):
				self.matrix[row][col] = temp[self.lastIndex(temp) - row][col]
		return self.matrix

	def __reflectY(self):
		"Reflect the matrix around y-axis"
		temp = copy.deepcopy(self.matrix)
		for row in range(self.size):
			for col in range(self.size):
				self.matrix[row][col] = temp[row][self.lastIndex(temp)-col]
		return self.matrix

	def operate(self, operation, pivot):
		"Perform operation on the matrix with type specification"
		if operation == "rotate":
			pivot = int(pivot)
			self.__rotate(pivot)
		elif operation == "reflect":
			if pivot == "x": # reflect ard x-axis
				self.__reflectX()
			elif pivot == "y": # reflect ard y-axis
				self.__reflectY()
		return self.matrix

	def toString(self):
		"Convert the matrix into string"
		output = ""
		for i in range(self.size):
			for j in range(self.size):
				if j < 0:
					output += " "
				output += self.matrix[i][j]
				output += " "
			output += "\n"
		return output

	def lastIndex(self, list_2d):
		"Returns the last index of a list"
		return len(list_2d) - 1

size = int(raw_input())
matrix = Matrix(size)

for index in range(size):
	matrix.matrix[index] = raw_input().split(' ')

operations = int(raw_input())
for index in range(operations):
	operation, pivot = raw_input().split()
	try:
		int(pivot)
	except ValueError:
		pass
	matrix.operate(operation, pivot)
print matrix.toString()
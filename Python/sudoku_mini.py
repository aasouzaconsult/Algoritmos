##################################
### Title: Mini Sudoku    ########
### Author: GuoChen Hou   ########
##################################

# This program solves a mini-Sudoku puzzle on a 4X4 board. The board consists of digits 
# from 0 to 4 where 0 represents a blank cell. The solver needs to replace all the 0s with 
# the correct values (1 - 4).

# We are using a very simple algorithm to solve a 4 by 4 sudoku game where the puzzles are 
# such that at any time, there is at most one blank cell(0) in a certain row, column or 2X2
# section.
# Algorithm:
# Repeat the following until no more blank cells can be filled:
# For each row, check whether there is a single 0. If so, replace that 0 with the obvious value. 
# For each column, check whether there is a single 0. If so, replace that 0 with the obvious value. 
# For each 2X2 section, check whether there is a single 0. If so, replace that 0 with the 
# obvious value.

import sys
import math

GAME_SEQUENCE = [1,2,3,4]

def solve(list_2d):
	while anotherRound(list_2d):
		# For each row, check whether there is a single 0. 
		# If so, replace that 0 with the obvious value. 
		for index_row in range(len(list_2d)):
			sequence = GAME_SEQUENCE[:]
			number_of_zero = 0
			for index_col in range(len(list_2d)):
				if list_2d[index_row][index_col] == 0:
					zero_index_row = index_row
					zero_index_col = index_col
					number_of_zero += 1
				else:
					sequence_index = sequence.index(list_2d[index_row][index_col])
					sequence.pop(sequence_index)
			if number_of_zero == 1:
				list_2d[zero_index_row][zero_index_col] = sequence.pop()
		
		# For each column, check whether there is a single 0.
		# If so, replace that 0 with the obvious value		
		for index_col in range(len(list_2d)):
			sequence = GAME_SEQUENCE[:]
			number_of_zero = 0
			for index_row in range(len(list_2d)):
				if list_2d[index_row][index_col] == 0:
					zero_index_row = index_row
					zero_index_col = index_col
					number_of_zero += 1
				else:
					sequence_index = sequence.index(list_2d[index_row][index_col])
					sequence.pop(sequence_index)
			if number_of_zero == 1:
				list_2d[zero_index_row][zero_index_col] = sequence.pop()
		
		# For each 2X2 section, check whether there is a single 0. 
		# If so, replace that 0 with the obvious value
		# Section 0
		compute_section(list_2d, 0)
		
		# Section 1
		compute_section(list_2d, 1)

		#Section 2
		compute_section(list_2d, 2)

		#Section 3
		compute_section(list_2d, 3)

	return list_2d

def compute_section(list_2d, section_number):
	if section_number == 0:
		max_row_range = int(math.ceil(float(len(list_2d)/2)))
		max_col_range = int(math.ceil(float(len(list_2d)/2)))
		max_row = 1
		max_col = 1
	elif section_number == 1:
		max_row_range = int(math.ceil(float(len(list_2d)/2)))
		max_col_range = len(list_2d)
		max_row = 1
		max_col = 3
	elif section_number == 2:
		max_row_range = len(list_2d)
		max_col_range = int(math.ceil(float(len(list_2d)/2)))
		max_row = 3
		max_col = 1
	elif section_number == 3:
		max_row_range = len(list_2d)
		max_col_range = len(list_2d)
		max_row = 3
		max_col = 3

	sequence = GAME_SEQUENCE[:]
	number_of_zero = 0
	for index_row in range(max_row_range): # -1 offset to get the largest index of the first half of list
		for index_col in range(max_col_range):
			if section_number == 1:
				if index_col <= 1:
					continue
			elif section_number == 2:
				if index_row <= 1:
					continue
			elif section_number == 3:
				if index_row <= 1 or index_col <= 1:
					continue
			else:
				if list_2d[index_row][index_col] == 0:
					zero_index_row = index_row
					zero_index_col = index_col
					number_of_zero += 1
				else:
					sequence_index = sequence.index(list_2d[index_row][index_col])
					sequence.pop(sequence_index)
		if index_row == max_row and index_col == max_col:
			if number_of_zero == 1:
				list_2d[zero_index_row][zero_index_col] = sequence.pop()
	return list_2d

def anotherRound(list_2d):
	another = False
	for index_row in range(len(list_2d)):
			for index_col in range(len(list_2d)):
				if list_2d[index_row][index_col] == 0:
					another = True
					break
			if another:
				break
	return another

def printBoard(list_2d):
	for index_row in range(len(list_2d)):
		for index_col in range(len(list_2d)):
			sys.stdout.write('%d ' % list_2d[index_row][index_col])
		sys.stdout.write('\n')


board = [[0 for index in xrange(4)] for index in range(4)]
line = 0

print 'Enter board (0 for blank cell):'
while line < 4:
	input_list = list(raw_input().split())
	for index in range(len(input_list)):
		input_list[index] = int(input_list[index])
	board.append(input_list)
	board.pop(0) # remove initalizer
	line += 1
#board = [[1,0,3,0],[3,0,0,2],[4,3,2,1],[0,0,0,3]]
#board = [[0,1,3,2],[2,0,1,0],[1,0,0,3],[3,4,2,1]]
#board = [[4,1,2,0],[3,2,1,0],[1,3,4,0],[0,0,0,0]]
#board = [[0,3,4,0],[4,0,1,0],[0,4,0,1],[0,1,2,0]]
solve(board)
print 'Sudoku puzzle solved:'
printBoard(board)
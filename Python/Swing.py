##################################
### Title: Swinging Monkey #######
### Author: GuoChen Hou   ########
##################################

# Task statement at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab4/ex1_SwingMonkey/SwingingMonkeys.pdf
import StackADT

class Result:
	def __init__(self):
		self.stack = StackADT.Stack()
		self.num_pairs = 0

	def solve(self, tree_list):
		"""Solve and return the number of swings using a stack ADT"""
		for i in range(len(tree_list)):
			tree = tree_list[i]
			if self.stack.is_empty(): # if stack is empty, just push input
				self.stack.push(tree)
			else:
				# do a while loop to pop all possible top stack element until
				# the top element is bigger than the input or the stack is emptied
				while not self.stack.is_empty() and tree > self.stack.peek():
					self.stack.pop()
					self.num_pairs += 1

				# if stack is empty after exiting the while loop
				# push the current element onto the stack
				if self.stack.is_empty():
					self.stack.push(tree)
				# this condition applifes for two cases:
				# 1. the while loop is never entered because the tree is smaller than the topmost element
				# 2. the while loop exited and the input is pushed onto the non-empty stack with num_pairs incremented
				elif not self.stack.is_empty() and tree < self.stack.peek():
					self.stack.push(tree)
					self.num_pairs += 1
				elif tree == self.stack.peek(): # input is never pushed if the input is identical to topmost element
					self.num_pairs += 1
		return self.num_pairs

# use this for manual input testing
tree_count = int(raw_input())
trees = map(int, raw_input().split())

# use this if input data is in a file with 1 data on each line
# trees = []
# f = open('swing_data.txt')
#for line in f:
#	line = int(line)
#	trees.append(line)

result = Result()
print result.solve(trees)
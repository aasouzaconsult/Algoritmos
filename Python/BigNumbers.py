##################################
### Title: Big Numbers    ########
### Author: GuoChen Hou   ########
##################################

# Task statement at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab3/ex2_BigNumbers/BigNumbers.pdf
class Digit:
	def __init__(self, digit=None, next=None):
		self.digit = digit
		self.next = next

	# Accessors
	def get_digit(self):
		return self.digit

	def get_next(self):
		return self.next

	def set_digit(self, digit):
		self.digit = digit
		return None

	def set_next(self, next):
		self.next = next
		return None


class BigNumber:
	def __init__(self):
		self.head = None
		self.len = 0

	# Accessors
	def get_head(self):
		return self.head

	def get_len(self):
		return self.len

	def add(self, digit):
		"""Append a digit to the linked list"""
		if self.head == None:
			self.head = Digit(digit)
			self.len += 1
		else:
			current_node = self.head
			while current_node.get_next() != None:
				current_node = current_node.get_next()
			new_node = Digit(digit)
			current_node.next = new_node
			self.len += 1
		return None

	def sum(self, digit_1, digit_2):
		"""Sum two big numbers and return its sum"""
		current_node = self.head
		while current_node.get_next() != None:
			if current_node.get_digit() == digit_1:
				next_node = current_node.get_next()
				if next_node.get_digit() == digit_2:
					return digit_1 + digit_2
			current_node = current_node.get_next()
		return 0 


operations = int(raw_input())
digit_list = BigNumber()
while operations != 0:
	first, second = raw_input().split()
	first = int(first)
	second = int(second)
	digit_list.add(first)
	digit_list.add(second)
	print digit_list.sum(first, second)
	operations -= 1
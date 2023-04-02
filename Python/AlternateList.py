import math

class AlternateList:
	def __init__(self, a_list=None):
		self.int_list = a_list

	def move(self, index, size):
		"""Move a block of elements of length 'size' starting at 'index' to the back of the list"""
		index -= 1
		new_list = []
		for i in range(size):
			new_list.append(self.int_list[index])
			del self.int_list[index]
		self.int_list.extend(new_list)
		return None

	def remove(self, index, size):
		"""Remove a block of elements of length 'size' starting at 'index' from the list"""
		index -= 1
		for i in range(size):
			del self.int_list[index]
		return None

	def add(self, index, size, value):
		"""Add the element between 'index' and 'index+size-1' with 'value'"""
		index -= 1
		print index
		print size
		while size != 0:
			self.int_list[index] += value
			index += 1
			size -= 1
		return None

	def is_alt_list(self):
		"""Check if the list has alternating elements on signs"""
		is_alt = False
		if len(self.int_list) <= 1:
			is_alt = True
		else:
			for index in range(len(self.int_list)):
				if index == 0:
					temp_sign = math.copysign(1, self.int_list[index])
					continue
				new_sign = math.copysign(1, self.int_list[index])
				if temp_sign != new_sign:
					temp_sign = new_sign
					is_alt = True
					continue
				else:
					is_alt = False
					break
		return is_alt
	
	def get_list(self):
		return self.int_list

updates = int(raw_input())

int_list = []
for digit in raw_input().split():
	digit = int(digit)
	int_list.append(digit)

alt_list = AlternateList(int_list)
for i in range(updates):
	line = raw_input().split(' ',1)
	op = line[0]
	line = line[1]
	if op == "M":
		index, size = line.split()
		index = int(index)
		size = int(size)
		alt_list.move(index, size)
	elif op == "A":
		index, size, value = line.split()
		index = int(index)
		size = int(size)
		value = int(value)
		alt_list.add(index, size, value)
	elif op == "R":
		index, size = line.split()
		index = int(index)
		size = int(size)
		alt_list.remove(index, size)

	if alt_list.is_alt_list():
		print "YES"
	else:
		print "NO"

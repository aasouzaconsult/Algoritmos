##################################
### Title: Priority Queue ########
### Author: GuoChen Hou   ########
##################################

# Implementing a priority queue with python list

class PriorityQueue:
	"""
	PriorityQueue class implements a priority queue using list structure
	"""

	def __init__(self):
		self.list = []

	def insert(self, priority):
		self.list.append(priority)
		return

	def delete_top_priority(self):
		temp = self.list[0]
		for priority in self.list:
			if temp < priority:
				temp = priority
		self.list.remove(temp)		

	def print_queue(self):
		print self.list

if __name__ == "__main__":
	q1 = PriorityQueue()
	q1.insert(57)
	q1.insert(32)
	q1.insert(100)
	q1.insert(56)
	q1.insert(44)
	q1.print_queue()
	q1.delete_top_priority()
	q1.print_queue()
	q1.delete_top_priority()
	q1.print_queue()
	q1.insert(37)
	q1.print_queue()
	q1.delete_top_priority()
	q1.print_queue()
##################################
### Title: QuickEat       ########
### Author: GuoChen Hou   ########
##################################

# Task statement at http://www.comp.nus.edu.sg/~cs1020/labs/12s2/lab4/ex2_QuickEat/QuickEat.pdf
from collections import deque

class ListOrder:
	def __init__(self):
		self.dish = deque()

	def add_order(self, tag):
		"""add new order to the list"""
		self.dish.append(tag)
		return None

	def process_food(self):
		"""process food when it is ready and return the customer tag removed"""
		tag = self.dish.popleft()
		return tag

	def show_queue(self):
		"""display the current queue status on the dish"""
		print self.dish
		return None

	def queue_size(self):
		return len(self.dish)

num_dish = int(raw_input())
dishes = [] # dish index
menu = [] # name of each dish according to index
for i in range(num_dish):
	dish = ListOrder()
	dishes.append(dish)
	menu.append(raw_input())

cmd = int(raw_input())
for i in range(cmd):
	line = raw_input().split(' ', 1)
	if line[0] == 'order': # order command
		data = line[1].split()
		# data[0] = customer tag no
		# data[1] = dishes ordered
		tag = int(data[0])
		dish_count = int(data[1])
		orders = []
		# put ordered dish number in a list
		for i in range(2, len(data)):
			index = int(data[i])-1 # 1 offset since orders start from 0
			orders.append(index)
			dishes[index].add_order(tag)

	elif line[0] == 'ready': # ready command
		serve_dish = int(line[1])-1 # 1 offset since orders start from 0
		if dishes[serve_dish].queue_size() == 0:
			print "Throw away %s." % menu[serve_dish]
		else:
			tag = dishes[serve_dish].process_food() 
			print "%s ready to be served to Tag %d." % (menu[serve_dish], tag)
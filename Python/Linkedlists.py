class Node:
	def __init__(self, data=None, next=None):
		"""Construct a new linked List Node"""
		self.data = data
		self.next = next

class LinkedList:
	def __init__(self):
		"""Construct a new LinkedList. The first node and last node are the same. Size is 0"""
		self.firstnode = Node()
		self.lastnode = self.firstnode
		self.size = 0

	def add(self, data):
		"""Add a node to the list"""
		node = Node(data, None)
		node.data = data

		if self.firstnode.data == None:
			self.firstnode = node
			self.lastnode = node
		else:
			self.lastnode.next = node
			self.lastnode = node
		self.size += 1

	def add_many(self, list_of_data):
		"""Add a list of nodes to the linked list"""
		for data in list_of_data:
			self.add(data)

	def remove(self, data):
		"""Remove a node from the list"""
		current_node = self.firstnode
		was_deleted = False

		if self.size == 0:
			pass

		# The first node is being removed
		if data == current_node.data:
			# Case where we have only one node in the list
			if current_node.next == None:
				self.firstnode = Node()
				self.lastnode = self.firstnode
				self.size -= 1
				return None
			# Here there are more than one node in the list
			current_node = current_node.next
			self.firstnode = current_node
			self.size -= 1
			return None

		while True:
			if current_node == None:
				was_deleted = False
				break

			# Check if the data of the next is what we're looking for
			next_node = current_node.next
			if next_node != None:
				if data == next_node.data:
					#Found the right one, loop around the node
					next_next_node = next_node.next
					current_node.next = next_next_node

					next_node = None
					was_deleted = True
					break
			current_node = current_node.next

		if was_deleted:
			self.size -= 1

	def remove_many(self, list_of_data):
		"""Remove a list of nodes form a linked list"""
		for data in list_of_data:
			self.remove(data)

	def to_string(self):
		"""Get a string representation of the list"""
		result = ""
		current_node = self.firstnode
		i = 0

		result += "{"
		while current_node != None:
			if i > 0:
				result += ","
			data = current_node.data
			if data != None:
				result += data
			current_node = current_node.next
			i += 1
		result += "}"
		return result

	def contains(self, data):
		"""Check whether a node is in the list or not"""
		current_node = self.firstnode

		while current_node != None:
			if current_node.data == data:
				return True
			else:
				current_node = current_node.next
		return False

	def index_of(self, data):
		"""Find the position of a node in the list"""
		current_node = self.firstnode
		pos = 0

		while current_node != None:
			if current_node.data == data:
				return pos
			else:
				current_node = current_node.next
				pos += 1
		return None

	def get_size(self):
		"""Get the size of the list"""
		return self.size

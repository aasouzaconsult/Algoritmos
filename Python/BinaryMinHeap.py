class BinaryMinHeap:
	"""
	BinaryMinHeap class implements binary minheap data structure represented using an array
	"""

	def __init__(self):
		self.heap = []

	def smallest(self):
		"""
		Return the smallest value in the heap
		"""
		return self.heap[0]

	def insert(self, value):
		"""
		Insert value into the minheap structure and return the list
		"""
		self.heap.append(value)
		if len(self.heap) == 1:
			return self.heap
		value_index = len(self.heap) - 1

		if value_index % 2 == 0: # value added as a right child
			parent_index = (value_index - 1) / 2			
		else: # value added as a left child
			parent_index = value_index / 2

		while value_index > 0 and value < self.heap[parent_index]:	
			self.heap[value_index] = self.heap[parent_index]
			if value_index % 2 == 0:
				value_index = (value_index - 1) / 2
				parent_index = (value_index - 1) / 2
			else:
				value_index = value_index / 2
				parent_index = value_index / 2			
		self.heap[value_index] = value
		return self.heap

	def delete(self):
		"""
		Deletes the root(item with the smallest value) from heap.
		Return the deleted value.
		"""
		value = self.heap[0]
		self.heap[0] = self.heap[-1] # move last element to first position
		self.heap.pop() # remove last element
		self.sift_down(self.heap, 0, len(self.heap))
		return value

	def sift_down(self, a_list, pos, list_size):
		"""
		Heapify a binary minheap tree indexed from 0 to len(a_list)
		The left and right subtrees of node at index post are heaps. After functioned is executed, the subtree rooted
		at pos is a heap.
		Worse case time is O(lg h). where h is the height of the binary minheap tree.
		"""
		max_index = list_size - 1 # 0 index offset
		temp = a_list[pos]
		while (2*pos+1) <= max_index: # while there is a left node in heap structure
			child_index = 2 * pos + 1
			if child_index < max_index and a_list[child_index+1] < a_list[child_index]:
				child_index += 1 # child_index is now the smaller contained value of the 2 subtrees

			if a_list[child_index] < temp:
				a_list[pos] = a_list[child_index]
			else:
				break # heap structure is maintained
			pos = child_index
		a_list[pos] = temp
		return a_list

	def print_heap(self):
		print self.heap

if __name__ == "__main__":
	test_heap = BinaryMinHeap()
	test_heap.insert(100)
	test_heap.insert(25)
	test_heap.insert(19)
	test_heap.insert(17)
	test_heap.insert(36)
	test_heap.insert(7)
	test_heap.insert(3)
	test_heap.insert(1)
	test_heap.insert(2)
	test_heap.print_heap()
	test_heap.delete()
	test_heap.print_heap()
	test_heap.delete()
	test_heap.print_heap()
	test_heap.delete()
	test_heap.print_heap()

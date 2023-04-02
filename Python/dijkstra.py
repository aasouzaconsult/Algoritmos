import copy 

class Node:
	"""
	Node class defines the basic structure of a node.
	"""
	def __init__(self, vertex=None, weight=None, next=None):
		self.vertex = vertex
		self.weight = weight
		self.next = next

class LinkedList:
	"""
	LinkedList of nodes representing the vertices adjacent to vertex i. Each node has members ver, the vertex adjacent to i; weight, representing the weight of edge (i, ver); 
	and next, a reference to the next node in the linked list or null, for the last node in the linked list.
	"""
	def __init__(self):
		self.head = Node()

	def get_head(self):
		"""
		Returns a reference to the head node
		"""
		return self.head

	def add(self, vertex, weight):
		"""
		Append a new node with node.vertex as vertex to the last element in the linked list
		"""
		new_node = Node(vertex, weight)
		trav = self.head
		while(trav.next != None):
			trav = trav.next
		trav.next = new_node

	def print_list(self):
		trav = self.head.next
		while trav != None:
			print "(%d, %d)" % (trav.vertex, trav.weight),
			trav = trav.next

class Edges:
	"""
	Edges class implements a binary minheap data structure represented using an array.
	"""
	heap = []
	def __init__(self, adj_ref, start):
		path = []
		trav = adj_ref[start].next
		while trav != None:
			path = [start]
			path.append(trav.vertex)
			if len(self.heap) == 0:				
				self.heap.append([trav.vertex, trav.weight, path])
			else:
				self.add_row(adj_ref, trav.vertex, path)
			trav = trav.next

	def get_edges(self):
		"""
		Return heap structure, represented in list structure.
		"""
		return self.heap

	def smallest(self):
		"""
		Return the smallest edge reference in the heap
		"""
		return self.heap[0]

	def add_row(self, adj_ref, end_vertex, path_list):
		"""
		Add a new element to heap list.
		Return the heap structure
		"""
		total_wt = total_weight(adj_ref, end_vertex, path_list)
		self.heap.append([end_vertex, total_wt, path_list])
		if len(self.heap) == 1:
			return self.heap
		value_index = len(self.heap) - 1

		if value_index % 2 == 0: # value added as a right child
			parent_index = (value_index - 1) / 2
		else: #value added as a left child
			parent_index = value_index / 2

		while value_index > 0 and total_wt < self.heap[parent_index][1]:
			self.heap[value_index] = self.heap[parent_index]
			if value_index % 2 == 0:
				value_index = (value_index - 1) / 2
				parent_index = (value_index - 1) / 2
			else:
				value_index = value_index / 2
				parent_index = value_index / 2
		self.heap[value_index] = [end_vertex, total_wt, path_list]
		return self.heap

	def pop_row(self):
		"""
		Delete the smallest weight element in heap list.
		Return the element.
		"""
		if len(self.heap) > 0:
			least = self.heap[0]
			self.heap[0] = self.heap[-1]
			self.heap.pop() # remove last element
			self.sift_down()
			return least
		else:
			return None

	def is_in(self, vertex):
		"""
		Return true if vertex is in table and false otherwise		
		"""
		for item in self.heap:
			if item[0] == vertex:
				return True
		return None

	def vertex_weight(self, vertex):
		"""
		Return the weight corresponding to vertex
		"""
		for item in self.heap:
			if item[0] == vertex:
				return item[1]
		return None

	def update_row(self, adj_ref, end_vertex, path_list):
		"""
		Changes the weight and parent_vertex corresponding to existing vertex
		"""
		total_wt = total_weight(adj_ref, end_vertex, path_list)
		for item in self.heap:
			if item[0] == end_vertex:
				item[1] = total_wt
				item[2] = path_list

	def sift_down(self):
		"""
		Heapify a binary minheap tree indexed from 0 to len(a_list)
		The left and right subtrees of node at index post are heaps. After functioned is executed, the subtree rooted
		at pos is a heap.
		Worse case time is O(lg h). where h is the height of the binary minheap tree.
		"""
		max_index = len(self.heap) - 1 # 0 index offset
		edge = self.heap[0]
		temp = self.heap[0][1]
		pos = 0
		while (pos * 2 + 1) <= max_index:
			child_index = pos * 2 + 1
			if child_index < max_index and self.heap[child_index+1] < self.heap[child_index]:
				child_index += 1 # child_index is now the smaller contained value of the 2 subreees
			if self.heap[child_index][1] < temp:
				self.heap[pos] = self.heap[child_index]
			else:
				break # heap structure is maintained
			pos = child_index
		self.heap[pos] = edge

	def print_heap(self):
		"""
		Print heap
		"""
		print self.heap

def total_weight(adj_ref, end_vertex, path_list):
	"""
	Computes the total weight given a path_list of path vertices.
	"""
	total_wt = 0
	if len(path_list) == 1:
		return total_wt
	
	for i in range(1, len(path_list)):
		trav = adj_ref[path_list[i-1]].next
		while trav != None:			
			if trav.vertex == path_list[i]:
				total_wt += trav.weight
			trav = trav.next
	return total_wt


def dijkstra(adj_ref, start):
	"""
	Finds a minimal spanning tree in a connected, weighted, n-vertex graph.
	The graph is represented using adjacency lists; adj[i] is a reference to the first node in a linked list of nodes.
	The start vertex is start. In the minial spanning tree, the parent of a vertex is defined as the vertex where existing minimal tree vertex extends from. 
	Start vertex(parent of itself) is = 0.
	"""
	heap = Edges(adj, 4)
	chosen = []
	chosen.append([start, 0])

	while len(heap.get_edges()) > 0:
		heap.print_heap()
		element = heap.pop_row()
		chosen.append(element[2])
		trav = adj_ref[element[0]].next
		added_path = [start]
		
		while trav != None:
			for item in chosen:
				if trav.vertex == item[-1]:
					trav = trav.next
					continue
				if trav.vertex == start:
					trav = trav.next
					continue
				if heap.is_in(trav.vertex):
					if trav.weight < heap.vertex_weight(trav.vertex):
						for element in heap.get_edges():
							if element[0] == trav.vertex:
								new_path = element[2]
								new_path.append(trav.vertex)
						heap.update_row(adj, trav.vertex, new_path)
				else:
					new_path.append(trav.vertex)
					heap.add_row(adj, trav.vertex, new_path)
			trav = trav.next
	least_wt = chosen[1][1]
	least_index = 1
	for i in range(2, len(chosen)):
		if chosen[i][1] != 0 and chosen[i][1] < least_wt:
			least_wt = chosen[i][1]
			least_index = i
	return chosen[i]



if __name__ == "__main__":
	adj_list = [0] * 6 # an array of adjacency list instances
	adj = copy.deepcopy(adj_list) # references to head node

	for i in range(len(adj_list)):
		adj_list[i] = LinkedList() # declare linked list instance
		adj[i] = adj_list[i].get_head() # reference adj[i] to head node

	# Setup the adjacency list
	adj_list[0].add(1, 80)
	adj_list[0].add(2, 40)
	adj_list[0].add(4, 60)

	adj_list[1].add(0, 80)
	adj_list[1].add(3, 100)

	adj_list[2].add(0, 40)
	adj_list[2].add(3, 20)
	adj_list[2].add(5, 60)
	adj_list[2].add(4, 120)

	adj_list[3].add(1, 100)
	adj_list[3].add(2, 20)
	adj_list[3].add(5, 120)

	adj_list[4].add(0, 60)
	adj_list[4].add(2, 120)
	adj_list[4].add(5, 40)

	adj_list[5].add(4, 40)
	adj_list[5].add(2, 60)
	adj_list[5].add(3, 120)

	print adj_list[0].print_list()
	print adj_list[1].print_list()
	print adj_list[2].print_list()
	print adj_list[3].print_list()
	print adj_list[4].print_list()
	print adj_list[5].print_list()

	#test_edge = Edges(adj, 4)
	#print test_edge.get_edges()
	print dijkstra(adj, 4)
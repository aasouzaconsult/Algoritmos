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
	Edge table consisting of vertex, weight and parent_vertex in a row.
	"""	
	edge_table = []

	def __init__(self, adj_ref, start):	
		while adj_ref != None:			
			self.edge_table.append([adj_ref.vertex, adj_ref.weight, start])
			adj_ref = adj_ref.next	

	def get_table(self):
		return self.edge_table

	def add_row(self, vertex, weight, parent_vertex):
		"""
		Add a row in table with vertex, weight and parent_vertex attributes
		"""
		self.edge_table.append([vertex, weight, parent_vertex])

	def pop_row(self):
		"""
		Delete the row in table with the smallest weight and return the corresponding vertex.
		"""
		if len(self.edge_table) > 0:
			least_weight = self.edge_table[0][1]
			least_weight_index = 0
			for i in range(1, len(self.edge_table)):
				if self.edge_table[i][1] < least_weight:
					least_weight = self.edge_table[i][1]
					least_weight_index = i
			least_weight_vertex = self.edge_table[least_weight_index][0]
			self.edge_table.pop(least_weight_index)
			return least_weight_vertex
		else:
			return None

	def is_in(self, vertex):
		"""
		Return true if vertex is in table and false otherwise.
		"""
		for edge in self.edge_table:
			if edge[0] == vertex:
				return True
		return False

	def vertex_weight(self, vertex):
		"""
		Return the weight corresponding to vertex.
		"""
		for edge in self.edge_table:
			if edge[0] == vertex:
				return edge[1]
		return None

	def update_row(self, vertex, weight, parent_vertex):
		"""
		Changes the weight and parent_vertex corresponding to existing vertex.
		"""
		for edge in self.edge_table:
			if edge[0] == vertex:
				edge[1] = weight
				edge[2] = parent_vertex

	def print_table(self):
		"""
		Print edge_table.
		"""
		print self.edge_table		

def prim(adj_ref, start):
	"""
	Finds a minimal spanning tree in a connected, weighted, n-vertex graph. 
	The graph is represented using adjacency lists; adj[i] is a reference to the first node in a linked list of nodes.
	The start vertex is start. In the minial spanning tree, the parent of a vertex is defined as the vertex where existing minimal tree vertex extends from. 
	Start vertex(parent of itself) is = 0.
	"""
	table = Edges(adj_ref[4].next, start)	
	chosen = []
	chosen.append(start)

	while len(table.get_table()) > 0:
		table.print_table()
		ver = table.pop_row()
		chosen.append(ver)
		print "Child vertex %d chosen." % ver
		trav = adj_ref[ver].next

		while trav != None:
			if trav.vertex in chosen:
				trav = trav.next
				continue
			if trav.vertex == start:
				trav = trav.next
				continue	
			if table.is_in(trav.vertex): # table has vertex
				if trav.weight < table.vertex_weight(trav.vertex): # new edge weight is less than existing table value
					table.update_row(trav.vertex, trav.weight, ver) # update table to new vertex and weight
			else:
				# insert vertex and its elements into table
				table.add_row(trav.vertex, trav.weight, ver)
			trav = trav.next
	print chosen


if __name__ == "__main__":
	adj_list = [0] * 6 # an array of adjacency list instances
	adj = copy.deepcopy(adj_list) # references to head node

	for i in range(len(adj_list)):
		adj_list[i] = LinkedList() # declare linked list instance
		adj[i] = adj_list[i].get_head() # reference adj[i] to head node

	# Setup the adjacency list
	adj_list[0].add(1,4)
	adj_list[0].add(2,2)
	adj_list[0].add(4,3)

	adj_list[1].add(0,4)
	adj_list[1].add(3,5)

	adj_list[2].add(0,2)
	adj_list[2].add(4,6)
	adj_list[2].add(5,3)
	adj_list[2].add(3,1)

	adj_list[3].add(1,5)
	adj_list[3].add(2,1)
	adj_list[3].add(5,6)

	adj_list[4].add(0,3)
	adj_list[4].add(2,6)
	adj_list[4].add(5,2)

	adj_list[5].add(4,2)
	adj_list[5].add(2,3)
	adj_list[5].add(3,6)

	prim(adj, 4)
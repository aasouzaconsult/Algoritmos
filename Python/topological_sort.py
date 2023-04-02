class Node:
	"""
	Node class defines the basic structure of a node.
	"""
	def __init__(self, vertex=None, next=None):
		self.vertex = vertex
		self.next = next

class LinkedList:
	"""
	LinkedList class defines a linked list of nodes in which node.next reference the next node in the list
	"""

	def __init__(self):
		self.head = Node()

	def get_head(self):
		"""
		Returns a reference to the head node
		"""
		return self.head

	def add(self, vertex):
		"""
		Append a new node with node.vertex as vertex to the last element in the linked list
		"""
		new_node = Node(vertex)
		trav = self.head
		while(trav.next != None):
			trav = trav.next
		trav.next = new_node

def topo_sort(adj):
	visit = [False] * len(adj) 
	topo_list = []
	topo_index = len(adj) - 1 # topo_index is the index in topo_sorted array where the next vertex to be stored in the topo_sort.
	for i in range(len(adj)):
		if not visit[i]:
			topo_sort_recurs(adj, i, topo_list, topo_index)
	return topo_list

def topo_sort_recurs(adj, start_index, topo_list, topo_index):
	visit[start_index] = True
	trav = adj[start_index].next
	while trav != None:
		ver = trav.vertex
		if not visit[ver]:
			topo_sort_recurs(adj, ver)
		trav = trav.next
	topo_list[topo_index] = start_index
	topo_index -= 1
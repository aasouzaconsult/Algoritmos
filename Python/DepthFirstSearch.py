from Linkedlists import LinkedListNode

class DepthFirstSearch:
	def __init__(self):
		self.visit = []

	def dfs(self, adj_list, start_index):			
		for index in range(len(adj_list)):
			self.visit.append(False)
		self.def_recurs(adj_list, start_index)

	def def_recurs(self, adj_list, start_index):
		print start_index
		self.visit[start_index] = True
		traverse = adj_list[start_index]
		while traverse != None:
			vertex = traverse.data
			if not self.visit[vertex]:
				self.def_recurs(adj_list, vertex)
			traverse = traverse.next

if __name__ == "__main__":
	adj_list = [0] * 5
	adj_list[0] = LinkedListNode(2, LinkedListNode(3))
	adj_list[1] = LinkedListNode(1, LinkedListNode(4))
	adj_list[2] = LinkedListNode(1, LinkedListNode(4))
	adj_list[3] = LinkedListNode(2, LinkedListNode(3, LinkedListNode(5)))
	adj_list[4] = LinkedListNode(4)
	
	test = DepthFirstSearch()
	test.dfs(adj_list, 0)
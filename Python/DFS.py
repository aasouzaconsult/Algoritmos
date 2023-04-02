from ADT.LinkedList import LinkedList

visit = [False] * 5

def dfs(adj, start):
	"""
	Executes a depth first search beginning at vertex 'start' in a graph with
	vertices 1 to n and outputs the vertices in the order in which they are visited.
	"""

	dfs_recurs(adj, start)

def dfs_recurs(adj, start):

	# visited vertext start
	print start

	visit[start] = True
	trav = adj[start]
	while trav is not None:
		vertex = trav.data
		if not visit[vertex]:
			dfs_recurs(adj, vertex)
		trav = trav.next


if __name__ == "__main__":
	adj_instance =[None] * 5
	adj = [None] * 5
	
	# setup adjaceny list
	for i in range(len(adj_instance)):
		adj_instance[i] = LinkedList()
	
	adj_instance[0].insert(1)
	adj_instance[0].insert(2)
	adj_instance[0].print_list()

	adj_instance[1].insert(0)
	adj_instance[1].insert(3)
	adj_instance[1].print_list()	

	adj_instance[2].insert(0)
	adj_instance[2].insert(3)
	adj_instance[2].print_list()

	adj_instance[3].insert(1)
	adj_instance[3].insert(2)
	adj_instance[3].insert(4)
	adj_instance[3].print_list()

	adj_instance[4].insert(3)
	adj_instance[4].print_list()

	for i in range(len(adj_instance)):
		adj[i] = adj_instance[i].get_head()
	
	dfs(adj, 0)
# Adjacency matrix structure
# PRO
# - faster test if an edge is in graph
# - less memory in big graphs
# - faster edge insertion/deletion
#
# Con
# - uses O(n*n) memory
# - slow to iterate over all edges
#
# ADjacency list structure
# PRO
# - faster to find degree of vertex
# - less memory on small graphs
# - faster graph traversal
# - better for most graph problems
# - use memory in proportion to number of edges


# Implementation of graph using adjacency list structure.


class EdgeNode(object):
    """

    Node structure for graph edges.

    """
    def __init__(self, info=None, weight=None):
        self.info = info
        self.weight = weight
        self.next = None

    def get_info(self):
        return self.info

    def set_info(self, info):
        self.info = info
        return


class Graph(object):
    """

    Adjacency list graph.

    """
    def __init__(self, n_vertices, degree=None, directed=False):
        self.edges = []
        self.degree = []  # number of entries for each vertex
        self.n_vertices = n_vertices  # number of vertices
        # total number of edges for this graph, undirected graph edges
        # are counted twice from their respective vertices
        self.n_edges = 0
        self.directed = directed  # True if graph is directed
        for i in range(n_vertices):
            self.edges.append(None)
            self.degree.append(0)

    def insert_edge(self, edge):
        edgenode = EdgeNode(edge[1])
        if self.edges[edge[0]] is None:
            self.edges[edge[0]] = edgenode
            return
        curr = self.edges[edge[0]]
        while curr.next is not None:
            curr = curr.next
        curr.next = edgenode
        self.degree[edge[0]] += 1
        self.n_edges += 1
        return

    def print_edges(self):
        i = 0
        for obj in self.edges:
            while obj is not None:
                print obj.info,
                obj = obj.next
            print ""
            print "Vertice %d has degree: %d" % (i, self.degree[i])
            i += 1
        print "Graph has %d edges." % self.n_edges
        return

    def print_vertice(self, vertice):
        print vertice.get_info(),
        return

    def bfs(self, start, callback=print_vertice):
        """

        Breadth first search method of the graph.

        """
        # initalize visited boolean array
        visited = [False for _ in range(self.n_vertices)]
        # initialize queue
        queue = []
        # visit starting vertice
        visited[start] = True
        print start,
        # traverse starting vertice's adjacent vertices
        curr = self.edges[start]
        while curr is not None:
            queue.append(curr)
            curr = curr.next
        while len(queue) > 0:
            vertice = queue.pop(0)
            if not visited[vertice.get_info()]:
                # mark as visited
                visited[vertice.get_info()] = True
                callback(self, vertice)
                curr = self.edges[vertice.get_info()]
                while curr is not None:
                    queue.append(curr)
                    curr = curr.next
        return

    def dfs(self, start, callback=print_vertice):
        """

        Depth first search method of the graph.

        """
        # initalize visited boolean array
        visited = [False for _ in range(self.n_vertices)]
        print visited
        #initialize stack
        stack = []
        # visit starting vertice
        visited[start] = True
        print start,
        # put in starting adjacent vertices
        curr = self.edges[start]
        while curr is not None:
            stack.append(curr)
            curr = curr.next

        while len(stack) > 0:
            vertice = stack.pop()
            if not visited[vertice.get_info()]:
                visited[vertice.get_info()] = True
                callback(self, vertice)
            curr = self.edges[vertice.get_info()]
            # auxillary stack to visit neighbours in the order they are in
            # the adjacency list.
            # alternatively, iterate through the array in reverse but this
            # is only to get the same output as the recur
            # otherwise, this would not be necessary
            adj_stack = []
            while curr is not None:
                if not visited[curr.get_info()]:
                    adj_stack.append(curr)
                curr = curr.next
            while len(adj_stack) > 0:
                stack.append(adj_stack.pop())
        return

    def dfs_recurs(self, start):
        visited = [False for _ in range(self.n_vertices)]
        self.dfs_recur(start, visited)

    def dfs_recur(self, start, visited, callback=print_vertice):
        """

        Depth first search method of the graph.

        """
        print start,
        visited[start] = True
        curr = self.edges[start]
        while curr is not None:
            if not visited[curr.get_info()]:
                self.dfs_recur(curr.get_info(), visited)
            curr = curr.next


def init_graph():
    with open('data_structures/graphs/graph2.txt') as f:
        n_vertices, n_edges = map(int, f.readline().split())
        graph = Graph(n_vertices)
        for line in f:
            line = map(int, line.split())
            print line
            graph.insert_edge(line)
        graph.print_edges()
        graph.bfs(0)
        graph.dfs(0)
        print ""
        graph.dfs_recurs(0)

if __name__ == "__main__":
    init_graph()

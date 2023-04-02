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
# Adjacency list structure
# pro
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
        """

        edge has input format: [from_vertice, to_vertice]

        """
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


def init_graph():
    with open('data_structures/graphs/graph4.txt') as f:
        n_vertices, n_edges = map(int, f.readline().split())
        graph = Graph(n_vertices)
        for line in f:
            line = map(int, line.split())
            print line
            graph.insert_edge(line)
        graph.print_edges()
        print ""

if __name__ == "__main__":
    init_graph()

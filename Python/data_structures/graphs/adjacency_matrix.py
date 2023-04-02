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


# Implementation of graph using adjacency matrix structure.


class Graph(object):
    """

    Adjacency matrix graph.

    """
    def __init__(self, n_vertices):
        # initialize a 2d list
        self.matrix = [[0 for _ in range(n_vertices)]
                       for _ in range(n_vertices)]

    def insert_edge(self, edge):
        # 0 indexing
        edge[0] -= 1
        edge[1] -= 1
        self.matrix[edge[0]][edge[1]] = 1
        return

    def is_connected(self, source, dest):
        # 0 indexing
        source -= 1
        dest -= 1
        if self.matrix[source][dest] is 1:
            return True
        return False

    def print_graph(self):
        for row in self.matrix:
            print row,
            print ""
        return


def init_graph():
    with open('data_structures/graphs/graph1.txt') as f:
        n_vertices, n_edges = map(int, f.readline().split())
        graph = Graph(n_vertices)
        graph.print_graph()
        for line in f:
            edge = map(int, line.split())
            graph.insert_edge(edge)
        graph.print_graph()
    print graph.is_connected(1, 5)
    print graph.is_connected(1, 3)

if __name__ == '__main__':
    init_graph()

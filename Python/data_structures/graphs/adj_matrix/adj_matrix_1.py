class Graph(object):
    def __init__(self, n_vertices):
        self.matrix = [[0 for _ in xrange(n_vertices)]
                       for _ in xrange(n_vertices)]

    def insert_edge(self, edge):
        """

        *edge* takes in two vertices which are connected in a list format.
        [vertice_1, vertice_2]

        """
        # adjust for 0 indexing
        self.matrix[edge[0]-1][edge[1]-1] = 1
        return

    def is_connected(self, source, dest):
        # adjust for 0 indexing
        source -= 1
        dest -= 1
        if self.matrix[source][dest] == 1:
            return True
        return False

    def print_graph(self):
        for line in self.matrix:
            print line
        return

    def bfs(self, start, end):
        pass

    def dfs(self, start, end):
        pass


def init_graph():
    with open('data_structures/graphs/graph1.txt') as f:
        n_vertices, n_edges = map(int, f.readline().split())
        graph = Graph(n_vertices)
        for line in f:
            edge = map(int, line.split())
            graph.insert_edge(edge)
        graph.print_graph()

if __name__ == "__main__":
    init_graph()

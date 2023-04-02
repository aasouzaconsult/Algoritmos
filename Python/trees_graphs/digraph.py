class Vertice(object):
    """

    Vertice structure in a Digraph.

    """
    def __init__(self, value):
        self.value = value
        self.next = None

    def __str__(self):
        return str(self.value)

    def get_next(self):
        return self.next

    def set_next(self, vertice):
        self.next = vertice

    def get_value(self):
        return self.value


class Digraph(object):
    """

    A graph, implemented using an array of lists.
    Parallel edges and self loops are permitted.
    We represent each vertice in the graph strictly by its number, no other
    satellite data are involved.

    test file: graph3.txt
    13 vertices, 22 edges
    0: 5 1
    1:
    2: 0 3
    3: 5 2
    4: 3 2
    5: 4
    6: 9 4 8 0
    7: 6 9
    8: 6
    9: 11 10
    10: 12
    11: 4 12
    12: 9

    """
    def __init__(self, n_vertices):
        self.graph = [None for _ in xrange(n_vertices)]
        self.vertices = n_vertices

    def insert_edge(self, source, dest):
        """

        Insert an edge from *source* vertice to *dest* vertice.

        """
        new_vertice = Vertice(dest)
        if self.graph[source] is None:
            self.graph[source] = new_vertice
            return
        new_vertice.next = self.graph[source]
        self.graph[source] = new_vertice
        return

    def get_edges(self, vertex):
        return self.graph[vertex]

    def print_graph(self):
        for i in xrange(len(self.graph)):
            curr = self.graph[i]
            print "%d: " % i,
            while curr is not None:
                print curr,
                curr = curr.next
            print ""
        return

    def vertice_count(self):
        return self.vertices

if __name__ == "__main__":
    digraph = Digraph(13)

    with open('data_structures/graphs/graph3.txt') as f:
        n_vertices, n_edges = map(int, f.readline().split())
        for line in f:
            line = map(int, line.split())
            digraph.insert_edge(line[0], line[1])
    digraph.print_graph()

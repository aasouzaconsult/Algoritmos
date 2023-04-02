class Node(object):
    """

    Node structure for graph.

    """
    def __init__(self, data, weight):
        self.data = data
        self.weight = weight
        self.next = None


class LinkedList(object):
    def __init__(self, data, weight):
        self.head = Node(data, weight)

    def get_head(self):
        return self.head

    def insert(self, data, weight):
        node = Node(data, weight)
        node.next = self.head
        self.head = node
        return

    def delete(self, data):
        if self.head.data == data:
            self.head = self.head.next
            return
        prev, node = self._prev_node_set(data)
        if node is None:
            return
        prev.next = node.next
        node = None
        return

    def _prev_node_set(self, data):
        """

        Return the node with data and its previous node

        """
        prev = None
        trav = self.head
        while trav is not None:
            if trav.data == data:
                return prev, trav
            prev = trav
            trav = trav.next
        return

    def search(self, data):
        return self._prev_node_set(data)[1]

    def get_list(self):
        result = []
        trav = self.head
        while trav is not None:
            result.append([trav.data, trav.weight])
            trav = trav.next
        return result


class Graph(object):
    """

    Implementation of graph using adjacency list.

    """
    def __init__(self, n_vertices):
        self.graph = [None for _ in xrange(n_vertices)]
        self.n_vertices = n_vertices

    def insert_edge(self, edge):
        """

        edge parameter has format [src, dest]

        """
        if self.graph[edge[0]] is None:
            self.graph[edge[0]] = LinkedList(edge[1], edge[2])
        else:
            self.graph[edge[0]].insert(edge[1], edge[2])
        return

    def is_connected(self, src, dest):
        edges = self.graph[src]
        while edges is not None:
            if edges.data == dest:
                return True
            edges = edges.next
        return False

    def print_vertice(self, vertice):
        print vertice.data,
        return

    def print_graph(self):
        for vertice in self.graph:
            if vertice is None:
                print None
            else:
                print vertice.get_list()
        return

    def min_dist(self, dist, bool_list):
        """

        Utility function to find the vertex with minimum distance value, from
        set of vertices not yet included in shortest path tree.

        """
        min_weight = float("inf")
        min_index = -1
        for i in xrange(len(dist)):
            if not bool_list[i] and dist[i] < min_weight:
                print "min_index is %d" % i
                min_weight = dist[i]
                min_index = i
        return min_index

    def dijkstra(self, src):
        # init dist to each vertex to inf
        dist = [float("inf") for _ in xrange(self.n_vertices)]
        # init visited bool list for each vertex from src
        visited = [False for _ in xrange(self.n_vertices)]
        result = []
        # src dist is always 0, unless negative weight directs to source
        dist[src] = 0

        # visit each vertex
        for i in xrange(self.n_vertices):
            min_index = self.min_dist(dist, visited)
            print min_index
            visited[min_index] = True
            print visited
            result.append(min_index)
            trav = self.graph[min_index].get_head()
            while trav is not None:
                if not visited[trav.data] and dist[min_index]+trav.weight < dist[trav.data]:
                    dist[trav.data] = dist[min_index] + trav.weight
                trav = trav.next
            print result
            print dist
        return dist, result

    def topo_sort_recurs(self, vertex_index, visited, stack):

        visited[vertex_index] = True

        trav = self.graph[vertex_index]
        while trav is not None:
            if not visited[trav.data]:
                self.topo_sort_recurs(trav.data, visited, stack)
        stack.append(vertex_index)
        return

    def topological_sort(self):
        # init reverse stack for topo sort
        reverse_stack = []
        # init visited bool list
        visited = [False for _ in xrange(self.n_vertices)]

        for i in xrange(self.n_vertices):
            if not visited[i]:
                topo_sort_recurs(i, visited, stack)

        while len(stack) > 0:
            print stack.pop(),
        return


def init_graph():
    with open('data_structures/graphs/graph4.txt') as f:
        n_vertices, n_edge = map(int, f.readline().split())
        graph = Graph(n_vertices)
        for line in f:
            edge = map(int, line.split())
            graph.insert_edge(edge)
        graph.print_graph()
        print graph.dijkstra(0)

if __name__ == "__main__":
    init_graph()

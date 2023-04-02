class Node(object):
    """

    Node structure for graph.

    """
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList(object):
    """

    Linked list for adjacency list.

    """
    def __init__(self, data):
        self.head = Node(data)

    def get_head(self):
        return self.head

    def insert(self, data):
        node = Node(data)
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
        prev = None
        trav = self.head
        while trav is not None:
            if trav.data == data:
                return prev, trav
            prev = trav
            trav = trav.next
        return

    def search(self, data):
        prev, node = self._prev_node_set(data)
        return node

    def get_list(self):
        result = []
        trav = self.head
        while trav is not None:
            result.append(trav.data)
            trav = trav.next
        return result


class Graph(object):
    """

    Implementation of graph using adjacency list.

    """
    def __init__(self, n_vertices):
        self.graph = [None for _ in xrange(n_vertices)]
        self.vertices = n_vertices

    def insert_edge(self, edge):
        if self.graph[edge[0]] is None:
            self.graph[edge[0]] = LinkedList(edge[1])
        else:
            self.graph[edge[0]].insert(edge[1])
        return

    def is_connected(self, source, dest):
        edges = self.graph[source]
        while edges is not None:
            if edges.data == dest:
                return True
            edges = edges.next
        return False

    def print_vertice(self, vertice):
        print vertice.data,
        return

    def bfs(self, start, callback=print_vertice):
        """

        Search the graph with breadth first search method.

        """
        # initialize visited boolean list
        visited = [False for _ in xrange(self.vertices)]
        # initialize queue
        queue = []
        # visit starting vertice
        visited[start] = True
        print start,
        # append starting vertice's adjacent vertices
        curr = self.graph[start].get_head()
        while curr.next is not None:
            queue.append(curr)
            curr = curr.next
        # process the vertice queue
        while len(queue) > 0:
            # pop least recent vertice
            vertice = queue.pop(0)
            # if vertice not visited, visit vertice and append its adjacent
            # vertices
            if not visited[vertice.data]:
                # mark as visited
                visited[vertice.data] = True
                callback(self, vertice)
                curr = self.graph[vertice.data].get_head()
                while curr is not None:
                    queue.append(curr)
                    curr = curr.next
        return

    def dfs(self, start, callback=print_vertice):
        """

        Search the graph with depth first search method.

        """
        # initialize visited boolean array
        visited = [False for _ in xrange(self.vertices)]
        # initialize stack
        stack = []
        # visit starting vertice
        visited[start] = True
        print start,
        # append starting adjacent vertices
        curr = self.graph[start].get_head()
        while curr is not None:
            stack.append(curr)
            curr = curr.next
        # process the vertice queue
        while len(stack) > 0:
            vertice = stack.pop()
            # visit vertice if not visited
            if not visited[vertice.data]:
                visited[vertice.data] = True
                callback(self, vertice)
            curr = self.graph[vertice.data].get_head()
            # aux stack to visit neighbours in the order they are in the
            # adjacency list.
            # alternatively, iterate through the array in reverse
            aux_stack = []
            while curr is not None:
                if not visited[curr.data]:
                    aux_stack.append(curr)
                curr = curr.next
            while len(aux_stack) > 0:
                stack.append(aux_stack.pop())
        return

    def print_graph(self):
        for vertice in self.graph:
            if vertice is None:
                print None
            else:
                print vertice.get_list()
        return


def init_graph():
    with open('data_structures/graphs/graph1.txt') as f:
        n_vertices, n_edge = map(int, f.readline().split())
        graph = Graph(n_vertices)
        for line in f:
            edge = map(int, line.split())
            graph.insert_edge(edge)
        graph.print_graph()
        graph.bfs(0)
        print ""
        graph.dfs(0)

if __name__ == "__main__":
    init_graph()

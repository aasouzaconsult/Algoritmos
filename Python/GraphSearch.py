from ADT.LinkedList import LinkedList


class GraphSearch(object):
    """
    Graph search methods containing
    breadth_first_search
    depth_first_search.
    """

    def __init__(self, size):
        self.visit = [False] * size

    def depth_first_search(self, adj, start):
        """
        Executes a depth first search beginning at vertex 'start' in a graph
        with vertices 1 to n and outputs the vertices in the order in which
        they are visited.
        """

        self._dfs_recurs(adj, start)

    def breadth_first_search(self, adj, start):
        """
        Executes a breadth first search beginning at vertex 'start' in
        a graph with vertices 1 to n and outputs the vertices in the
        order in which they are visited.
        """

        queue = []
        # visit start vertex and enqueue start vertex
        self.visit[start] = True
        print start
        queue.append(start)

        while len(queue) is not 0:
            # remove vertex from queue set as current
            current = queue.pop(0)

            # traversal current vertex list
            trav = adj[current]
            while trav is not None:
                vertex = trav.data
                if self.visit[vertex] is False:
                    self.visit[vertex] = True
                    print vertex
                    queue.append(vertex)
                trav = trav.next

    def _dfs_recurs(self, adj, start):
        """
        Recursively perform depth first search.
        """

        # visited vertex start
        print start

        self.visit[start] = True
        trav = adj[start]

        while trav is not None:
            vertex = trav.data
            if not self.visit[vertex]:
                self._dfs_recurs(adj, vertex)
            trav = trav.next


if __name__ == "__main__":
    adj_instance = [None] * 13
    adj = [None] * 13

    # initiate instance object
    for i in range(len(adj_instance)):
        adj_instance[i] = LinkedList()

    adj_instance[0].insert(2)

    adj_instance[1].insert(2)
    adj_instance[1].insert(5)

    adj_instance[2].insert(0)
    adj_instance[2].insert(1)
    adj_instance[2].insert(6)
    adj_instance[2].insert(3)

    adj_instance[3].insert(2)
    adj_instance[3].insert(7)

    adj_instance[4].insert(5)

    adj_instance[5].insert(1)
    adj_instance[5].insert(4)
    adj_instance[5].insert(9)
    adj_instance[5].insert(6)

    adj_instance[6].insert(2)
    adj_instance[6].insert(5)
    adj_instance[6].insert(10)
    adj_instance[6].insert(7)

    adj_instance[7].insert(3)
    adj_instance[7].insert(6)
    adj_instance[7].insert(11)
    adj_instance[7].insert(8)

    adj_instance[8].insert(7)

    adj_instance[9].insert(5)
    adj_instance[9].insert(10)

    adj_instance[10].insert(6)
    adj_instance[10].insert(9)
    adj_instance[10].insert(12)
    adj_instance[10].insert(11)

    adj_instance[11].insert(7)
    adj_instance[11].insert(10)

    adj_instance[12].insert(10)

    # setup adjacency list references
    for i in range(len(adj_instance)):
        adj[i] = adj_instance[i].get_head()
        adj_instance[i].print_list()
    graph_search = GraphSearch(len(adj_instance))
    #graph_search.breadth_first_search(adj, 0)
    graph_search.depth_first_search(adj, 0)

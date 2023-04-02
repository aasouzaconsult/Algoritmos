class Graph(object):
    def __init__(self, n_vertices, matrix=None):
        if matrix is None:
            self.matrix = [[0 for _ in xrange(n_vertices)]
                           for _ in xrange(n_vertices)]
        else:
            self.matrix = matrix

    def insert_edge(self, edge):
        self.matrix[edge[0]-1[edge[1]]-1] = 1
        return

    def is_connected(self, source, dest):
        source -= 1
        dest -= 1
        if self.matrix[source][dest] == 1:
            return True
        return False

    def print_graph(self):
        for line in self.matrix:
            print line
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
                min_weight = dist[i]
                min_index = i
        return min_index

    def dijkstra(self, src):
        # init dist list to keep track of least dist between src and vertex
        # init boolean list to keep track of vertex visits
        dist = [float("inf") for _ in xrange(len(self.matrix))]
        visited = [False for _ in xrange(len(self.matrix))]
        result = []
        dist[src] = 0
        for i in xrange(len(self.matrix)):
            # pick min dist vertex that's not visited and return the index
            min_index = self.min_dist(dist, visited)
            visited[min_index] = True
            result.append(min_index)
            for j in xrange(len(dist)):
                # if edge is not 0
                # if visited is false
                #   if added value is less than dist index value
                #   if dist is not infinite value
                if not visited[j] and self.matrix[min_index][j] != 0 and dist[min_index] != float("inf"):
                    if dist[min_index] + self.matrix[min_index][j] < dist[j]:
                        dist[j] = dist[min_index] + self.matrix[min_index][j]
        return dist, result


def init_graph():
    new_graph = [[0, 4, 0, 0, 0, 0, 0, 8, 0],
                 [4, 0, 8, 0, 0, 0, 0, 11, 0],
                 [0, 8, 0, 7, 0, 4, 0, 0, 2],
                 [0, 0, 7, 0, 9, 14, 0, 0, 0],
                 [0, 0, 0, 9, 0, 10, 0, 0, 0],
                 [0, 0, 4, 0, 10, 0, 2, 0, 0],
                 [0, 0, 0, 14, 0, 2, 0, 1, 6],
                 [8, 11, 0, 0, 0, 0, 1, 0, 7],
                 [0, 0, 2, 0, 0, 0, 6, 7, 0]]
    graph = Graph(9, matrix=new_graph)
    graph.print_graph()
    print graph.dijkstra(0)


if __name__ == "__main__":
    init_graph()

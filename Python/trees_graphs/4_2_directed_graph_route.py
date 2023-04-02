# Given a directed graph, design an algorithm to find out whether there is a
# route between two nodes.
# Easier with adjacency matrix
# Harder to determine with adjacency list.


import digraph


def has_route(digraph, node1, node2):
    """

    Return True if node1 is connected to node2 in graph, False otherwise.
    Use breadth first search traversal method.

    """
    if node1 == node2:
        return True
    # initialize visited booleans
    visited = [False for _ in range(digraph.vertice_count())]
    # initialize queue
    queue = []
    # add starting node to queue FIFO
    # while loop terminates when queue is 0
    #   pop queue to variable
    #   if variable is node2:
    #       return True
    #   if variable not visited:
    #       visit node
    #       mark node as visited
    # return False
    visited[node1] = True
    curr = digraph.get_edges(node1)
    while curr is not None:
        queue.append(curr)
        curr = curr.next

    while len(queue) > 0:
        vertex = queue.pop(0)
        value = vertex.get_value()
        if vertex.get_value() == node2:
            return True
        elif not visited[value]:
            visited[value] = True
            curr = digraph.get_edges(value)
            while curr is not None:
                queue.append(curr)
                curr = curr.next
    return False


def has_route2(digraph, node1, node2):
    """

    Return True if node1 is connected node2 in graph, False otherwise.
    User depth first search traversal method.

    """
    if node1 == node2:
        return True
    # initialize visited booleans
    visited = [False for _ in range(digraph.vertice_count())]
    # initialize stack
    stack = []
    # mark starting node as visited
    # get starting nodes neighbouring edges
    # put these edges in stack
    visited[node1] = True
    curr = digraph.get_edges(node1)
    while curr is not None:
        stack.append(curr)
        curr = curr.next

    while len(stack) > 0:
        vertex = stack.pop()
        value = vertex.get_value()
        if value == node2:
            return True
        elif not visited[value]:
            visited[value] = True
        curr = digraph.get_edges(value)
        # auxillary stack to visit neighbours in the order they are in
        # the adjacency list.
        # alternatively, iterate throught the array in reverse but this
        # is only to get the same output in number order
        # otherwise this would not be necessary
        adj_stack = []
        while curr is not None:
            if not visited[curr.get_value()]:
                adj_stack.append(curr)
            curr = curr.next
        while len(adj_stack) > 0:
            stack.append(adj_stack.pop())
    return False

if __name__ == "__main__":
    digraph = digraph.Digraph(13)

    with open('data_structures/graphs/graph3.txt') as f:
        n_vertices, n_edges = map(int, f.readline().split())
        for line in f:
            line = map(int, line.split())
            digraph.insert_edge(line[0], line[1])
    digraph.print_graph()
    print "%s, %s" % (has_route(digraph, 0, 0), has_route2(digraph, 0, 0))
    print "%s, %s" % (has_route(digraph, 0, 1), has_route2(digraph, 0, 1))
    print "%s, %s" % (has_route(digraph, 0, 2), has_route2(digraph, 0, 2))
    print "%s, %s" % (has_route(digraph, 0, 3), has_route2(digraph, 0, 3))
    print "%s, %s" % (has_route(digraph, 0, 4), has_route2(digraph, 0, 4))
    print "%s, %s" % (has_route(digraph, 0, 5), has_route2(digraph, 0, 5))
    print "%s, %s" % (has_route(digraph, 0, 6), has_route2(digraph, 0, 6))
    print "%s, %s" % (has_route(digraph, 0, 7), has_route2(digraph, 0, 7))
    print "%s, %s" % (has_route(digraph, 0, 8), has_route2(digraph, 0, 8))
    print "%s, %s" % (has_route(digraph, 0, 9), has_route2(digraph, 0, 9))
    print "%s, %s" % (has_route(digraph, 0, 10), has_route2(digraph, 0, 10))
    print "%s, %s" % (has_route(digraph, 0, 11), has_route2(digraph, 0, 11))
    print "%s, %s" % (has_route(digraph, 0, 12), has_route2(digraph, 0, 12))

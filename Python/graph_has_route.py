from ADT.Graph.adj_list import Vertex, Graph

##################################
### Title: Graph node connection #
### Author: GuoChen Hou   ########
##################################

# Given a directed graph, design an algorithm to find out whether there is
# a route between two nodes.


def is_connected(graph, start, end):
    """
    Given a directed graph, Check if there is a route between two nodes.
    adj_list is the physical representation of the directed graph
    @pre: start and end are 1 indexed.
    @return True if a route exists, False otherwise.

    """
    # use a depth first search traversal method to traverse the graph.
    if start == end:
        return True
    # result
    connected = False
    # create a stack
    stack = []

    # initiate visited flag
    visited = []
    for vertex in graph:
        visited.append(False)
    stack.append(start)
    visited[start-1] = True

    while len(stack) > 0:
        current = stack[-1]
        all_visited = False
        # traverse the neighbouring vertices
        for vertex in graph.get_vertex(current).get_connections():
            if vertex.get_key() == end:
                connected = True
                break
            elif not visited[vertex.get_key()-1]:
                stack.append(vertex.get_key())
                visited[vertex.get_key()-1] = True
                break
            else:
                all_visited = True
        if connected:
            break
        elif all_visited:
            stack.pop()
    return connected

if __name__ == "__main__":
    graph = Graph()
    for i in range(5):
        graph.add_vertex(i+1)
    print graph.vert_list

    graph.add_edge(1, 5)
    graph.add_edge(1, 2)
    graph.add_edge(2, 1)
    graph.add_edge(2, 5)
    graph.add_edge(2, 4)
    graph.add_edge(2, 3)
    graph.add_edge(3, 2)
    graph.add_edge(3, 4)
    graph.add_edge(4, 3)
    graph.add_edge(4, 2)
    graph.add_edge(4, 5)
    graph.add_edge(5, 1)
    graph.add_edge(5, 2)
    graph.add_edge(5, 4)
    for vertex in graph:
        for neighbour in vertex.get_connections():
            print "[%s, %s]" % (vertex.get_key(), neighbour.get_key())
    print is_connected(graph, 1, 3)

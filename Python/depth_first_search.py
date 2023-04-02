import copy

# The graph is represented using adjacency lists; adj[i] is a reference to the
# first node in a linked list of nodes representing the vertices adjacent to
# vertex i. Each node has members vertex, the vertex adjacent to i, and next,
# the next node in the linked list or null, for the last node in the
# linked list.


class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

visit = [False] * 5


def depth_first_search(adj_list, start_index):
    """
    This function executes a depth first search beginning at vertex start_index
    in a graph with vertices 1,...,n and outputs the vertices in the order in
    which they are visited.
    """
    dfs_recurs(adj_list, start_index)


def is_connected(adj_list):
    """
    This function tests whether a graph is connected. It returns True if graph
    is connected and False otherwise.
    """
    dfs_recurs(adj_list, 0)
    for i in range(len(adj_list)):
        if not visit[i]:
            return False
    return True


def dfs_recurs(adj_list, start_index):
    """
    Recursive solution of DFS.
    """
    # visit node
    print start_index

    # mark as visited
    visit[start_index] = True

    trav = adj[start_index]
    while trav is not None:
        vertex = trav.data
        if not visit[vertex]:
            dfs_recurs(adj_list, vertex)
        trav = trav.next


if __name__ == "__main__":
    size = int(raw_input())
    adj = []  # stores references to first nodes
    node = [0] * size  # stores node instances
    for i in range(size):
        adj.append(i)
    # setup the test case
    node1 = Node(1)
    node2 = Node(2)
    adj[0] = node1
    node1.next = node2
    print "%d %d" % (adj[0].data, adj[0].next.data)
    node3 = Node(0)
    node4 = Node(3)
    adj[1] = node3
    node3.next = node4
    adj[2] = copy.deepcopy(adj[1])
    print "%d %d" % (adj[1].data, adj[1].next.data)
    print "%d %d" % (adj[2].data, adj[2].next.data)

    adj[3] = Node(1)
    node6 = Node(2)
    node7 = Node(4)
    adj[3].next = node6
    node6.next = node7
    print "%d %d %d" % (adj[3].data, adj[3].next.data, adj[3].next.next.data)

    node8 = Node(3)
    adj[4] = node8
    print "%d" % adj[4].data

    depth_first_search(adj, 0)
    print is_connected(adj)

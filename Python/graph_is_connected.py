from collections import deque

##################################
### Title: Graph Connection ######
### Author: GuoChen Hou   ########
##################################

# Given a directed graph, design an algorithm to find out whether there is
# a route between two nodes.


def is_connected(adjacency_list, initial_node, end_node):
    """
    Given a directed graph, Check if there is a route between two nodes.
    @return True if a route exists, False otherwise.
    adjacency_list is the physical representation of the directed graph
    """
    if initial_node is end_node:
        return True
    # create a queue to maintain different paths
    queue = deque()

    # mark a node as visited upon checking for end_node
    visit = [False] * len(adjacency_list)

    # mark starting node as current node
    visit[initial_node] = True
    queue.append(initial_node)
    # while queue is not empty
    while len(queue) is not 0:
    #   dequeue item and mark as current
        current = queue.popleft()
        #   check if current node is the end node, return if True
        if current is end_node:
            return True
        trav = adjacency_list[current].next
        while trav is not None:
            if trav is end_node:
                return True
            else:  # otherwise append the node to queue
                visit[current] = True
                # enqueue node
                queue.append(current)
        #   move to next node
            trav = trav.next
    return False

if __name__ == "__main__":
    pass

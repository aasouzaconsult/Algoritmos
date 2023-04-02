# Given a binary search tree, design an algorithm which creates a linked list
# of all the nodes at each depth.
# ie. if you have a tree with depth D, you'll have D linked lists.
#

from ADT.binary_search_tree_revisit import *
from ADT.LinkedList import *


def bst_to_linkedlist(bst):
    """
    Take in a binary search tree object and return a linked list of all the
    nodes at each depth.

    """
    # check that the bst has at least a root node
    node = bst.get_root()
    if node is None:
        return
    # using a version of level order traversal(breadth first search)
    # queue up the first element
    queue = [[0, node]]
    # initialize result list
    result = []
    # set the level for which 
    level = 0
    while len(queue) > 0:
        trav = queue.pop(0)
        if trav[1].left is not None:
            queue.append([trav[0] + 1, trav[1].left])
        if trav[1].right is not None:
            queue.append([trav[0] + 1, trav[1].right])
        added = False
        for item in result:
            if trav[0] == item[0]:
                result[trav[0]].append(trav[1].data)
                added = True
        if not added:
            result.append([trav[0], trav[1].data])
        level += 1
    # result[*][0] of every element is the level of the tree
    # we strip the level from each index of result
    linkedlist_sets = []
    for item in result:
        item.pop(0)
        linkedlist = LinkedList()
        for value in item:
            linkedlist.insert(value)
        linkedlist_sets.append(linkedlist)
    # result in list format
    print result
    # result in linked list format
    print linkedlist_sets
    return linkedlist_sets #  [[8], [3, 10], [1, 6, 14], [4, 7, 13]]


if __name__ == "__main__":
    tree = BinarySearchTree(8)
    tree.insert(3)
    tree.insert(10)
    tree.insert(1)
    tree.insert(6)
    tree.insert(4)
    tree.insert(7)
    tree.insert(14)
    tree.insert(13)    
    bst_to_linkedlist(tree)

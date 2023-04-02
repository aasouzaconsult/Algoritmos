"""
Design an algorithm and write code to find the first common ancestor of two
nodes in a binary tree. Avoid storing additional nodes in a data structure.

NOTE: This is not necessarily a binary search tree.

"""
from ADT.binary_search_tree_revisit import *


def find_ancestor_node(tree, node1, node2):
    """
    This solution uses an additional list to store the parent values and
    assumes there's a parent link to each node's parent.

    """
    # check both nodes are not root node
    root = tree.get_root()
    if node1 is root or node2 is root:
        return

    node1_parents = find_parents(node1)
    node2_parents = find_parents(node2)

    result_node = None
    for item1 in node1_parents[::-1]:
        for item2 in node2_parents[::-1]:
            if item1.data == item2.data:
                result_node = item1
                break
    print result_node.data
    return result_node


def find_parents(node):
    result = []
    while node.parent is not None:
        result.append(node.parent)
        node = node.parent
    return result


def find_ancestor_node_v2(tree, node1, node2):
    """
    Assume there is a parent link to each node's parent, We traverse up both
    nodes consecutively until we hit the root node or the first common
    ancestor. This solution does not use additional data structures.

    """
    # check both nodes are not root node
    root = tree.get_root()
    if node1 is root or node2 is root:
        return

    result_node = None
    while True:
        # if node1 parent is node2 parent
        #   break and return the node
        if node1 is node2:
            result_node = node1
            break
        # if either nodes' parent is null, break
        elif node1.parent is None and node2.parent is None:
            break
        # traverse node1 up to its parent
        if node1.parent is not None:
            node1 = node1.parent
        # traverse node2 up to its parent
        if node2.parent is not None:
            node2 = node2.parent
    print result_node.data
    return result_node


def find_ancestor_node_v3(tree, node1, node2):
    """
    Traverse the tree starting from root node.
    If node1 is found in root.left and node2 found in root.right, set root as
    result and return. else if both nodes are found in
    root.left(or root.right), traverse to root.left(or root.right) update
    result and continue this step until node1 is found in left of current node
    and node2 is found in right. update and return the result.
    This solution does not use additional data structures.

    """
    # check both nodes are not root node
    root = tree.get_root()
    if node1 is root or node2 is root:
        return

    trav = root
    result_node = None
    while True:
        # terminating condition. has traversed to leaf node
        if trav.left is None or trav.right is None:
            print "DEBUG 4"
            break
        # first common ancestor found
        if (tree.lookup(trav.left, node1.data) is not None and
           tree.lookup(trav.right, node2.data) is not None):
            result_node = trav
            print "DEBUG 1"
            break
        # determine which side of the sub-tree the result node lies
        if tree.lookup(trav.left, node1.data) is None:
            result_node = trav.right
            trav = trav.right
            print "DEBUG 2"
        else:
            result_node = trav.left
            trav = trav.left
            print "DEBUG 3"
    print result_node.data
    return result_node

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
    root = tree.get_root()
    node1 = tree.lookup(root, 1)
    node2 = tree.lookup(root, 14)
    node3 = tree.lookup(root, 4)

    tree.print_levelorder(root)
    print "\n"
    find_ancestor_node(tree, node1, node3)
    find_ancestor_node_v2(tree, node1, node3)
    find_ancestor_node_v3(tree, node1, node3)

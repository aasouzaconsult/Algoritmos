"""
Write an algorithm to find the 'next' node(ie. in-order successor of a given
node in a binary search tree where each node has a link to its parent.)

"""

from ADT.binary_search_tree_revisit import *


def inorder_successor(tree, data):
    """
    Takes in a node of a binary search tree and find the inorder successor of
    the node.

    """
    # check that tree has at least 1 root node
    root = tree.get_root()
    if root is None:
        return
    # set a reference to the last element of the tree
    # to handle last element
    last = root
    while last.right is not None:
        last = last.right
    if last.data is data:
        return "%d is last element therefore has no successor." % data

    # check that node exists in tree
    if tree.lookup(root, data) is not None:
        node = tree.lookup(root, data)

    # if x has a right child, successor is the leftmost node in the right
    # branch
    if node.right is not None:
        child = node.right
        while child.left is not None:
            child = child.left
        return child.data
    else:
        # node is a left child, we return control to the parent node
        if node.parent.left is node:
            # if node is a left child of parent, by in-order traversal, parent
            # is the successor
            return node.parent.data
        else:
            # if node is right child, this branch of tree has been fully
            # visited, we return control to the parent node of which this left
            # branch ends
            while node.parent is not None:
                temp = node
                node = node.parent
                if node.left is temp:
                    # parent node now has a fully visited left child, this
                    # parent is the successor
                    break
            return node.data


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
    tree.print_inorder(root)
    print "\n"
    print inorder_successor(tree, 1)
    print inorder_successor(tree, 3)
    print inorder_successor(tree, 4)
    print inorder_successor(tree, 6)
    print inorder_successor(tree, 7)
    print inorder_successor(tree, 8)
    print inorder_successor(tree, 10)
    print inorder_successor(tree, 13)
    print inorder_successor(tree, 14)

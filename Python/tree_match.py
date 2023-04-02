# You have two very large binary trees: T1 with millions of nodes, and T2,
# with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of
# T1.
from ADT.binary_search_tree_revisit import *


def tree_match(tree1, tree2):
    """
    Find the preorder and inorder sequence for both trees and store each
    sequence in a string. Compare the substring of tree2 to tree1.
    Return true if tree2 string is substring of tree1 for both preorder and
    inorder sequence.

    """
    root1 = tree1.get_root()
    preorder_t1 = to_string(preorder(root1))
    inorder_t1 = to_string(inorder(root1))

    root2 = tree2.get_root()
    preorder_t2 = to_string(preorder(root2))
    inorder_t2 = to_string(inorder(root2))

    return preorder_t2 in preorder_t1 and inorder_t2 in inorder_t1


def to_string(traversal_method):
    result = ""
    for value in traversal_method:
        result += "#" + value
    return result


def preorder(node):
    yield str(node.data)
    if node.left is not None:
        for value in preorder(node.left):
            yield value
    if node.right is not None:
        for value in preorder(node.right):
            yield value


def inorder(node):
    if node.left is not None:
        for value in inorder(node.left):
            yield value
    yield str(node.data)
    if node.right is not None:
        for value in inorder(node.right):
            yield value

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

    tree2 = BinarySearchTree(6)
    tree2.insert(4)
    tree2.insert(7)
    print tree_match(tree, tree2)

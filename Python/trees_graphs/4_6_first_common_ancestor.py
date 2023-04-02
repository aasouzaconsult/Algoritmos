# Design an algorithm and write code to find the first common ancestor of two
# nodes in a binary tree. Avoid storing additional nodes in a data structure.
# NOTE: This is not necessarily a binary search tree.

import binary_search_tree


def first_common_ancestor(tree, node1, node2):
    """

    Find the first common ancestor between node1 and node2. Return None if
    node such node exists

    """
    if node1 is None or node2 is None:
        return None
    ancestors = []
    curr = node1
    while curr is not None:
        ancestors.append(curr)
        curr = curr.parent
    curr = node2
    while curr is not None:
        if curr in ancestors:
            return curr
        curr = curr.parent
    return curr.data

if __name__ == "__main__":
    tree = binary_search_tree.BinarySearchTree(25)
    tree.insert(15)
    tree.insert(50)
    tree.insert(10)
    tree.insert(22)
    tree.insert(35)
    tree.insert(70)
    tree.insert(4)
    tree.insert(12)
    tree.insert(18)
    tree.insert(24)
    tree.insert(31)
    tree.insert(44)
    tree.insert(66)
    tree.insert(90)
    print first_common_ancestor(tree, tree.lookup(31), tree.lookup(66))  # 50

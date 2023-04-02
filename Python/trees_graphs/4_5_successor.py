# Write an algorithm to find the 'next' node (ie. in-order successor) of a
# given node in a binary search tree where each node has a link to its parent.

import binary_search_tree


def successor(tree, data):
    node = tree.lookup(data)
    if tree.maximum(tree.get_root()) == data:
        return None
    if node.right is not None:
        return tree.minimum(node.right)
    else:
        while node == node.parent.right:
            node = node.parent
        return node.parent.data

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
    # tree.inorder(tree.get_root(), tree.print_data)
    # 4 10 12 15 18 22 24 25 31 35 44 50 66 70 90
    print successor(tree, 4)
    print successor(tree, 10)
    print successor(tree, 12)
    print successor(tree, 15)
    print successor(tree, 18)
    print successor(tree, 22)
    print successor(tree, 24)
    print successor(tree, 25)
    print successor(tree, 31)
    print successor(tree, 35)
    print successor(tree, 44)
    print successor(tree, 50)
    print successor(tree, 66)
    print successor(tree, 70)
    print successor(tree, 90)

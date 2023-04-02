# You are given a binary tree in which each node contains a value. Design an
# algorithm to print all paths which sum up to that value. Note that it can
# be any paths in the tree - it does not have to start at the root.
# assume the node has a parent link to its parent

from ADT.binary_search_tree_revisit import *


def find_sum_paths(tree, value):
    # check tree has at least a root node
    root = tree.get_root()
    if root is None:
        return
    # initialize result as 2d list of paths
    result = []

    # iteratively traverse the node in preorder sequence
    # for each node
    #   add current value to current_sum variable
    #   if current_sum variable is equal to value, append the current_nodes to
    #   result
    #   elif current_sum bigger than value, do nothing and continue
    #   else (current_sum smaller than value), add this node's parent value to
    #   current_sum and check previous again

    # iterative preorder traversal of the tree
    node_stack = [root]
    current_sum = 0
    current_nodes = []

    while len(node_stack) > 0:
        node = node_stack.pop()

        if node.data == value:
            result.append([node.data])
            continue
        trav = node
        while trav is not None:
            if current_sum < value:
                current_nodes.append(trav.data)
                current_sum += trav.data
                trav = trav.parent
            else:
                break
        if current_sum == value:
            result.append(current_nodes)
        current_sum = 0
        current_nodes = []

        # right child is pushed before left child to make sure that left
        # subtree is process first
        if node.right is not None:
            node_stack.append(node.right)
        if node.left is not None:
            node_stack.append(node.left)
    return result


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
    tree.print_preorder(root)
    print find_sum_paths(tree, 13)
    test()

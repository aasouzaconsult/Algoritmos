# You are given a binary tree in which each node contains a value. Design an
# algorithm to print all paths which sum up to that value. Note that it can be
# any path in the tree - it does not have to start at the root.

import binary_search_tree


def paths(tree, value):
    stack = []
    result = []
    curr = tree.get_root()
    while curr is not None or len(stack) > 0:
        if curr is not None:
            stack.append(curr)
            curr = curr.left
        else:
            curr = stack.pop()
            path = sum_path(curr, value)
            if len(path) > 0:
                result.append(path)
            curr = curr.right
    return result


def sum_path(node, value):
    result = []
    adds = 0
    while node is not None and adds < value:
        adds += node.data
        result.append(node.data)
        node = node.parent
    if adds == value:
        return result
    else:
        return []

if __name__ == "__main__":
    tree1 = binary_search_tree.BinarySearchTree(25)
    tree1.insert(15)
    tree1.insert(50)
    tree1.insert(10)
    tree1.insert(22)
    tree1.insert(35)
    tree1.insert(70)
    tree1.insert(4)
    tree1.insert(12)
    tree1.insert(18)
    tree1.insert(24)
    tree1.insert(31)
    tree1.insert(44)
    tree1.insert(66)
    tree1.insert(90)
    print paths(tree1, 40)

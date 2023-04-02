# You have two very large binary trees: T1, with millions of nodes, and T2,
# with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of
# T1.

import binary_search_tree


def is_subset(tree1, tree2):
    """

    Return True if tree2 is a subtree of tree1, False otherwise.

    """
    list1 = inorder_list(tree1)
    list2 = inorder_list(tree2)
    return "".join(map(str, list2)) in "".join(map(str, list1))


def inorder_list(tree):
    stack = []
    result = []
    curr = tree.get_root()
    while curr is not None or len(stack) > 0:
        if curr is not None:
            stack.append(curr)
            curr = curr.left
        else:
            curr = stack.pop()
            result.append(curr.data)
            curr = curr.right
    return result

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
    #tree1.inorder(tree1.get_root(), tree1.print_data)

    tree2 = binary_search_tree.BinarySearchTree(10)
    tree2.insert(4)
    tree2.insert(12)

    print is_subset(tree1, tree2)

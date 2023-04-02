#T1:
#
#    A
#  / | \
# B  C  D
#
#T2:
#
#    X
#  / | \
# M  C  Q
# |     |
# B     D
#
#Leaves of T1: BCD
#Leaves of T2: BCD

# write a function that determines whether the two trees have identical
# leaf nodes.
# left to right order
# max height = 10
# any number of childs

# Node class for node structure
# Tree class
# insertion
# L1 = [B,C,D]
# L2 = [B,C,D]
# L1 == L2 then True, otherwise False
# Time complexity = O(n)


def is_identical(tree1, tree2):
    # trees check
    if tree1.root is None or tree2.root is None:
        return False
    # traverse tree1 and store all leaf nodes in a list
    trav1 = tree1.root
    list1 = visit_node(trav1)

    # traverse tree2 and store all leaf nodes in a list
    trav2 = tree2.root
    list2 = visit_node(trav2)

    # compare 2 lists
    # same list return true
    # different list return false
    if list1 is list2:
        return True
    return False


def visit_node(node):
    """
    Take in a node object and a list to store the leaf node data and return the
    list of all leaf node data stemming from node.
    The function traverses every unique path
    """
    # declare a list to store leaf node data
    a_list = []
    if node.left is not None:
        a_list = visit_node(node.left)
    if node.right is not None:
        a_list += visit_node(node.right)

    # leaf node
    if node.left is None and node.right is None:
        a_list.append(node.data)
    return a_list

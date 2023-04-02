# Given a sorted(increasing order) array, write an algorithm to create a binary
# tree with minimal height.

from ADT.binary_search_tree_revisit import *


def array_to_tree(sorted_list):
    # check if list has at least 1 index
    if len(sorted_list) < 1:
        return
    # sort the list if it's not already sorted
    sorted_list = sorted(sorted_list)

    return recur_array_to_tree(sorted_list, 0, len(sorted_list)-1)


def recur_array_to_tree(sorted_list, start, end):
    """
    Recursively add array index values to tree.

    """
    if end < start:
        return None
    mid = int((start + end)/2)
    print (start + end)/2
    print "start:%d end:%d" % (start, end)
    print mid
    node = Node(sorted_list[mid])
    node.left = recur_array_to_tree(sorted_list, start, mid-1)
    node.right = recur_array_to_tree(sorted_list, mid+1, end)
    return node

if __name__ == "__main__":
    array_to_tree([3, 2, 6, 8, 1])
    tree = BinarySearchTree(3)

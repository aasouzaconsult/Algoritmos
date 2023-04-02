# Given a sorted array, write an algorithm to create a binary tree with minimal
# height.

import binary_tree


def insert(array, start, end):
    """
    Algorithm:
    1. Insert into tree the middle element of array.
    2. Insert into left subtree the left subarry elements
    3. Insert into right subtree the right subarray elements.

    """
    if end < start:
        return None
    mid = (start + end) / 2
    node = binary_tree.Node(array[mid])
    node.left = insert(array, start, mid)
    node.right = insert(array, mid + 1, end)
    return node

##################################
### Title: CheckBalanced Tree ####
### Author: GuoChen Hou   ########
##################################

# Implement a function to check if a tree is balanced. For the purposes
# of this question, a balanced tree is defined to be a tree such that no
# two leaf nodes differ in distance from the root by more than one.
# ie. Tree has a maximum height of 3.

# A tree is only balanced if:
# 1. the left and right subtrees heights differ by at most one,
# 2. the left subtree is balanced
# 3. the right subtree is balanced

from ADT.BinaryTree import BinaryTree


def is_balanced_tree(root):
    """
    Checks if a tree with root node 'root' is a balanced tree.
    @return True if balanced tree, False otherwise
    """

    if root is None:
        return True
    else:
        left_depth = BinaryTree.max_depth(root.left)
        right_depth = BinaryTree.right_depth(root.right)
        if left_depth - right_depth > 1 or right_depth - left_depth > 1:
            return False
    return True

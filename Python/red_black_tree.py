#!/usr/bin/python
# -*- coding: utf-8 -*-

##################################
### Title: Red black tree ########
### Author: GuoChen Hou   ########
##################################

# Implementation of a red black tree which subclasses a BinarySearchTree
#
# BinarySearchTree Operations
#
# Public operations:
# __init__(): Initializes the data members
# insert(data): Insert a new node with data into the tree
# delete(root, data): Removes a node with its data value 'data'
# find(root, data): Find a value in the tree, return none if value is not found
# size(root): Return the total number of nodes in the tree
# max_depth(root): Return the height of the tree
# min(root): Finds the minimum value in the tree
# max(root): Finds the maximum value in the tree
# has_value(root, data): Find the value 'data' in the tree. Return true if
#                       value is found false otherwise.
# print_tree_inorder(): Prints the tree path by in-order traversal
# print_tree_preorder(): Prints the tree path by preorder traversal
# print_tree_postorder(): Prints the tree path by postorder traversal


from ADT.BinarySearchTree import Node, BinarySearchTree


class RedBlackNode(Node):
    """
    Node data structure for a red black tree.
    """

    def __init__(self, data, red=True):
        super(RedBlackNode, self).__init__(data)
        self.red = red

    def __str__(self):
        """String representation."""
        return str(self.data)


class RedBlackTree(BinarySearchTree):
    """
    A red-black binary balanced tree that uses Node structure.
    """

    def __init__(self):
        """
        Initialize the root member
        """

        super(RedBlackTree, self).__init__()

# PUBLIC METHODS

    def insert(self, data):
        """
        Inserts the value data into a binary tree with root 'root'.

        If tree is empty, root is None.
        @return: the root of the tree containing the new node.
        """

        new_node = RedBlackNode(data)
        self.insert_node(new_node)

    def insert_node(self, node):
        """
        Insert node into tree.
        """

        parent = None
        current = self.root
        while current is not None:
            parent = current
            if node.data < current.data:
                current = current.left
            else:
                current = current.right
        node.parent = parent

        if parent is None:
            self.root = node
        elif node.data < parent.data:
            parent.left = node
        else:
            parent.right = node

        self._insert_fixup(node)

    def check_invariants(self):
        """
        @return: True if satisfies all criteria to be red black tree.
        """

        def is_search_tree(node):
            if node is not None and node is not self.nil:
                if node.left is not self.nil:
                    assert(node.left.key <= node.key)
                    is_search_tree(node.left)
                if node.right is not self.nil:
                    assert(node.right.key >= node.key)
                    is_search_tree(node.right)

        def is_red_black_node(node):
            """
            @return: the number of black nodes on the way to the leaf.
            (node does not count)
            """
            # check has left and right or neither
            assert not ((node.left and not node.right) or
                        (node.right and not node.left))

            # leaves have to be black
            assert not ((not node.left and not node.right) and node.red)

            # if node is red, check children are black
            if node.red and node.left and node.right:
                assert not (node.left.red or node.right.red)

            # has the current node a left child?
            if node.left or node.right:
                # check children's parents are correct
                assert not (self.nil is not node.right and
                            node is not node.right.p)
                assert not (self.nil is not node.left and
                            node is not node.left.p)

                # check if children are ok
                left_counts = is_red_black_node(node.left)
                right_counts = is_red_black_node(node.right)

                if not node.left.red:
                    left_counts += 1
                if not node.right.red:
                    right_counts += 1

                # check children's counts are ok
                if left_counts != right_counts:
                    print "Child counts are not the same."
                assert left_counts == right_counts
                return left_counts
            return 0

        is_search_tree(self.root)
        is_red_black_node(self.root)
        return not self.root.red

# PRIVATE METHODS

    def _insert_fixup(self, node):
        """
        Restore red-black properties after insert.
        """

        while node.parent.red:  # if node's parent is red
            # if node's parent is a left child
            if node.parent is node.parent.parent.left:
                parent_sibling = node.parent.parent.right

                if parent_sibling.red:  # parent sibling red
                    node.parent.red = False
                    parent_sibling.red = False
                    node.parent.parent.red = True
                    node = node.parent.parent
                else:  # parent sibling black
                    if node is node.parent.right:
                        node = node.parent
                        self._left_rotate(node)
                    node.parent.red = False
                    node.parent.parent.red = True
                    self._right_rotate(node.parent.parent)
            else:
                parent_sibling = node.parent.parent.left
                if parent_sibling.red:
                    node.parent.red = False
                    parent_sibling.red = False
                    node.parent.parent.red = True
                    node = node.parent.parent
                else:
                    if node is node.parent.left:
                        node = node.parent
                        self._right_rotate(node)
                    node.parent.red = False
                    node.parent.parent.red = True
                    self._left_rotate(node.parent.parent)
        self.root.red = False

    def _left_rotate(self, node):
        """
        Left rotate at node.
        """
        #      W                                  S
        #     / \        Right-Rotate(S,W)       / \
        #    /   \           -------->          /   \
        #   S     Y                            G     W
        #  / \               <--------              / \
        # /   \          Left-Rotate(W,S)          /   \
        #G     U                                  U     Y

        child = node.right
        node.right = child.left

        if child.left is not None:
            child.left.parent = node
        child.parent = node.parent

        if node.parent is None:
            self.root = child
        elif node is node.parent.left:  # node is left child
            node.parent.left = child
        else:
            node.parent.right = child
        child.left = node
        node.parent = child

    def _right_rotate(self, node):
        """
        Right rotate at node.
        """

        child = node.left
        node.left = child.right

        if child.right is not None:
            child.right.parent = node
        child.parent = node.parent

        if node.parent is not None:
            self.root = child
        elif node is node.parent.right:  # node is right child
            node.parent.right = child
        else:
            node.parent.left = child
        child.right = node
        node.parent = child

    def _is_red(self, node):
        """
        @Return: True if node is red, else return False.
        """

        if node is not None:
            return node.red
        return False

if __name__ == "__main__":
    test = RedBlackTree()
    test.insert(8)
    test.insert(3)
    test.insert(10)
    test.insert(1)
    test.insert(6)
    test.insert(4)
    test.insert(7)
    test.insert(14)
    test.insert(13)
    test.print_tree_inorder(test.root)
    print "--"
    test.print_tree_preorder(test.root)
    print "--"
    test.print_tree_postorder(test.root)
    print "--"
    test.delete(test.root, 3)
    print "--"
    test.print_tree_inorder(test.root)
    print test.size(test.root)
    print test.max_depth(test.root)

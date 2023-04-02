# Implementation of binary search tree with node structure.
from collections import deque


class Node(object):
    """

    Node structure for binary search tree.

    """
    def __init__(self, data, left=None, right=None, parent=None):
        self.data = data
        self.left = left
        self.right = right
        self.parent = parent

    def __str__(self):
        return "Node with data: %d" % self.data


class BinarySearchTree(object):
    """

    BinarySearchTree class implements a binary search tree.

    """
    def __init__(self, data):
        self.root = Node(data)

# PUBLIC METHODS
    def get_root(self):
        return self.root

    def successor(self, data):
        """

        Get the next largest data after given *data* by in-order traversal.

        """
        if data == self.maximum(self.root):
            return None
        node = self.lookup(data)
        if node.right is not None:
            return self.minimum(node.right)
        parent = node.parent
        while parent is not None and node is parent.right:
            node = parent
            parent = parent.parent
        return parent.data

    def predecessor(self, data):
        if data == self.minimum(self.root):
            return None
        node = self.lookup(data)
        if node.left is not None:
            return self.maximum(node.left)
        parent = node.parent
        while parent is not None and node is parent.left:
            node = parent
            parent = parent.parent
        return parent.data

    def minimum(self, node):
        """

        Retrieve the minimum data in the tree.

        """
        curr = node
        while curr.left is not None:
            curr = curr.left
        return curr.data

    def minimum_recursive(self, node):
        if node.left is not None:
            return self.minimum_recursive(node.left)
        else:
            return node.data

    def maximum(self, node):
        """

        Retrieve the maximum data in the tree.

        """
        curr = node
        while curr.right is not None:
            curr = curr.right
        return curr.data

    def maximum_recursive(self, node):
        if node.right is not None:
            return self.maximum_recursive(node.right)
        else:
            return node.data

    def lookup(self, data):
        return self._lookup(self.root, data)

    def insert(self, data):
        """

        Wrapper to insert operation.

        """
        if self.root is None:
            self.root = Node(data)
        else:
            new_node = Node(data)
            self._insert(self.root, new_node)
        return self.root

    def delete(self, data):
        """

        Remove node with data in the tree and return the root. if data node
        does not exist, return None.

        """
        # check root is not none
        if self.root is None:
            return None
        # lookup node to make sure it exists
        node = self.lookup(data)
        if node is None:
            return None
        # initialize shortcut vars
        parent = node.parent
        left = node.left
        right = node.right
        # case 1: 0 child node
        if left is None and right is None:
            # node is left child
            if parent.left == node:
                parent.left = None
            else:  # node is right child
                parent.right = None
            node = None
        # case 2: 1 child node
        elif right is None:  # node has a left child
            # node is a left child of its parent
            if parent.left is node:
                parent.left = left
                left.parent = parent
            else:  # node is a right child of its parent
                parent.right = left
                left.parent = parent
            node = None
        elif left is None:  # node has a right child
            # node is a right child of its parent
            if parent.right is node:
                parent.right = right
                right.parent = parent
            else:  # node is a left child of its parent
                parent.left = right
                right.parent = parent
            node = None
        # case 3: 2 child nodes
        else:
            temp_data = self._min_node(node).data
            self.delete(temp_data)
            node.data = temp_data
        # return root
        return self.root

    def print_data(self, node):
        print node.data,
        return

    def preorder(self, node, callback):
        if node is None:
            return
        callback(node)
        self.preorder(node.left, callback)
        self.preorder(node.right, callback)
        return

    def inorder(self, node, callback):
        if node is None:
            return
        self.inorder(node.left, callback)
        callback(node)
        self.inorder(node.right, callback)

    def inorder_iterative(self):
        stack = []
        curr = self.root
        while curr is not None or len(stack) > 0:
            if curr is not None:
                stack.append(curr)
                curr = curr.left
            else:
                curr = stack.pop()
                print curr.data,
                curr = curr.right
        return

    def postorder(self, node, callback):
        if node is None:
            return
        self.postorder(node.left, callback)
        self.postorder(node.right, callback)
        callback(node)

    def levelorder(self, node, callback):
        if node is None:
            return
        queue = deque([node])
        while len(queue) > 0:
            curr = queue.popleft()
            callback(curr)
            if curr.left is not None:
                queue.append(curr.left)
            if curr.right is not None:
                queue.append(curr.right)

# PRIVATE METHODS
    def _min_node(self, node):
        """

        Find the minimum data starting from node.

        """
        while node.left is not None:
            node = node.left
        return node

    def _lookup(self, node, data):
        if data == node.data:
            return node
        elif data < node.data:
            return self._lookup(node.left, data)
        else:
            return self._lookup(node.right, data)

    def _insert(self, root, node):
        """

        Insert node to the tree/sub-tree with root as *root*.

        """
        if node.data < root.data:
            # node goes left
            if root.left is None:
                root.left = node
                node.parent = root
            else:
                self._insert(root.left, node)
        else:
            # node goes right
            if root.right is None:
                root.right = node
                node.parent = root
            else:
                self._insert(root.right, node)
        return


if __name__ == "__main__":
    tree = BinarySearchTree(25)
    root = tree.get_root()
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
    tree.preorder(root, tree.print_data)
    print ""
    tree.inorder(root, tree.print_data)
    print ""
    tree.inorder_iterative()
    print ""
    tree.postorder(root, tree.print_data)
    print ""
    tree.levelorder(root, tree.print_data)
    print ""
    print tree.lookup(50)
    print tree.lookup(12)
    print tree.lookup(18)
    print tree.lookup(90)
    tree.preorder(root, tree.print_data)
    print ""
    print tree.successor(90)
    print tree.predecessor(90)
    print tree.minimum_recursive(tree.root)
    print tree.maximum_recursive(tree.root)

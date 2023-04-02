from collections import deque


class Node(object):
    """

    Node structure for binary search tree.

    """
    def __init__(self, data=None, left=None, right=None, parent=None):
        self.data = data
        self.left = left
        self.right = right
        self.parent = parent


class BinarySearchTree(object):
    """

    Implementation of binary search tree with Node structure.

    """

    def __init__(self, data=None):
        self.root = Node(data)

# PUBLIC METHODS

    def get_root(self):
        return self.root

    def minimum(self, node):
        curr = node
        while curr.left is not None:
            curr = curr.left
        return curr.data

    def maximum(self, node):
        curr = node
        while curr.right is not None:
            curr = curr.right
        return curr.data

    def lookup(self, data):
        """

        Lookup data node starting from root and return the node reference if
        found, return None otherwise.

        """
        return self._lookup(self.root, data)

    def insert(self, data):
        """

        Insert new node with data into binary search tree. If data is less than
        root, node is a left child, else node is right child. Recursively
        insert new node until a leaf node is found.

        """
        if self.root.data is None:
            self.root.data = data
        else:
            new_node = Node(data)
            self._insert(self.root, new_node)
        return self.root

    def delete(self, data):
        """

        Remove node with data in the tree and return the root. if data node
        does not exist, return none.

        """
        if self.root is None:
            return
        node = self.lookup(data)
        if node is None:
            return
        parent = node.parent
        left_child = node.left
        right_child = node.right
        # case 1: 0 child node
        if left_child is None and right_child is None:
            # node is left child
            if parent.left == node:
                parent.left = None
            else:  # node is right child
                parent.right = None
            node = None
        # case 2: 1 child node
        elif right_child is None:  # node has a left child
            if parent.left is node:
                # deleting node is a left child of its parent
                parent.left = left_child
                left_child.parent = parent
            else:
                # deleting node is a right child of its parent
                parent.right = left_child
                left_child.parent = parent
            node = None
        elif left_child is None:  # node has a right child
            if parent.right is node:
                # deleting node is a right child of its parent
                parent.right = right_child
                right_child.parent = parent
            else:
                # deleting node is a left child of its parent
                parent.left = right_child
                right_child.parent = parent
            node = None
        # case 3: 2 child node
        else:
            temp_data = self._min_node(node).data
            self.delete(temp_data)
            node.data = temp_data
        return node

    def successor(self, data):
        """

        Return the successor of data in the tree.

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
        """

        Return the predecessor of data in the tree.

        """
        node = self.lookup(data)
        if node.left is not None:
            return self.maximum(node.left)
        parent = node.parent
        while parent is not None and node is parent.left:
            node = parent
            parent = parent.parent
        return parent.data

    def print_preorder(self, node):
        if node is None:
            return
        print node.data,
        self.print_preorder(node.left)
        self.print_preorder(node.right)
        return

    def print_inorder(self, node):
        if node is None:
            return
        self.print_inorder(node.left)
        print node.data,
        self.print_inorder(node.right)

    def print_postorder(self, node):
        if node is None:
            return
        self.print_postorder(node.left)
        self.print_postorder(node.right)
        print node.data,

    def print_levelorder(self, node):
        """
        Print the tree by level order traversal method.

        """
        if node is None:
            return
        queue = deque([node])
        while len(queue) > 0:
            curr = queue.popleft()
            print curr.data,
            if curr.left is not None:
                queue.append(curr.left)
            if curr.right is not None:
                queue.append(curr.right)
        return

    def max_depth(self, node):
        if node is None:
            return 0
        return 1 + max(self.max_depth(node.left), self.max_depth(node.right))

    def min_depth(self, node):
        if node is None:
            return 0
        return 1 + min(self.min_depth(node.left), self.min_depth(node.right))

    def print_root_to_leaf_paths(self, node):
        path = [None for _ in xrange(self.max_depth(self.root))]
        self.print_path_recurs(node, path, 0)

    def print_path_recurs(self, node, path, height):
        if node is None:
            return
        path[height] = node.data
        height += 1
        if node.left is None and node.right is None:
            print path
        else:
            self.print_path_recurs(node.left, path, height)
            self.print_path_recurs(node.right, path, height)

# PRIVATE METHODS

    def _lookup(self, node, data):
        """

        Recursively lookup data starting from node.

        """
        if node.data == data:
            return node
        elif data < node.data:
            return self._lookup(node.left, data)
        else:
            return self._lookup(node.right, data)

    def _insert(self, root, new_node):
        """

        insert new_node to tree with root.

        """
        if new_node.data < root.data:
            # left child
            if root.left is None:
                root.left = new_node
                new_node.parent = root
            else:
                self._insert(root.left, new_node)
        else:
            # right child
            if root.right is None:
                root.right = new_node
                new_node.parent = root
            else:
                self._insert(root.right, new_node)
        return

    def _min_node(self, node):
        """

        Find the minimum data node starting from node.

        """
        while node.left is not None:
            node = node.left
        return node

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
    tree.print_levelorder(root)
    print "\n"
    tree.print_preorder(root)
    print "\n"
    tree.print_inorder(root)
    print "\n"
    tree.print_postorder(root)
    print "\n"
    tree.print_levelorder(root)
    print "\n"
    print tree.lookup(31).data
    print "\n"
    tree.print_levelorder(root)
    print "\n"
    print tree.minimum(root)
    print tree.maximum(root)
    print tree.successor(90)
    print tree.predecessor(15)
    tree.print_root_to_leaf_paths(root)

class Node(object):
    """

    Node structure for a red black tree.

    """
    def __init__(self, data=None, black=True, left=None, right=None):
        self.data = data
        self.black = black
        self.left = left
        self.right = right
        self.parent = None

    def set_data(self, data):
        self.data = data
        return

    def get_data(self):
        return self.data


class RBTree(object):
    """

    A balanced tree implemented with a red black tree.

    """
    def __init__(self, data=None):
        """

        Initialize root node to be black.

        """
        self.nil = Node(None, True)
        self.root = Node(data, True, self.nil, self.nil)
        self.root.parent = self.nil

    def get_root(self):
        return self.root

    def insert(self, data):
        """

        Insert *data* node into red black tree.

        """
        node = Node(data, False, self.nil, self.nil)
        parent = self.nil
        curr = self.root
        while curr is not self.nil:
            parent = curr
            if node.data < curr.data:
                curr = curr.left
            else:
                curr = curr.right
        node.parent = parent
        if parent is self.nil:
            self.root = node
        elif node.data < parent.data:
            parent.left = node
        else:
            parent.right = node
        self.fix_tree(node)
        return

    def fix_tree(self, node):
        """

        Recolor nodes and perform left/right rotations.
        This fix maintains the properties of a red black tree.
        red black tree properties:
        1. every node is either red or black
        2. the root is black
        3. every leaf is black
        4. if a node is red, then its children are black
        5. for each node, all simple paths from the node to
            descendant leaves contain the same number of black nodes.

        """
        while node.parent.black is False:
            print "THIS RUNS"
            if node.parent == node.parent.parent.left:
                # node's parent is a left child of ancestor node
                uncle = node.parent.parent.right
                # case 1
                if uncle.black is False:
                    node.parent.black = True
                    uncle.black = True
                    node.parent.parent.black = False
                    node = node.parent.parent
                else:
                    # case 2
                    if node == node.parent.right:
                        # node is right child
                        node = node.parent
                        self._left_rotate(node)
                    # case 3
                    node.parent.black = True
                    node.parent.parent.black = False
                    self._right_rotate(node.parent.parent)
            else:
                print "THIS RUNS 2"
                # node parent is a right child of grandparent
                uncle = node.parent.parent.left

                # case 1
                if uncle.black is False:
                    node.parent.black = True
                    uncle.black = True
                    node.parent.parent.black = False
                    node = node.parent.parent
                else:
                    print "THIS RUNS 3"
                    # case 2
                    if node == node.parent.left:
                        print "THIS RUNS 4"
                        # node is left child
                        node = node.parent
                        self._right_rotate(node)
                    node.parent.black = True
                    node.parent.parent.black = False
                    self._left_rotate(node.parent.parent)
        self.root.black = True
        return

    def delete(self, data):
        pass

    def delete_fix_tree(self, node):
        pass

    def print_tree(self, node):
        print (node.data, node.black)
        return

    def preorder(self, node, callback):
        if node is self.nil:
            return
        callback(node)
        self.preorder(node.left, callback)
        self.preorder(node.right, callback)

    def inorder(self, node, callback):
        if node is self.nil:
            return
        self.inorder(node.left, callback)
        callback(node)
        self.inorder(node.right, callback)

    def postorder(self, node, callback):
        if node is self.nil:
            return
        self.postorder(node.left, callback)
        self.postorder(node.right, callback)
        callback(node)

    def levelorder(self, node, callback):
        if node is self.nil:
            return
        queue = [node]
        while len(queue) > 0:
            curr = queue.pop(0)
            callback(curr)
            if curr.left is not self.nil:
                queue.append(curr.left)
            if curr.right is not self.nil:
                queue.append(curr.right)

# PRIVATE METHODS

    def _insert(self, root, node):
        if node.data < root.data:
            # node goes left
            if root.left is self.nil:
                root.left = node
                node.parent = root
            else:
                self._insert(root.left, node)
        else:
            # node goes right
            if root.right is self.nil:
                root.right = node
                node.parent = root
            else:
                self._insert(root.right, node)
        return

    def _left_rotate(self, node):
        """

        Left rotate transforms the configuration of *node* and *node.right*
        into its left counterpart where *node.right* becomes the parent of
        *node* and *node* is the left child of *node.right*.

        """
        # set reference to right node
        right = node.right
        # set node's right child to right ref's left child
        node.right = right.left
        print "THIS RUNS 5"
        # set right ref's left child's parent to node
        if right.left is not self.nil:
            right.left.parent = node
        # set right ref's parent to node's parent
        right.parent = node.parent
        # set root to right if node is a root
        if node.parent is self.nil:
            self.root = right
        elif node.parent.left == node:
            # node is a left child of its parent
            node.parent.left = right
        else:
            # node is a right child of its parent
            node.parent.right = right
        right.left = node
        node.parent = right
        return

    def _right_rotate(self, node):
        """

        Right rotate transforms the configuration of *node* and *node.left*
        into its right counterpart where *node.left* becomes the parent of
        *node* and *node* if the right child of *node.left*.

        """
        # set reference to left node
        left = node.left
        # set node's left child to left ref's right child
        node.left = left.right
        # set left ref's right child's parent to node
        if left.right is not self.nil:
            left.right.parent = node
        # set left ref's parent to node's parent
        left.parent = node.parent
        # set root to left if node is a root
        if node.parent is self.nil:
            self.root = left
        elif node.parent.left == node:
            # node is a left child of its parent
            node.parent.left = left
        else:
            # node is a right child of its parent
            node.parent.right = left
        left.right = node
        node.parent = left
        return

if __name__ == "__main__":
    rb_tree = RBTree(1)
    rb_tree.insert(2)
    rb_tree.insert(3)
    rb_tree.insert(4)
    rb_tree.insert(5)
    rb_tree.insert(6)
    rb_tree.insert(7)
    rb_tree.insert(8)
    rb_tree.insert(9)
    rb_tree.insert(10)
    rb_tree.levelorder(rb_tree.get_root(), rb_tree.print_tree)

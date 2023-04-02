from collections import deque

# Basic Binary Search Tree implementation

# BST operations:
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


class Node(object):
    """
    Node data structure for BST.

    """
    def __init__(self, data=None, left=None, right=None):
        """
        Initialize data members: data, left, right

        """
        self.data = data
        self.left = left
        self.right = right


class BST(object):
    """
    Binary search tree with node structure.

    """
    def __init__(self, data=None):
        """
        Initialize root node.

        """
        self.root = Node(data=data)

# PUBLIC METHODS

    def get_root(self):
        """
        Return a reference to root node.

        """
        return self.root

    def insert(self, data):
        """
        Inserts the value data into tree with root node.
        If data is not present, return None.

        """
        if self.root.data is None:
            self.root.data = data
        else:
            # add a node with data into tree
            new_node = Node(data)
            self._add_node(self.root, new_node)
        return self.root

    def find(self, root, data):
        """
        Find the value 'data' in the tree with root node. Return the data node
        reference if found, else return None

        """
        if root is None:
            return None
        else:
            if data == root.data:
                return root
            else:
                if data < root.data:
                    return self.find(root.left, data)
                else:
                    return self.find(root.right, data)

    def has_value(self, root, data):
        if self.find(root, data) is not None:
            return True
        return False

    def delete(self, data):
        """
        Wrapper function to delete a node with data.

        @param data node with data to be deleted.
        @return root root node or null if data node does not exist

        """
        if not self.has_value(self.root, data):
            # data does not exist in tree
            return None
        self.root = self._rec_delete(self.root, data)
        return self.root

    def _rec_delete(self, root, data):
        """
        Find the node to delete and delete the node.

        @param root root node of the tree.
        @param data data value to which the node is to be deleted.
        @return root root node of the result tree.

        """
        if root is None or root.data == data:
            return self._delete_node(root)
        elif data < root.data:
            root.left = self._rec_delete(root.left, data)
        else:
            root.right = self._rec_delete(root.right, data)
        return root

    def _delete_node(self, root):
        """
        Delete the root node from tree.

        @param root node to be deleted.
        @return the new root node
        """
        to_remove = root
        if root is None:
            return None
        # case 0: 0 child
        # case 1: 1 child
        elif root.right is None:
            root = root.left
        elif root.left is None:
            root = root.right
        # case 2: 2 child
        else:
            parent = root
            to_remove = root.left
            while to_remove.right is not None:
                parent = to_remove
                to_remove = to_remove.right
            root.data = to_remove.data

            if parent == root:
                # left child node of root has no right child
                parent.left = to_remove.left
            else:
                # left child node of root has at least 1 right child
                parent.right = to_remove.left
        return root

    def print_preorder(self, node):
        """
        Print the tree in preorder traversal method.

        """
        if node is None:
            return
        print node.data,
        self.print_preorder(node.left)
        self.print_preorder(node.right)
        return

    def print_inorder(self, node):
        """
        Print the tree in inorder traversal method.

        """
        if node is None:
            return
        self.print_inorder(node.left)
        print node.data,
        self.print_inorder(node.right)
        return

    def print_postorder(self, node):
        """
        Print the tree in postorder traversal method.

        """
        if node is None:
            return
        self.print_postorder(node.left)
        self.print_postorder(node.right)
        print node.data,
        return

    def print_levelorder(self, node):
        """
        Print the tree in levelorder traversal method.

        """
        if node is None:
            return
        queue = deque([node])
        while len(queue) > 0:
            trav = queue.popleft()
            print trav.data,
            if trav.left is not None:
                queue.append(trav.left)
            if trav.right is not None:
                queue.append(trav.right)

    def breadth_first_search(self, data):
        """
        Search for data value in tree using breadth first search traversal
        algorithm.

        """
        if self.root is None:
            return
        queue = deque([self.root])
        while len(queue) > 0:
            node = queue.popleft()
            print node.data,
            if node.data == data:
                print "Data %d found." % data
                break
            if node.left is not None:
                queue.append(node.left)
            if node.right is not None:
                queue.append(node.right)
        return "Data %d not found in tree." % data

    def depth_first_search(self, data):
        """
        Search for data value in tree using depth first search traversal
        algorithm.
        Use a list as a stack.

        """
        if self.root is None:
            return
        # create a stack and push root to it
        stack = [self.root]

        #Pop all items one by one. Do following for every popped item
        #a) print it
        #b) push its right child
        #c) push its left child
        #Note that right child is pushed first so that left is processed first
        while len(stack) > 0:
            # pop item from stack and print it
            node = stack[-1]
            print node.data,
            stack.pop()

            if node.right is not None:
                stack.append(node.right)
            if node.left is not None:
                stack.append(node.left)

    def max_depth(self, root):
        """
        Find out the maxiumum depth of the tree.

        """
        if root is None:
            return 0
        return 1 + max(self.max_depth(root.left),
                       self.max_depth(root.right))

    def min_depth(self, root):
        """
        Find out the minimum depth of the tree.

        """
        if root is None:
            return 0
        return 1 + min(self.min_depth(root.left),
                       self.min_depth(root.right))

    def is_balanced(self, root):
        """
        Check if tree is a balanced tree.

        """
        max_height = self.max_depth(root)
        min_height = self.min_depth(root)
        return (max_height - min_height <= 1)
# PRIVATE METHODS

    def _add_node(self, root, node):
        """
        Recursive function to add node into tree with 'root' as root node.

        """
        if node.data < root.data:
            if root.left is None:
                root.left = node
            else:
                # node goes left
                self._add_node(root.left, node)
        else:
            if root.right is None:
                root.right = node
            else:
                # node goes right
                self._add_node(root.right, node)
        return

    def _lookup(self, root, data, parent=None):
        """
        Lookup node containing data

        @param root root node to tree
        @param data node data object to lookup
        @param parent node's parent
        @returns node and node's parent if found, or None, None

        """
        if data < root.data:
            if root.left is None:
                return None, None
            return self._lookup(root.left, data, root)
        elif data > root.data:
            if root.right is None:
                return None, None
            return self._lookup(root.right, data, root)
        else:
            return root, parent

if __name__ == "__main__":
    tree = BST(8)
    tree.insert(3)
    tree.insert(10)
    tree.insert(1)
    tree.insert(6)
    tree.insert(4)
    tree.insert(7)
    tree.insert(14)
    tree.insert(13)
    root = tree.get_root()
    tree.print_preorder(root)
    print "\n"
    tree.print_inorder(root)
    print "\n"
    tree.print_postorder(root)
    print "\n"
    tree.print_levelorder(root)
    print "\n"
    #tree.delete(1)
    #tree.print_levelorder(root)
    tree.depth_first_search(13)
    print tree.max_depth(root)
    print tree.min_depth(root)
    print tree.is_balanced(root)
    tree.delete(4)
    tree.delete(7)
    tree.delete(13)
    print tree.is_balanced(root)

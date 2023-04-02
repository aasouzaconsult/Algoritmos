class Node(object):
    """

    Node structure for Binary search tree nodes.

    """
    def __init__(self, data=None, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


class BinarySearchTree(object):
    """

    Implementation of binary search tree with node structure.

    """
    def __init__(self, data=None):
        self.root = Node(data)

    def get_root(self):
        return self.root

    def print_tree(self, node):
        print node.data,
        return

    def insert(self, data):
        if self.root.data is None:
            self.root.data = data
        else:
            node = Node(data)
            self._insert_node(self.root, node)

    def _insert_node(self, root, node):
        if node.data < root.data:
            if root.left is None:
                root.left = node
            else:
                self._insert_node(root.left, node)
        else:
            if root.right is None:
                root.right = node
            else:
                self._insert_node(root.right, node)
        return

    def search(self, data):
        trav = self.root
        while trav is not None:
            if trav.data == data:
                return trav
            elif data < trav.data:
                trav = trav.left
            else:
                trav = trav.right
        return

    def delete(self, data):
        if self.root is None:
            return
        parent, node = self._parent_child_set(data)
        if node is None:
            return
        # case 1: 0 child
        if node.left is None and node.right is None:
            if parent.left is node:
                parent.left = None
            else:
                parent.right = None
            node = None
        # case 2: node has left child
        elif node.right is None:
            if parent.left is node:
                parent.left = node.left
            else:
                parent.right = node.left
            node = None
        # case 2: node has right child
        elif node.left is None:
            if parent.left is node:
                parent.left = node.right
            else:
                parent.right = node.right
            node = None
        # case 3: node has 2 children
        else:
            leaf_node = self._min_node(node.right)
            temp = leaf_node.data
            self.delete(leaf_node.data)
            node.data = temp
        return

    def _min_node(self, node):
        while node.left is not None:
            node = node.left
        return node

    def _max_node(self, node):
        while node.right is not None:
            node = node.right
        return node

    def _parent_child_set(self, data):
        if self.root.data == data:
            return None, self.root
        parent = None
        trav = self.root
        while trav is not None:
            if trav.data == data:
                return parent, trav
            else:
                parent = trav
                if data < trav.data:
                    trav = trav.left
                else:
                    trav = trav.right
        return None, None

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
        return

    def postorder(self, node, callback):
        if node is None:
            return
        self.postorder(node.left, callback)
        self.postorder(node.right, callback)
        callback(node)
        return

    def levelorder(self, node, callback):
        if node is None:
            return
        queue = [node]
        while len(queue) > 0:
            trav = queue.pop(0)
            callback(trav)
            if trav.left is not None:
                queue.append(trav.left)
            if trav.right is not None:
                queue.append(trav.right)
        return

    def successor(self, data):
        node = self.search(data)
        if node is None:
            return
        if node.right is not None:
            return self._min_node(node.right).data
        else:
            trav_data = data
            while True:
                parent, node = self._parent_child_set(trav_data)
                if parent is None:
                    break
                if parent.left is node:
                    return parent.data
                else:
                    trav_data = parent.data
        return

    def predecessor(self, data):
        node = self.search(data)
        if node is None:
            return
        if node.left is not None:
            return self._max_node(node.left).data
        else:
            trav_data = data
            while True:
                parent, node = self._parent_child_set(trav_data)
                if parent is None:
                    break
                if parent.right is node:
                    return parent.data
                else:
                    trav_data = parent.data
        return

    def get_leaf_nodes(self, node, nodes):
        if node is None:
            return
        self.get_leaf_nodes(node.left, nodes)
        if node.left is None and node.right is None:
            nodes.append(node.data)
        self.get_leaf_nodes(node.left, nodes)
        return nodes

    def print_leaf_path(self, node, path):
        if node is None:
            return
        path.append(node.data)
        if node.left is None and node.right is None:
            print path
        else:
            self.print_leaf_path(node.left, path[:])
            self.print_leaf_path(node.right, path[:])
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
    print "preorder: ",
    tree.preorder(root, tree.print_tree)
    print ""
    print "inorder: ",
    tree.inorder(root, tree.print_tree)
    print ""
    print "postorder: ",
    tree.postorder(root, tree.print_tree)
    print ""
    print "levelorder: ",
    tree.levelorder(root, tree.print_tree)
    print ""
    print tree.search(15).data
    print tree.search(25).data
    print tree.search(4).data
    print tree.search(90).data
    print tree.search(243)
    print tree.successor(4)
    print tree.successor(10)
    print tree.successor(12)
    print tree.successor(15)
    print tree.successor(18)
    print tree.successor(22)
    print tree.successor(24)
    print tree.successor(25)
    print tree.successor(31)
    print tree.successor(35)
    print tree.successor(44)
    print tree.successor(50)
    print tree.successor(66)
    print tree.successor(70)
    print tree.successor(90)
    print "predecessors: "
    print tree.predecessor(90)
    print tree.predecessor(70)
    print tree.predecessor(66)
    print tree.predecessor(50)
    print tree.predecessor(44)
    print tree.predecessor(35)
    print tree.predecessor(31)
    print tree.predecessor(25)
    print tree.predecessor(24)
    print tree.predecessor(22)
    print tree.predecessor(18)
    print tree.predecessor(15)
    print tree.predecessor(12)
    print tree.predecessor(10)
    print tree.predecessor(4)
    tree.print_leaf_path(root, [])
    tree.delete(4)
    print "levelorder: ",
    tree.levelorder(root, tree.print_tree)
    print ""
    tree.delete(24)
    print "levelorder: ",
    tree.levelorder(root, tree.print_tree)
    print ""
    tree.delete(35)
    print "levelorder: ",
    tree.levelorder(root, tree.print_tree)
    print ""

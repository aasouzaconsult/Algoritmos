class Node(object):
    """

    Node structure for binary tree.

    """
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


class BinaryTree(object):
    """

    Binary tree with each node having Node structure.

    """
    def __init__(self, data, left=None, right=None):
        self.root = Node(data, left, right)

    def get_left_child(self, node=None):
        if node is not None:
            return node.left
        return self.root.left

    def get_right_child(self, node=None):
        if node is not None:
            return node.right
        return self.root.right

    def insert_left(self, data, parent_node=None):
        node = Node(data)
        if parent_node is None:
            head = self.root
        else:
            head = parent_node
        while head.left is not None:
            head = head.left
        head.left = node
        return

    def insert_right(self, data, parent_node=None):
        node = Node(data)
        if parent_node is None:
            head = self.root
        else:
            head = parent_node
        while head.right is not None:
            head = head.right
        head.right = node
        return

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
        return

    def print_postorder(self, node):
        if node is None:
            return
        self.print_postorder(node.left)
        self.print_postorder(node.right)
        print node.data,
        return

        pass

if __name__ == "__main__":
    tree = BinaryTree(10)
    tree.insert_left(3)
    tree.insert_right(12)
    tree.print_preorder(tree.root)

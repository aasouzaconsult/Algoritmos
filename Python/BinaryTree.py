##################################
### Title: BinaryTree     ########
### Author: GuoChen Hou   ########
##################################

# Implementing a binary tree 

class Node:
	"""
	Basic node structure for a binary search tree
	"""
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None

class BinaryTree:
	"""
	Binary search tree implementation
	"""

	def __init__(self, data):
		self.root = Node(data)

	def get_root(self):
		return self.root

	def add(self, data, node):
		"""
		Insert a new node at the position determined by its data
		"""
		if data < node.data: # left child
			if node.left != None:
				self.add(data, node.left)
			else:
				new_node = Node(data)
				node.left = new_node
				print "Node %d has been added as a left child of %d." % (data, node.data)
		else: # right child
			if node.right != None:
				self.add(data, node.right)
			else:
				new_node = Node(data)
				node.right = new_node
				print "Node %d has been added as a right child of %d." % (data, node.data)

	def preorder(self, node):
		"""
		Performs a preorder traversal of the binary tree starting from node.
		"""
		if node != None:
			print "%d " % node.data,
			self.preorder(node.left)
			self.preorder(node.right)

	def inorder(self, node):
		"""
		Performs a inorder traversal of the binary tree starting from node
		"""
		if node == None:
			return
		self.inorder(node.left)
		print "%d " % node.data,
		self.inorder(node.right)

	def postorder(self, node):
		"""
		Performs a postorder traversal of the binary tree starting from node
		"""
		if node == None:
			return
		self.postorder(node.left)
		self.postorder(node.right)
		print "%d " % node.data,

	def count_nodes(self, node):
		"""
		Returns the number of nodes in the binary tree starting with node
		"""
		if (node == None):
			return 0;
		return 1 + self.count_nodes(node.left) + self.count_nodes(node.right)

if __name__ == "__main__":
	tree = BinaryTree(5)
	tree.add(3, tree.get_root())
	tree.add(4, tree.get_root())
	tree.add(9, tree.get_root())
	tree.add(7, tree.get_root())
	tree.add(6, tree.get_root())
	tree.add(8, tree.get_root())
	tree.preorder(tree.get_root())
	print ""
	print "Total number of nodes: %d" % tree.count_nodes(tree.get_root())
	tree.inorder(tree.get_root())
	print ""
	tree.postorder(tree.get_root())
# Given a binary search tree, design an algorithm which creates a linked list
# of all the nodes at each depth(ie. if you have a tree with depth D, you'll
# have D linked lists.)

# 25
# 15 -> 50
# 10 -> 22 -> 35 -> 70
# 4 -> 12 -> 18 -> 24 -> 31 -> 44 -> 66 -> 90

import binary_search_tree
import linked_list


def create_linked_list(tree):
    """

    Generate arrays of the result linked list and convert results to linked
    list.

    """
    result = []
    result.append([])
    end_nodes = []
    curr = tree.get_root()
    while curr is not None:
        end_nodes.append(curr)
        curr = curr.right
    queue = [tree.get_root()]
    while len(queue) > 0:
        node = queue.pop(0)
        # callback function to process each node
        if node in end_nodes:
            result[-1].append(node.data)
            result.append([])
        else:
            result[-1].append(node.data)

        if node.left is not None:
            queue.append(node.left)
        if node.right is not None:
            queue.append(node.right)
    linked_lists = []
    for item in result:
        if len(item) < 1:
            continue
        ll = linked_list.LinkedList(item[0])
        for i in xrange(1, len(item)):
            ll.insert(item[i])
        linked_lists.append(ll)
    for item in linked_lists:
        item.print_list()
        print ""

if __name__ == "__main__":
    tree = binary_search_tree.BinarySearchTree(25)
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
    #tree.levelorder(tree.get_root(), tree.print_data)
    create_linked_list(tree)

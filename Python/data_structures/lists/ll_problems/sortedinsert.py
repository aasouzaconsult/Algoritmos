# Write a sorted_insert() function which given a list that is sorted in
# increasing order, and a single node, inserts the node into the correct sorted
# position in the list. While push() allocates a new node to add to the list,
# sorted_insert() takes an existing node, and just rearranges the pointers to
# insert it into the list.


def sorted_insert(head, node):
    """
    Given a linked list that is sorted in increasing order, put the node with
    data value in its sorted position in the linked list.

    """
    prev = None
    trav = head
    while node.data < trav.data and trav is not None:
        prev = trav
        trav = trav.next
    if prev is None:
        node.next = head
        head = node
    else:
        prev.next = node
        node.next = trav
    return

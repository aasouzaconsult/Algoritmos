# Write a function insertnth which can insert a new node at any index within a
# list. The caller may specify any index in the range 0..length, and the new
# node should be inserted so as to be at that index.


def insert_nth(head, index, data):
    """
    A more general version of push(). Given a linked list, an index in the
    range 0...length, and a data element, add a new node to the list so that it
    has the given index.

    """
    # check index is between 0...length
    if index >= length(head) or index < 0:
        return "index out of range"
    # create a new node with data
    node = Node(data)
    # trav the list until index-1 position
    trav = head
    for i in range(0, index):
        trav = trav.next
    # set index-1 node's next to new node
    # set new node's next to index-1 node's next next
    node.next = trav.next
    trav.next = node
    return


def length(head):
    """
    Return the length of linked list.

    """
    if head is None:
        return 0
    count = 0
    trav = head
    while trav is not None:
        count += 1
        trav = trav.next
    return count

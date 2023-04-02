# Write an insert_sort() function which given a list, rearranges its node so
# they are sorted in increasing order. It should use sorted_insert().


def insert_sort(head):
    """
    Given a list, change it to be in sorted order (using sorted_insert()).

    """
    # check head is not None
    if head is None:
        return
    # trav the head check that the next node is bigger than prev node and node
    # is not None
    prev = None
    trav = head
    while trav is not None:
        prev = trav
        trav = trav.next
        if trav is None:
            break
        elif prev.data > trav.data:
            # when current node is smaller than prev node, remove the node and
            # call sorted_insert starting from head of node
            node = trav
            prev.next = trav.next
            node.next = None
            sorted_insert(head, node)
    return head


def insert_sort2(head):
    """
    Start with an empty result list and fill in the result with current nodes
    starting at head ref.

    """
    if head is None:
        return
    result = None
    trav = head
    while trav is not None:
        sorted_insert(result, trav)
        trav = trav.next
    return result


def sorted_insert(head, node):
    """
    Given a linked list that is sorted in increasing order, put the node with
    data value in its sorted position in the linked list.

    """
    if head is None:
        head = node
        return
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

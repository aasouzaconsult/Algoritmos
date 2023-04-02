# Write a get_nth() function that takes a linked list and an integer index and
# returns the data value stored in the node at that index position. get_nth()
# uses the C number convention that the first node is index 0, the second index
# 1, .. and so on. The index should be in the range 0 to len(). If it is not,
# get_nth() should assert() fail( or you could implement some other error case
# strategy)


def get_nth(head, index):
    """
    Given a list and an index, return the data in the nth node of the list. The
    nodes are numbered from 0. Assert fails if the index is invalid.

    """
    if head is None or index >= length(head) or index < 0:
        return None
    trav = head
    i = 0
    while i != index:
        trav = trav.next
        i += 1
    return trav.data


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

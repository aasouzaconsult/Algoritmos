# Write a function deletelist() that takes a list, deallocates all of its
# memory and sets its head pointer to NULL.


def delete_list(head):
    """
    Deallocates memory of all the nodes in the linked list and return the NULL
    head reference.

    """
    trav = head
    while trav is not None:
        next = trav.next
        trav = None  # deallocate current node and release memory
        trav = next
    head = None
    return

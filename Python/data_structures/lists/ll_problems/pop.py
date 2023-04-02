# Write a pop() funciton that is the inverse of push(). pop() takes a non-empty
# list, deletes the head node, and returns the head node's data.


def pop(head):
    """
    The opposite of push(). Takes a non-empty list and removes the front node,
    and returns the data which was in that node.

    """
    if head is None:
        return
    next = head.next
    result = head.data
    head = None  # deallocate first node and free memory
    head = next
    return result

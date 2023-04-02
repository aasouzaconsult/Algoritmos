# Write an iterative reverse() function thtat reverses a list by rearranging
# all the .next pointers and the head pointer. Ideally reverse should only need
# to make one pass of the list.


def reverse(head):
    if head is None:
        return
    result = None
    trav = head
    while trav is None:
        node = deepcopy(trav)
        node.next = result
        result = node
        trav = trav.next
    return result

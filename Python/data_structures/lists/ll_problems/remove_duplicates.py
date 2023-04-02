# Write a remove_duplicates() function which takes a list sorted in increasing
# order and deletes and duplicate nodes from the list. The list should only be
# traversed once.


def remove_duplicates(head):
    if head is None:
        return
    prev = None
    trav = head
    while trav is not None:
        prev = trav
        trav = trav.next
        if prev.data == trav.data:
            prev.next = trav.next
    return head

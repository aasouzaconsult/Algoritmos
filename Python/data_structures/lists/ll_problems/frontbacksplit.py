# Given a linked list, split it into two sublists - one for the front half, and
# one for the back half. If the number of elements is odd, the extra element
# should go in the front list.


def front_back_split(source):
    front = None
    back = None
    if length(source) < 2:
        front = source
        back = None
        return front, back
    if length(source) % 2 == 0:
        front_size = length(source) // 2
    else:
        front_size = length(source)//2 + 1
    trav = source
    prev = None
    for i in range(front_size):
        prev = trav
        trav = trav.next
    prev.next = None
    front = source
    back = trav
    return front, back


def front_back_split2(source):
    front = None
    back = None
    slow = source
    fast = source
    while fast is not None:
        fast = fast.next
        if fast is not None:
            slow = slow.next
            fast = fast.next
    back = slow.next
    slow.next = None
    front = source
    return front, back


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

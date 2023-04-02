# Write a recursive reverse() function that reverses a list by rearranging all
# the .next pointers and the head pointer. Ideally, recursive reverse should
# only make one pass of the list.


def recursive_reverse(head):
    if head is None:
        return
    first = head
    rest = first.next
    if rest is None:
        return
    recursive_reverse(rest)
    first.next.next = first
    first.next = None
    head = rest

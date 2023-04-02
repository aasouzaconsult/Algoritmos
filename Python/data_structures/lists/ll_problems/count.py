# Write a count() function that counts the number of times a given int occurs
# in a list. The code for this has the classic list traversal structure as
# demonstrated in length().


def count(head, search_int):
    """
    Given a list and an int, return the number of times that int occurs in
    the list.

    """
    if head is None:
        return 0
    count = 0
    trav = head
    while trav is not None:
        if trav.data == search_int:
            count += 1
        trav = trav.next
    return count

# Write an append() function that takes two linked lists and append b list onto
# the end of a then sets b to None.


def append(a_list, b_list):
    if a_list is None:
        a_list = b_list
        return a_list
    else:
        trav = a_list
        while trav is not None:
            trav = trav.next
        trav.next = b_list
    b_list = None
    return a_list

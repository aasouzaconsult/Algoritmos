# Given two lists sorted in increasing order, create and return a new list
# representing the intersection of the two lists.


def sorted_intersect(a, b):
    trav_a = a
    trav_b = b
    result = None

    while trav_a is not None and trav_b is not None:
        if trav_a.data == trav_b.data:
            result.push(trav_a)
            trav_a = trav_a.next
            trav_b = trav_b.next
        elif trav_a.data < trav_b.data:
            trav_a = trav_a.next
        else:
            trav_b = trav_b.next
    return result

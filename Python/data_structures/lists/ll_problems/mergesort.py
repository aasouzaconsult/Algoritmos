# Mergesort strategy: split into sublists, sort the sublists recursively, merge
# the two sorted sublists together to form the answer.


def mergesort(head):
    a = None
    b = None

    if head is None or head.next is None:
        return
    a, b = frontback_split(head, a, b)
    mergesort(a)
    mergesort(b)
    return sortedmerge(a, b)

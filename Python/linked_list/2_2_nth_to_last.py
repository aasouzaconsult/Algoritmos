from linked_list import *

# Implement an algorithm to find the nth to last element of a singly linked
# list.


def nth_to_last(ll_obj, nth):
    head = ll_obj.get_head()
    stack = []
    while head is not None:
        stack.append(head.data)
        head = head.next
    for i in range(nth):
        result = stack.pop()
    return result


if __name__ == "__main__":
    test = LinkedList(1)
    test.insert(2)
    test.insert(3)
    test.insert(4)
    test.insert(5)
    test.insert(6)
    test.insert(7)
    test.print_list()
    print ""
    print nth_to_last(test, 1)
    print nth_to_last(test, 2)
    print nth_to_last(test, 3)
    print nth_to_last(test, 4)
    print nth_to_last(test, 5)
    print nth_to_last(test, 6)
    print nth_to_last(test, 7)

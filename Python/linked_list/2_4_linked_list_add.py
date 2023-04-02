from linked_list import *

# You have two numbers represented by a linked list, where each node contains a
# single digit. The digits are stored in reverse order, such that the 1's digit
# is at the head of the list. Write a function that adds the two numbers and
# returns the sum as a linked list.


def linked_list_add(obj1, obj2):
    head1 = obj1.get_head()
    head2 = obj2.get_head()
    carry = 0
    while head1 is not None:
        while head2 is not None:
            head1.data += head2.data + carry
            if head1.data >= 10:
                head1.data %= 10
                carry = 1
            else:
                carry = 0
            head2 = head2.next
            break
        head1 = head1.next
        if head2 is None:
            break
    return obj1

if __name__ == "__main__":
    test = LinkedList(3)
    test.insert(1)
    test.insert(5)
    test2 = LinkedList(5)
    test2.insert(9)
    test2.insert(2)
    test.print_list()
    print ""
    test2.print_list()
    print ""
    linked_list_add(test, test2).print_list()

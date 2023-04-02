##################################
### Title: Linked List addition ##
### Author: GuoChen Hou   ########
##################################

# Two numbers represented by a linked list, where each node contains
# a single digit.
# The digits are stored in reverse order, such that the 1/s digit is at the
# head of the list. Write a function that adds the two numbers and returns
# the sum as a linked list.

from ADT.LinkedList import LinkedList


def add(linked_list1, linked_list2):
    """
    This function adds the two numbers(represented as linked lists) and
    returns the sum as a linked list.
    """
    # check if any of the inputs are empty
    if linked_list1.get_size() is 0 or linked_list2.get_size() is 0:
        print "Please check that both lists are not empty."
        return

    result = LinkedList()
    if linked_list1.get_size() is linked_list2.get_size():
        list1 = linked_list1.get_head()
        list2 = linked_list2.get_head()
        carry = 0
        while list1 is not None and list2 is not None:
            value = (list1.data + list2.data) % 10 + carry
            print value
            carry = (list1.data + list2.data) / 10
            print carry
            result.insert(value)
            list1 = list1.next
            list2 = list2.next
    print result.print_list()
    return result


if __name__ == "__main__":
    test_list1 = LinkedList()
    test_list2 = LinkedList()

    test_list1.insert(3)
    test_list1.insert(1)
    test_list1.insert(5)

    test_list2.insert(5)
    test_list2.insert(9)
    test_list2.insert(2)
    test_list1.print_list()
    test_list2.print_list()
    add(test_list1, test_list2)

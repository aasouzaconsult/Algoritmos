from linked_list import *

# Implement an algorithm to delete a node in the middle of a single linked
# list, given only access to that node.
# Example:
# input the node c from the linked list: a ->b ->c ->d ->e
# result: nothing is returned. but the new lnked list looks like a->b->d->e


def delete_middle_node(ll_obj):
    """

    Delete the middle node.

    """
    node = generate_mid_pointer(ll_obj)
    while node.next.next is not None:
        node.data = node.next.data
        node = node.next
    node.data = node.next.data
    node.next = None
    return ll_obj


def generate_mid_pointer(ll_obj):
    """

    Return a mid pointer to the linked list.

    """
    head = ll_obj.get_head()
    size = 0
    while head is not None:
        size += 1
        head = head.next
    print size
    head = ll_obj.get_head()
    for i in range(size/2):
        head = head.next
    return head

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
    delete_middle_node(test).print_list()

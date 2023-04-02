from linked_list import *

# write code to remove duplicates from an unsorted linked list
# FOLLOW UP
# How would you solve this problem if a temporary buffer is not allowed


def remove_duplicates(ll_obj):
    datas = []
    head = ll_obj.get_head()
    while head is not None:
        if head.data in datas:
            ll_obj.delete_node(head)
        else:
            datas.append(head.data)
        head = head.next
    return ll_obj


def remove_duplicates_2(ll_obj):
    """

    Remove duplicates from linked list object without temporary buffers.

    """
    head = ll_obj.get_head()
    while head.next is not None:
        curr = head.next
        while curr is not None:
            if curr.data == head.data:
                ll_obj.delete(head.data)
                break
            curr = curr.next
        head = head.next
    return ll_obj

if __name__ == "__main__":
    test = LinkedList(1)
    test.insert(2)
    test.insert(3)
    test.insert(3)
    test.insert(4)
    test.insert(5)
    test.insert(6)
    test.insert(4)
    test.insert(7)
    test.print_list()
    print ""
    remove_duplicates_2(test).print_list()

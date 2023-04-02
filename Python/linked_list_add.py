# 1->2->3->4
# 5->6->7->8
# 6->8->0->3->1


from ADT.LinkedList import *


def linked_list_add(num1, num2):
    result = LinkedList()
    curr1 = num1.get_head()
    curr2 = num2.get_head()
    carry = False

    while curr1 is not None:
        while curr2 is not None:
            if carry:
                value = curr1.data + curr2.data + 1
            else:
                value = curr1.data + curr2.data
            if value >= 10:
                carry = True
            else:
                carry = False
            result.insert(value%10)
            curr2 = curr2.next
            break
        curr1 = curr1.next
    if carry:
        result.insert(1)
    return result

if __name__ == "__main__":
    num1 = LinkedList()
    num2 = LinkedList()

    num1.insert(1)
    num1.insert(2)
    num1.insert(3)
    num1.insert(4)
    num2.insert(5)
    num2.insert(6)
    num2.insert(7)
    num2.insert(8)
    linked_list_add(num1, num2).print_list()

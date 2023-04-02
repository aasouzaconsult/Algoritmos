##################################
### Title: Last Nth element ######
### Author: GuoChen Hou   ########
##################################

# Implement an algorithm to find the nth to last element of a
# singly linked list.

from ADT.LinkedList import LinkedList


class NthLinkedList(LinkedList):

    def nth_to_last(self, position):
        if self.size is 0:
            return

        # get the node position counting from head
        node_position = self.size - position - 1  # offset since node starts at 1 instead of 0
        trav = self.head

        while trav is not None and node_position is not 0:
            trav = trav.next
            node_position -= 1
        return trav.data

if __name__ == "__main__":
    test_list = NthLinkedList()
    test_list.insert(1)
    test_list.insert(2)
    test_list.insert(3)
    test_list.insert(4)
    test_list.print_list()

    print test_list.nth_to_last(2)

# Implement a doubly linked list.


class Node(object):
    """
    Node structure for a node double linked list.
    """

    def __init__(self, data=None, next=None, prev=None):
        self.data = data
        self.next = next
        self.prev = prev


class DoublyLinkedList(object):
    """
    A doubly linked list with head referencing the first node.
    """

    def __init__(self):
        self.head = None
        self.size = 0

    def insert(self, data):
        """
        Append a new node with value data to the end of the list.
        """
        # declare new node with data
        new_node = Node(data)

        # insert first item in list
        if self.head is None:
            self.head = new_node
            self.size += 1
            print "New node with data %d added." % data
            return self.head

        # traverse to last node
        trav = self.head
        while trav.next is not None:
            trav = trav.next

        # append new node to previously last node
        trav.next = new_node
        new_node.prev = trav
        self.size += 1
        print "New node with data %d added." % data
        return self.head

    def delete(self, data):
        """
        Delete the first occurence of the node which contains data. If data
        is not given, the first node is deleted.
        """

        # list empty
        if self.size is 0:
            self.head = None
            return

        # traverse the list to find data node
        trav = self.head
        while trav is not None:
            if trav.data is data:
                # data node is first node
                if trav.prev is None:
                    self.head = trav.next
                    trav.next.prev = None
                    trav.next = None
                # data node is last node
                elif trav.next is None:
                    trav.prev.next = None
                    trav.prev = None
                else:
                    # data node is in-between node
                    trav.prev.next = trav.next
                    trav.next.prev = trav.prev
                    trav.prev = None
                    trav.next = None
                self.size -= 1
                return self.head
            trav = trav.next
        print "Data not found."
        return

    def remove_duplicates(self):
        """
        Remove duplicate nodes from the doubly linked list.
        """

        histogram = dict()

        # traverse the list
        trav = self.head
        while trav is not None:
            if trav.data not in histogram.keys():
                histogram[trav.data] = 1
            else:
                histogram[trav.data] += 1
            trav = trav.next

        for key, value in histogram.items():
            if value is not 1:
                # preserve 1 value and delete the rest
                for i in range(value-1):
                    self.delete(key)
        return self.head

    def print_list(self):
        """
        Prints the list by list order.
        """

        trav = self.head
        while trav is not None:
            print trav.data,
            trav = trav.next

if __name__ == "__main__":
    test_linked_list = DoublyLinkedList()
    test_linked_list.insert(1)
    test_linked_list.insert(1)
    test_linked_list.insert(2)
    test_linked_list.insert(2)
    test_linked_list.insert(2)
    test_linked_list.insert(3)
    test_linked_list.insert(3)
    test_linked_list.delete(2)
    test_linked_list.remove_duplicates()
    test_linked_list.print_list()

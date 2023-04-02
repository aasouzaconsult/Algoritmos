########################################
### Title: Circular Linked list ########
### Author: GuoChen Hou   ##############
########################################

# A sample implementation of circular linked list ADT structure
# Classes:
#   Node - Structure of a basic node in the circular linked list
#   CircularLinkedList - Circular linked list ADT attributes and methods
# Operations:
#   CircularLinkedList:
#   __init__(): initialize a circular list intance with a head node
#   insert(data): insert an element into the circular linked list with data
#   delete(data): delete an element from the circular linked list with data


class Node(object):
    """
    Node structure for circular linked list.
    """

    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next


class CircularLinkedList(object):
    """
    A circular linked list.
    """

    def __init__(self):
        self.head = Node(None)
        self.head.next = self.head
        self.size = 0

    def get_head(self):
        """
        Return a reference to head of circular list.
        """

        return self.head

    def insert(self, data):
        """
        Insert a new node with data to the end of circular list just before
        self.head.
        """
        new_node = Node(data)
        if self.head.next is self.head:
            new_node.next = self.head.next
            self.head.next = new_node
            self.size += 1
            #print self.head.data
            #print self.head.next.data
            return

        trav = self.head.next
        while trav.next is not self.head:
            trav = trav.next

        new_node.next = self.head
        trav.next = new_node
        self.size += 1
        return

    def delete(self, data):
        """
        Find the first occurence of data node and delete the node.
        """

        trav = self.head.next
        prev = None
        # traverse through the circular list until the next node has node
        # value either data or None.
        while trav.data is not data and trav.data is not None:
            prev = trav
            trav = trav.next

        if trav.data is data:
            prev.next = trav.next
            trav.next = None
            self.size -= 1
            print "Node with value %d deleted." % data
            return self.head
        else:
            print "Node not found."
            return None

    def print_list(self):
        """
        Print the circular linked list in linear fashion.
        """

        trav = self.head.next

        while trav is not self.head:
            print trav.data
            trav = trav.next


if __name__ == "__main__":
    circular = CircularLinkedList()
    circular.insert(1)
    circular.insert(2)
    circular.insert(3)
    circular.print_list()
    circular.delete(2)
    circular.print_list()

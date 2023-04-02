########################################
### Title: Linked list implementations #
### Author: GuoChen Hou   ##############
########################################

# A sample implementation of linked list ADT strucutre
# Classes:
# 	Node - Structure of a basic node in the linked list
#	Linked_list - Linked list ADT attributes and methods
# Operations:
#	Linked_list:
#		__init__(): initialize a linked list instance with a head Node declaration
#		insert(value): Inserts the value to the head of the list
#		delete(value=None): Deletes the head node if value is not given. Otherwise search and delete the node with data value.
#		search(value): Search the value in the linked list and return a reference to the node. If not found, return None
#		print(value=None): Print the data of the node with data=value and each subsequent node. If value is None, print data
#							starting from the root node

# Implementation of singly linked list with node structure


class Node:
    """
    Node structure for a singly linked list
    """
    def __init__(self, data=None, next=None):
        """
        Construct a new node.
        """
        self.data = data
        self.next = next

class LinkedList:
    def __init__(self):
        """
        Construct a new linked list. The head node references the first node in list. Size is list is 0.
        """
        self.head = None
        self.size = 0	

    def get_head(self):
        """
        Return a reference to the head of list.
        """

        return self.head

    def get_size(self):
        """
        Return a reference to the size of the list.
        """

        return self.size

    def insert(self, value):
        """
        Inserts the value to the head of the list.
        """
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
        else:
            trav = self.head
            while trav.next is not None:
                trav = trav.next
            trav.next = new_node
        self.size += 1
        return

    def delete(self, value=None):
        """
        Deletes the head node if value is None and return the new head ref. Otherwise search and delete the node with data==value.
        If value not found, return None
        """
        if value==None:
            self.head = self.head.next
            return self.head
        else:
            prev = None
            trav = self.head

            while trav != None:
                # find the node to which its data == value and give a reference to its previous node
                if trav.data == value: # value is found
                    if prev == None: # value is in first position
                        self.head = self.head.next
                        return self.head
                    else:
                        prev.next = trav.next
                prev = trav
                trav = trav.next
            return None

    def print_list(self):
        trav = self.head
        while trav != None:
            print "%d" % trav.data,
            trav = trav.next

"""
if __name__ == "__main__":
	test = Linked_list()
	test.insert(1)
	test.insert(2)
	test.insert(3)
	test.print_list()
	test.delete(0)
	test.print_list()
"""
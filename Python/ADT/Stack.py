##################################
### Title: Stack Implementations #
### Author: GuoChen Hou   ########
##################################

# A sample implementation of stack ADT structure
# Stack ADT: LIFO
# Operations:
# __init__(): initialize a new empty stack
# push(value): add a new item to the stack
# pop(): remove and return an item from the stack. The item that is returned
#        is always the last one that was added
# top(): return the item most recently added to the stack, but do not remove it
# is_empty(): check whether the stack is empty

# Array implementation of stack


class Stack_array:
    """
    Implementing a stack ADT using a list data structure.

    List[0] is at the bottom of the stack. List[len(list)-1] is at the top of
    the stack.
    """

    def __init__(self):
        """
        Initialize a list when class instance is declared.
        """
        self.stack = []

    def empty(self):
        """
        Return true if the stack is empty, else return false
        """
        return self.stack == []

    def push(self, value):
        """
        Add the item 'value' to the stack and return a reference to the stack.
        """

    def pop(self):
        """
        Remove the item most recently added to the stack and return the removed
        value.
        """
        return self.stack.pop()

    def top(self):
        """
        Return the item at the top of the stack but do not remove it.
        """
        if self.empty():
            return None
        return self.stack[len(self.stack)-1]

    def size(self):
        """
        Return the size of the stack.
        """
        return len(self.stack)


# Linked list implementation of stack
class Node:
    """
    Node structure for Stack_linkedlist class.
    """
    def __init__(self, data=None):
        self.data = data
        self.next = None


class Stack_linkedlist:
    """
    Implementing a stack ADT using a linked list data structure.
    """
    def __init__(self, data=None):
        """
        Initialize a linked list node with data='data' when class instance is
        declared.
        """
        self.head = Node(data)
        self.size = 0

    def empty(self):
        """
        Return true if the stack is empty, else return false.
        """
        if self.size == 0:
            return True
        return False

    def push(self, value):
        """
        Add the item 'value' to the stack and return a reference to the stack.

        Add item 'value' to the front of the linked list. The previous top is
        then "next" from the item being added and the list's front pointer
        points to the new item.
        """
        if self.empty():
            self.head.data = value
        else:
            new_node = Node(value)
            new_node.next = self.head
            self.head = new_node
        self.size += 1
        return value

    def top(self):
        """
        Return the item at the top of the stack but do not remove it.
        """
        if self.empty():
            return
        return self.head.data

    def get_size(self):
        """
        Return the size of the stack.
        """
        return self.size

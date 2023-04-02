##################################
### Title: Min Stack      ########
### Author: GuoChen Hou   ########
##################################

# How would you design a stack which, in addition to push and pop, also has a
# function min which returns the minimum element? Push, pop and min should all
# operate in O(1) time.


class Node:
    """
    Node structure for Stack class.
    """
    def __init__(self, data=None):
        self.data = data
        self.next = None


class Stack(object):
    """
    A stack structure with FIFO element retrieval sequence.
    """
    def __init__(self, data=None):
        """
        Initialize a linked list node with data when class instance is
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

    def push(self, data):
        """
        Add the item 'data' to the stack and return a reference to the stack.

        Add item 'data' to the front of the linked list. The previous top is
        then "next" from the item being added and the list's front pointer
        points to the new item.
        """
        if self.empty():
            self.head.data = value
        else:
            new_node = Node(data)
            new_node.next = self.head
            self.head = new_node
        self.size += 1
        return

    def pop(self):
        """
        Remove and return the element at the top of the stack.
        """
        if self.empty():
            return
        data = self.head.data
        self.head = self.head.next
        return data


class MinStack(Stack):
    """
    Subclass Stack with added feature to identify the minimum element.
    """

    def __init__(self, data=None):
        """
        Initialize stack instance of its super class with added attributes.
        """
        super(MinStack, self).__init__(data)
        self.min = None

    def push(self, data):
        """
        Add the item 'data' to the stack and return a reference to the stack.

        Add item 'data' to the front of the linked list. The previous top is
        then "next" from the item being added and the list's front pointer
        points to the new item.

        If new data has lesser value than min, update min attribute.
        """
        if self.empty():
            self.head.data = data
            self.min = data
        else:
            new_node = Node(data)
            new_node.next = self.head
            self.head = new_node
            # update min value in stack
            if data < self.min:
                self.min = data
        self.size += 1
        return

    def min_value(self):
        """
        Return the minimum data from the stack without removing its
        corresponding node.
        """
        return self.min

if __name__ == "__main__":
    min_stack = MinStack()
    min_stack.push(7)
    min_stack.push(3)
    min_stack.push(5)
    min_stack.push(2)
    print min_stack.min_value()

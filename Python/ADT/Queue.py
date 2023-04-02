##################################
### Title: Queue          ########
### Author: GuoChen Hou   ########
##################################

# Queue ADT: FIFO
# Operations:
# __init__(): initialize an empty queue
# empty(): Return true if queue is empty, false otherwise
# enqueue(value): Add the item value to the end of the queue
# dequeue(): Remove the least recently added item from the queue
# front(): Return the item least recently added to the queue, but do not remove
# it.

# Array implementation of queue ADT structure


class Queue_Array:
    """
    Implementing a queue ADT using a list data structure.
    List[0] is the front of the queue. List[-1] is the end of the queue.
    """
    def __init__(self):
        """
        Initialize a list when class instance is declared.
        """
        self.queue = []

    def empty(self):
        """
        Return true if queue is empty, else return false
        """
        return len(self.queue) == 0

    def front(self):
        """
        Return the item least recently added to the queue, but do no remove it.
        """
        if self.is_empty():
            return None
        return self.queue[0]

    def dequeue(self):
        """
        Remove and return the least recently added item from the queue.
        """
        if self.is_empty():
            return None
        else:
            return self.queue.pop(0)

    def enqueue(self, value):
        """
        Add the item 'value' to the end of the queue and return the queue.
        """
        self.queue.append(value)
        return self.queue

    def print_queue():
        """
        Print the queue in order from front to back.
        """
        print self.queue


# Doubly linked list implementation of queue
class Node:
    """
    Node structure for Queue_linkedlist class.
    """
    def __init__(self, data=None, prev=None, next=None):
        self.data = data
        self.prev = prev
        self.next = next


class Queue_linkedlist:
    """
    Implementing a queue ADT using a doubly linked list data structure
    """
    def __init__(self):
        """
        Initialize a list when class instance is declared.
        """
        self.queue = None
        self.tail = None
        self.size = 0

    def empty(self):
        """
        Return true if queue is empty, else return false
        """
        return self.size == 0

    def front(self):
        """
        Return the item least recently added to the queue, but do not remove
        it.
        """
        if self.queue is None:
            return
        return self.queue.data

    def enqueue(self, value):
        """
        Add the item 'value' to the end of the queue and return the queue.
        """
        new_node = Node(value)
        if self.queue is None:
            self.queue = new_node
        else:
            trav = self.queue
            # set trav to reference the current last node in queue
            while trav.next is not None:
                trav = trav.next
            trav.next = new_node
            new_node.prev = trav
        self.tail = new_node
        self.size += 1
        return self.queue

    def dequeue(self):
        """
        Remove and return the least recently added item from the queue.
        """
        data = self.front()
        self.queue = self.queue.next
        return data

    def print_queue(self):
        """
        Print the queue in order from front to back.
        """
        trav = self.queue
        while trav is not None:
            print "%d " % trav.data,
            trav = trav.next
        print "\n"

if __name__ == "__main__":
    test = Queue_linkedlist()
    test.enqueue(1)
    test.enqueue(2)
    test.enqueue(3)
    test.enqueue(4)
    test.enqueue(5)
    test.print_queue()
    test.dequeue()
    test.print_queue()
    test.dequeue()
    test.print_queue()
    test.dequeue()
    test.print_queue()
    test.enqueue(6)
    test.print_queue()

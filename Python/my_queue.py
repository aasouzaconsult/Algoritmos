##################################
### Title: My Queue       ########
### Author: GuoChen Hou   ########
##################################

# Implement a MyQueue class which implements a queue using two stacks.

# Stack 1 will be the main stack, using stack2 as a temporary stack.
# On enqueue, element is pushed onto stack1 as normal.
# On dequeue, all element in stack1 are poped and pushed in reverse order to
# stack2.
# When stack1 is empty, top element of stack2 is poped as the returned element.
# Finally pop and push elements in stack2 back to stack1 in reverse order.


class MyQueue(object):
    """
    MyQueue class which implements a queue using two stacks.
    """

    def __init__(self):
        """
        Initialize two stacks.
        """
        self.stack1 = []
        self.stack2 = []

    def stack1_empty(self):
        """
        Return true if stack1 is empty, false otherwise.
        """
        if len(self.stack1) < 1:
            return True
        return False

    def stack2_empty(self):
        """
        Return true if stack2 is empty, false otherwise.
        """
        if len(self.stack2) < 1:
            return True
        return False

    def enqueue(self, element):
        """
        Add element to the end of the queue.
        """
        self.stack1.append(element)
        return

    def dequeue(self):
        """
        Remove element from the front of the queue.
        """
        while not self.stack1_empty():
            self.stack2.append(self.stack1.pop())
        result = self.stack2.pop()
        while not self.stack2_empty():
            self.stack1.append(self.stack2.pop())
        return result


if __name__ == "__main__":
    myqueue = MyQueue()
    myqueue.enqueue(1)
    myqueue.enqueue(2)
    myqueue.enqueue(3)
    myqueue.enqueue(4)
    print myqueue.dequeue()
    print myqueue.dequeue()
    print myqueue.dequeue()
    myqueue.enqueue(5)
    print myqueue.dequeue()

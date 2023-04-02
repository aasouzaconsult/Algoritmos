# Implement a MyQueue which implements a queue using two stacks.


class MyQueue(object):
    """

    Implementing a queue with LIFO structure using 2 stacks.

    """
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def enqueue(self, value):
        while len(self.stack2) > 0:
            self.stack1.append(self.stack2.pop())
        self.stack1.append(value)
        return

    def dequeue(self):
        while len(self.stack1) > 0:
            self.stack2.append(self.stack1.pop())
        return self.stack2.pop()

    def print_queue(self):
        print self.stack1
        print self.stack2


if __name__ == "__main__":
    queue = MyQueue()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)
    queue.enqueue(5)
    queue.print_queue()
    print queue.dequeue()
    queue.print_queue()
    print queue.dequeue()
    queue.print_queue()
    print queue.dequeue()
    queue.enqueue(6)
    queue.enqueue(7)
    queue.print_queue()

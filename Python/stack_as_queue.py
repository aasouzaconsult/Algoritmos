# implement a queue with 2 stacks.


class Queue(object):
    """

    Implement a queue with 2 stacks.

    """
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def enqueue(self, value):
        self.stack1.append(value)

    def dequeue(self):
        while len(self.stack1) > 0:
            self.stack2.append(self.stack1.pop())
        result = self.stack2.pop()
        while len(self.stack2) > 0:
            self.stack1.append(self.stack2.pop())
        return result

    def print_queue(self):
        print self.stack1
        print self.stack2

if __name__ == "__main__":
    test_queue = Queue()
    test_queue.enqueue(1)
    test_queue.enqueue(2)
    test_queue.enqueue(3)
    test_queue.enqueue(4)
    test_queue.print_queue()
    test_queue.dequeue()
    test_queue.print_queue()
    test_queue.dequeue()
    test_queue.print_queue()

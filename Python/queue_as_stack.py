class Stack(object):
    """

    Implement stack with 2 queues.

    """
    def __init__(self):
        self.queue1 = []
        self.queue2 = []

    def push(self, value):
        self.queue1.append(value)

    def pop(self):
        while len(self.queue1) > 1:
            self.queue2.append(self.queue1.pop(0))
        result = self.queue1.pop(0)
        self.queue1, self.queue2 = self.queue2, self.queue1
        return result

    def print_stack(self):
        print self.queue1
        print self.queue2


if __name__ == "__main__":
    test_stack = Stack()
    test_stack.push(1)
    test_stack.push(2)
    test_stack.push(3)
    test_stack.push(4)
    test_stack.print_stack()
    test_stack.pop()
    test_stack.print_stack()
    test_stack.pop()
    test_stack.print_stack()

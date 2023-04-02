# Implementation of Stack data structure with LIFO principle


class Stack(object):
    def __init__(self):
        self.stack = []

    def add(self, data):
        return self.stack.append(data)

    def pop(self):
        return self.stack.pop()

    def print_stack(self):
        print self.stack
        return

if __name__ == "__main__":
    test = Stack()
    test.add(1)
    test.add(2)
    test.add(3)
    test.print_stack()
    test.pop()
    test.print_stack()
    test.pop()
    test.print_stack()

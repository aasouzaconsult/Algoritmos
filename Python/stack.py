import unittest


class Stack(object):
    """
    Implementation of a stack structure with list. LIFO
    push(value)
    pop()
    is_empty()

    """
    def __init__(self, stack=list()):
        self.stack = stack

    def is_empty(self):
        if len(self.stack) < 1:
            return True
        return False

    def push(self, value):
        self.stack.append(value)
        return

    def pop(self):
        if self.is_empty():
            return
        return self.stack.pop()

    def print_stack(self):
        print self.stack


class StackTestCase(unittest.TestCase):
    """
    Stack class test cases.

    """
    def setUp(self):
        self.stack = Stack()

    def test_stack(self):
        self.stack.push(1)
        self.stack.push(2)
        self.stack.push(3)
        self.stack.push(4)
        self.assertEqual(self.stack.stack, [1, 2, 3, 4])
        self.stack.pop()
        self.assertEqual(self.stack.stack, [1, 2, 3])
        self.stack.push(5)
        self.assertEqual(self.stack.stack, [1, 2, 3, 5])


if __name__ == "__main__":
    stack = Stack()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.print_stack()
    stack.pop()
    stack.print_stack()
    stack.push(5)
    stack.push(6)
    stack.print_stack()
    stack.pop()
    stack.print_stack()

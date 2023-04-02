import unittest


class Stack(object):
    """

    Implementing a stack using a list data structure.
    Stack complexity:
    [method]: [average case], [worst case]
    access: O(n), O(n)
    search: O(n), O(n)
    insertion: O(1), O(1)
    deletion: O(1), O(1)

    """
    def __init__(self, stack=list()):
        self.stack = stack

    def push(self, value):
        self.stack.append(value)

    def pop(self):
        self.stack.pop()

    def print_stack(self):
        print self.stack


class StackTestCase(unittest.TestCase):

    def setUp(self):
        self.stack1 = Stack()

    def test_stack(self):
        self.stack1.push(1)
        self.stack1.push(2)
        self.stack1.push(3)
        self.stack1.push(4)
        self.stack1.push(5)
        self.assertEqual(self.stack1.stack, [1, 2, 3, 4, 5])
        self.stack1.pop()
        self.assertEqual(self.stack1.stack, [1, 2, 3, 4])
        self.stack1.pop()
        self.stack1.pop()
        self.assertEqual(self.stack1.stack, [1, 2])

if __name__ == "__main__":
    unittest.main()

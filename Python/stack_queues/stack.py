# implementing a stack


class Stack(object):
    """

    Implementing a stack using list data structure.

    """
    def __init__(self):
        self.stack = []

    def push(self, value):
        self.stack.append(value)

    def pop(self):
        if len(self.stack) < 1:
            return
        return self.stack.pop()

    def print_stack(self):
        print self.stack
        return


if __name__ == "__main__":
    stack = Stack()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.print_stack()
    stack.pop()
    stack.print_stack()
    stack.pop()
    stack.pop()
    stack.pop()
    stack.print_stack()

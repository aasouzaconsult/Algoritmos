# How would you design a stack which, in addition to push and pop, also has a
# function min which returns the minimum element? Push, pop and min should
# all operate in O(1) time.

# Use a reference pointer to point to min value in stack.
# DOES NOT WORK.
# if min is popped, its impossible to find the next min in O(1) time.

# Every node in the stack keeps track of the min


class Stack(object):
    """

    Implementing a stack using list data structure.

    """
    def __init__(self):
        self.stack = []

    def min(self):
        return self.stack[-1][1]

    def push(self, value):
        if len(self.stack) < 1:
            self.stack.append([value, value])
        else:
            if self.stack[-1][1] > value:
                self.stack.append([value, value])
            else:
                local_min = self.stack[-1][1]
                self.stack.append([value, local_min])
        return

    def pop(self):
        if len(self.stack) < 1:
            return
        popped = self.stack.pop()
        return popped[0]

    def print_stack(self):
        print self.stack
        return


if __name__ == "__main__":
    stack = Stack()
    stack.push(8)
    stack.push(2)
    stack.push(4)
    stack.push(1)
    stack.print_stack()

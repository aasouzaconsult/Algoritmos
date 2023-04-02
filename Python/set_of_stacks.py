##################################
### Title: Set of Stacks  ########
### Author: GuoChen Hou   ########
##################################

# Imagine a literal stack of plates. If the stack gets too high, it might
# topple. Therefore, in real life, we would likely start a new stack when the
# previous stack exceeds some threshold. Implement a data structure SetOfStacks
# that mimics this. SetOfStacks should be composed of several stacks, and
# should create a new stack once the previous one exceeds capacity.
# SetOfStacks.push() and SetOfStacks.pop() should behave identically to a
# single stack (that is, pop() should return the same values as it
# would if there were just a single stack).
#
# FOLLOW UP
# Implement a function popAt(int index) which performs a pop operation on a
# specific sub-stack.


class SetOfStacks(object):
    """
    Class of a set of stacks in which elements move to subsequent stacks when
    exceeds certain threshold.
    """

    def __init__(self, threshold=4):
        """
        Initialize class attributes.
        """
        self.threshold = threshold
        self.stack_set = []

    def push(self, element):
        """
        Add an item to the top of the stack.
        If stack is full, initialize a new stack.
        """

        if len(self.stack_set) is 0:
            stack = []
            stack.append(element)
            self.stack_set.append(stack)
        else:
            for stack in self.stack_set:
                if len(stack) < self.threshold:
                    stack.append(element)
                    return
            stack = []
            stack.append(element)
            self.stack_set.append(stack)
        return

    def pop(self):
        """
        Remove and return the topmost element from the stack.
        Return none if stack is empty.
        """
        if len(self.stack_set) is 0:
            return
        element = self.stack_set[-1][-1]
        self.stack_set[-1].pop()
        if len(self.stack_set[-1]) is 0:
            self.stack_set.pop()
        return element

    def pop_at(self, index):
        """
        Remove and return the topmost element from the stack at index.
        Return none if the stack is empty.
        """
        index -= 1  # index offset

        if len(self.stack_set) is 0:
            return
        try:
            element = self.stack_set[index][-1]
            self.stack_set[index].pop()

            # when stack at index is empty, remove stack.
            if len(self.stack_set[index]) is 0:
                for i in range(index+1, len(self.stack_set)):
                    self.stack_set[i-1] = self.stack_set[i]
                self.stack_set.pop()
            return element
        except IndexError:
            print "Stack does not exist."

    def print_stacks(self):
        """
        Print contents of stack set.
        """
        print self.stack_set


if __name__ == "__main__":
    test = SetOfStacks()
    test.push(1)
    test.push(2)
    test.push(3)
    test.push(4)
    test.push(5)
    test.push(6)
    test.push(7)
    test.push(8)
    test.push(9)
    test.pop()
    test.pop_at(1)
    test.pop_at(1)
    test.pop_at(1)
    test.pop_at(1)
    test.print_stacks()

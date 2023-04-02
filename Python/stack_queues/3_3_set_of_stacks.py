# Imagine a (literal) stack of plates, if the stack gets too high, it might
# topple. Therefore, in real lief, we would likely start a new stack when the
# previous stack exceeds some threshold. Implement a data structure SetOfStacks
# that mimics this. SetOfStacks would be composed of several stacks, and should
# create a new stack once the previous one exceeds capacity. SetOfStacks.push()
# and SetOfStacks.pop() should behave identically to a single stack(that is,
# pop() should return the same values as it would if there were just a single
# stack).


class SetOfStack(object):
    """

    SetOfStack class implements multiple stacks in which stack 1 gets filled up
    first. Once the stack is filled, values gets pushed to subsequent stacks.
    On pop, the value from the most recent stack is popped first. When stack
    is empty, we pop from the stack before.

    """
    THRESHOLD = 5

    def __init__(self):
        self.stacks = []

    def push(self, value):
        if len(self.stacks) < 1:
            self.stacks.append([value])
            return
        if len(self.stacks[-1]) >= self.THRESHOLD:
            self.stacks.append([value])
        else:
            self.stacks[-1].append(value)
        return

    def pop(self):
        popped = self.stacks[-1].pop()
        if len(self.stacks[-1]) < 1:
            self.stacks.pop()
        return popped

    def pop_at(self, index):
        """

        Pop the element at specific index.

        """
        if len(self.stacks[index]) < 1:
            return
        popped = self.stacks[index].pop()
        if index == len(self.stacks)-1:
            return popped
        for i in range(index, len(self.stacks)-1):
            # append to last operation
            self.stacks[i].append(self.stacks[i+1].pop(0))
        if len(self.stacks[-1]) < 1:
            self.stacks.pop()
        return popped

    def print_stacks(self):
        print self.stacks


if __name__ == "__main__":
    stacks = SetOfStack()
    stacks.push(1)
    stacks.push(2)
    stacks.push(3)
    stacks.push(4)
    stacks.push(5)
    stacks.push(6)
    stacks.push(7)
    stacks.push(8)
    stacks.push(9)
    stacks.push(10)
    stacks.push(11)
    stacks.push(12)
    stacks.print_stacks()
    stacks.pop_at(0)
    stacks.print_stacks()
    stacks.pop_at(1)
    stacks.print_stacks()

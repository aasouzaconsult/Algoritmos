# Describe how you could use a single array to implement three stacks.
# [1,2,3,4,5,6,7,8,9,10]
#      1       2     3


class Stack(object):
    def __init__(self):
        self.stack = []
        self.stack1 = 0
        self.stack2 = 0
        self.stack3 = 0

    def push(self, stack_num, value):
        self.stack.append(value)
        if stack_num is 1:
            self.stack1 += 1
            self.stack2 += 1
            self.stack3 += 1
        elif stack_num is 2:
            self.stack2 += 1
            self.stack3 += 1
        elif stack_num is 3:
            self.stack3 += 1
        return

    def pop(self, stack_num):
        if stack_num is 1:
            value = self.stack.pop(self.stack1)
            self.stack1 -= 1
            self.stack2 -= 1
            self.stack3 -= 1
        elif stack_num is 2:
            value = self.stack.pop(self.stack2)
            self.stack2 -= 1
            self.stack3 -= 1
        elif stack_num is 3:
            value = self.stack.pop()
            self.stack3 -= 1
        return value


if __name__ == "__main__":
    stack = Stack()
    stack.push(1, 1)
    stack.push(2, 2)
    stack.push(3, 3)
    stack.push(2, 4)
    print stack.stack
    print stack.stack1
    print stack.stack2
    print stack.stack3
    stack.pop(2)
    print stack.stack
    print stack.stack2
    print stack.stack3

##################################
### Title: Three Stacks   ########
### Author: GuoChen Hou   ########
##################################

# Describe how you could use a single array to implement three stacks.
#
# A typical array could have a structure like this:
# [0,1,2,3,4,5,6,7,8,9]
#
# To implement 3 stacks, we can 'chop' up the array into 3 pieces, separating
# them by indexes to mark the end of each stack.
# For example:
# total_size = 10
# stack_1_end = 3
# stack_2_end = 6
#
# This would mean stack 1 has size from index 0 to 3. stack 2 has size 4 to 6
# and stack 3 has size 7 to 9.
#
# Stack has 2 main functions, push and pop. In our case, the functions will
# take in an additional stack parameter, to indicate which stack it is
# referring to.
# push(stack_number, element)
# pop(stack_number)


class ThreeStacks:
    """
    Implementing three stack structure using a single array.
    """
    def __init__(self, total_size, stack_1_end, stack_2_end):
        """
        Initialize a list as a container for the 3 stacks.
        """
        self.total_size = total_size
        self.container = []
        for size in range(0, total_size):
            self.container.append(None)
        self.stack_1_end = stack_1_end
        self.stack_2_end = stack_2_end
        # version 2
        self.stack_1_pos = stack_1_end
        self.stack_2_pos = stack_2_end
        self.stack_3_pos = len(self.container) - 1

    def push(self, stack_number, element):
        """
        Add element to the stack given by stack number.
        """
        if stack_number is 1:
            # iterate through the stack in reverse order
            for index in range(self.stack_1_end, -1, -1):
                if self.container[index] is None:
                    self.container[index] = element
                    return
            return "Stack is Full."
        elif stack_number is 2:
            for index in range(self.stack_2_end, self.stack_1_end, -1):
                if self.container[index] is None:
                    self.container[index] = element
            return "Stack is Full."
        elif stack_number is 3:
            for index in range(len(self.container), self.stack_2_end, -1):
                if self.container[index] is None:
                    self.container[index] = element
            return "Stack is Full."
        else:
            return "Invalid stack number."

    def push_v2(self, stack_number, element):
        """
        Add element to the stack given by stack number.
        """
        if stack_number is 1:
            if self.stack_1_pos is not 0:
                self.container[self.stack_1_pos] = element
                self.stack_1_pos -= 1
                return
            else:
                return "Stack 1 is full."
        elif stack_number is 2:
            if self.stack_2_pos is not self.stack_1_pos:
                self.container[self.stack_2_pos] = element
                self.stack_2_pos -= 1
                return
            else:
                return "Stack 2 is full."
        elif stack_number is 3:
            if self.stack_3_pos is not self.stack_2_pos:
                self.container[self.stack_3_pos] = element
                self.stack_3_pos -= 1
                return
            else:
                return "Stack 3 is full."
        else:
            return "Invalid stack number."

    def pop(self, stack_number):
        """
        Remove the topmost element from the stack given by stack number and
        return the element.
        """
        value = None

        if stack_number is 1:
            for index in range(0, self.stack_1_end):
                if self.container[index] is not None:
                    value = self.container[index]
                    self.container[index] = None
                    return value
        elif stack_number is 2:
            for index in range(self.stack_1_end+1, self.stack_2_end+1):
                if self.container[index] is not None:
                    value = self.container[index]
                    self.container[index] = None
                    return value
        elif stack_number is 3:
            for index in range(self.stack_2_end+1, self.stack_3_end+1):
                if self.container[index] is not None:
                    value = self.container[index]
                    self.container[index] = None
                    return value
        else:
            return "Invalid stack number."

    def pop_v2(self, stack_number):
        """
        Remove the topmost element from t he stack given by stack number and
        return the element.
        """
        value = None

        if stack_number is 1:
            if self.stack_1_pos is not 0:
                value = self.container[self.stack_1_pos]
                self.container[self.stack_1_pos] = None
                return value
        elif stack_number is 2:
            if self.stack_2_pos is not self.stack_1_pos:
                value = self.container[self.stack_2_pos]
                self.container[self.stack_2_pos] = None
                return value
        elif stack_number is 3:
            if self.stack_3_pos is not self.stack_2_pos:
                value = self.container[self.stack_3_pos]
                self.container[self.stack_3_pos] = None
                return value
        else:
            return "Invalid stack number."

if __name__ = "__name__":
    pass

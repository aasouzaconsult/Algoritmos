##################################
### Title: Ascending Stack #######
### Author: GuoChen Hou   ########
##################################

# Write a program to sort a stack in ascending order. You should not
# make any assumptions about how the stack is implemented. The
# following are the only functions that should be used to write this program
# push | pop | peek | isEmpty.

# Sorting a stack using the typical stack given.
# Ascending order means the topmost of the stack has the smallest value and
# bottom having the largest.
# Since we are using python list structure to mimic a stack, their
# corresponding methods are:
# push() == append()
# pop() == pop()
# peek() == list[-1]
# isEmpty == len(list) < 1

# Sorting can be performed with one more stack. The idea is to pull an item
# from the original stack and push it on the other stack. If pushing this
# item would violate the sort order of the new stack, we need to remove
# enough items from it so that it's possible to push the new item. Since
# the items we removed are on the original stack, we're back where we started
# Time complexity is O(n^2)


def sort_stack(a_stack):
    """
    Sort a stack in ascending order with topmost of the stack having the
    smallest value and bottome having the largest value.
    Return the sorted stack.
    """
    if len(a_stack) < 1:
        return
    temp_stack = []
    while not len(a_stack) < 1:
        temp = a_stack.pop()
        while not len(temp_stack) < 1 and temp_stack[-1] < temp:
            a_stack.append(temp_stack.pop())
        temp_stack.append(temp)
    return temp_stack

if __name__ == "__main__":
    test_stack = []
    test_stack.append(1)
    test_stack.append(3)
    test_stack.append(5)
    test_stack.append(7)
    print test_stack
    sorted_stack = sort_stack(test_stack)
    print sorted_stack

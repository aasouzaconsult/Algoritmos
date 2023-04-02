# Write a program to sort a stack in ascending order. You should not make any
# assumptions about how the stack is implemented. The following are the only
# functions that should be used to write this program:
# push | pop | peek | is_empty
# ascending means smallest value at bottom of stack

# considering we use python list as a stack, the operations converted are:
# push: stack.append()
# pop: stack.pop()
# peek: stack[-1]
# is_empty: len(stack) < 1


def sort_stack(stack):
    if len(stack) < 1:
        return stack
    result = []
    while len(stack) > 0:
        if len(result) < 1:
            result.append(stack.pop())
            continue
        value = stack.pop()
        pop_count = 0
        while len(result) > 0:
            if value < result[-1]:
                stack.append(result.pop())
                pop_count += 1
            else:
                break
        result.append(value)
        for i in range(pop_count):
            result.append(stack.pop())
    return result


if __name__ == "__main__":
    stack = [5, 3, 6, 2, 12, 4]
    print sort_stack(stack)

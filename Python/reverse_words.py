# code a function that receives a string composed by words separated by spaces
# and returns a string where words appear in the same order to the original
# string, but every word is inverted.
# Example: "the boy ran"
# Output: "eht yob nar"
# Tell the complexity of the solution.


def reverse_words(a_string):
    """
    Takes in a string and put all words separated by spaces in reverse order
    ALgorithm runs in complexity O(n^2). Where n is size of string

    @return: the string in which the words are in reverse order.
    """

    # iterate through the string
    #    if ord(char) falls within A-Za-z
    #        put char in stack
    #        continue
    #    if stack is not empty and char is space:
    #        put char_space in stack
    #    while stack is not empty:
    #        pop from stack and append to string
    # return string
    if len(a_string) <= 1:
        return a_string
    result = ""
    stack = []
    for i in range(len(a_string)):
        print a_string[i]
        if ord(a_string[i]) >= 97 and ord(a_string[i]) <= 122:
            print a_string[i]
            stack.append(a_string[i])
            print stack
            continue
        while len(stack) > 0:
            result += stack.pop()
        if len(stack) is 0:
            result += " "
    while len(stack) > 0:
        result += stack.pop()

    return result

if __name__ == "__main__":
    test_string = "the boy ran"
    print reverse_words(test_string)

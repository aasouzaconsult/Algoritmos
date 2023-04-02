##############################################################################
# Author: GuoChen
# Title:  Unique Character search
# Problem: Implement an algorithm to determine if a string has all unique
#           characters. What if you can not use additional data structures.
##############################################################################

# Assumptions and Constraints:
# 1. Character can be any ASCII code character.
# 2. Length of string is at most 100 chars.
# 3. Should return True if string is unique, else False
# 4. Spaces does not count


# Using an additional list data structure
# time complexity O(n^2)
def is_unique(a_string):
    """
    Takes in a string and determines if the string has all unique characters.
    @return: True if all characters unique, else False.
    """

    if len(a_string) is 0:
        print "String is empty."
        return False
    chars = []
    for char in a_string:
        if char not in chars:
            chars.append(char)
        else:
            return False
    return True


# without using any additional list data structure
# time complexity O(n^2)
def is_unique2(a_string):
    """
    Takes in a string and determines if the string has all unique characters.
    @return: True if all characters unique, else False.
    """

    if len(a_string) is 0:
        print "String is empty."
        return False

    for i in range(len(a_string)):
        if a_string[i] in a_string[i+1:]:
            return False
    return True


# without using any additional list data structure
# time complexity O(n)
def is_unique3(a_string):
    """
    Takes in a string and determines if the string has all unique characters.
    @return: True if all characters unique, else False.
    """

    if len(a_string) is 0:
        print "String is empty."
        return False

    charset = [False] * 256

    for char in a_string:
        print char
        if charset[ord(char)]:
            return False
        charset[ord(char)] = True
    return True

if __name__ == "__main__":
    test_string = "john@gMail.cOm"
    print is_unique3(test_string)

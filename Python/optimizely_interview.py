# assumptions
# 1. string can be null
# 2. no limit to string size
# 3. if theres no palindrome with 2 or more chars,
#    return the first char in string


import unittest
import copy


def longest_palindrome(a_string):
    """
    Return the longest palindrome string from the given string.
    """
    temp = copy.deepcopy(a_string)
    shave_left = False
    while len(temp) > 0:
        if is_palindrome(temp):
            return temp
        if not shave_left:
            temp = temp[:-1]
            shave_left = True
        else:  # shave is True
            temp = temp[1:]
            shave_left = False


def is_palindrome(a_string):
    """
    Checks if the string is a palindrome.
    """
    if a_string == a_string[::-1]:
        return True
    return False


def longest_palindrome(a_string):
    """

    Find the longest contiguous substring of the input string that is a
    palindrome.

    """
    if len(a_string) < 1:
        return None
    if largest_palindrome_substring(a_string) is None:
        return a_string[0]
    else:
        return largest_palindrome_substring(a_string)


def largest_palindrome_substring(a_string):
    size = len(a_string)
    while size > 2:
        off = 0
        print a_string[:size]
        while off + size <= len(a_string):
            temp = a_string[off:off+size]
            print "temp is %s" % temp
            left = temp[:size/2]
            print left
            # determine odd or even
            if size % 2:
                right = temp[size - size/2:]
            else:
                right = temp[size/2:]

            if left[::-1] == right:
                return temp
            off += 1
        size -= 1

if __name__ == "__main__":
    test1 = "racecar"  # racecar
    test2 = "abacabde"  # bacab
    test3 = "raca"  # aca
    test4 = "abfad"  # a
    #print longest_palindrome(test1)
    #print longest_palindrome(test2)
    print longest_palindrome(test3)
    #print longest_palindrome(test4)

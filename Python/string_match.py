# find all the combinations of a string in lowercase and uppercase. For
# example, string "ab" -> "ab", "Ab", "aB", "AB". So, you will have 2^n
# (n = number of chars in the string) output strings. The goal is for you to
# test each of these string and see if it match a hidden string.

import itertools


def combinations(string1):
    string1 = string1.lower()
    result = []
    for i in xrange(len(string1)):
        number = 0
        while number <= len(string1):
            temp = convert_uppercase(string1, i, number)
            if temp not in result:
                result.append(temp)
            number += 1
    return result


def convert_uppercase(string1, index, number):
    """

    Given a string, convert number of chars in string to uppercase starting
    from index

    """
    i = 1
    j = index
    while i <= number:
        if j <= len(string1) - 1:
            string1 = string1[:j] + string1[j].upper() + string1[j+1:]
        i += 1
        j += 1
    return string1

if __name__ == "__main__":
    string1 = "abc"
    print combinations(string1)
    print map(''.join, itertools.product(*zip(string1.lower(), string1.upper())))

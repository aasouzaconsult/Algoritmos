##############################################################################
# Author: GuoChen
# Title:  Unique Character search
# Write a method to decide if two strings are anagrams or not.
##############################################################################

# Assumptions and constraints:
# 1. Character can be any ASCII code character.
# 2. Length of string is at most 100 chars.
# 3. Should return True if 2 strings are anagrams, else False
# 4. Spaces does not count


def is_anagram(string_1, string_2):
    """
    Takes a strings and test if they are anagrams of each other.
    @return: True if they are anagrams, else False.
    """

    if len(string_1) is 0 or len(string_2) is 0:
        print "One of the string is empty."
        return False

    # remove whitespaces and spaces in between
    string_1 = string_1.strip(" "). replace(" ", "")
    string_2 = string_2.strip(" "). replace(" ", "")

    charset = {}
    print string_1
    print string_2

    for char in string_1:
        if ord(char) in charset:
            charset[ord(char)] += 1
        else:
            charset[ord(char)] = 1
    print charset

    for char in string_2:
        if ord(char) not in charset or charset[ord(char)] is 0:
            return False
        else:
            charset[ord(char)] -= 1

    for key, value in charset.items():        
        if value is not 0:
            return False
    return True


if __name__ == "__main__":
    test_string1 = "   a  rmy"
    test_string2 = "ma ry     "
    print is_anagram(test_string1, test_string2)

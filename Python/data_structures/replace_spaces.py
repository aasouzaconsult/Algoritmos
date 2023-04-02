##############################################################################
# Author: GuoChen
# Title:  Unique Character search
# Problem: Write a method to replace all spaces in a string with '%20'.
##############################################################################

# Assumptions and Constraints:
# 1. no use of native library function is allowed.


def replace_spaces(a_string):
    """
    Replaces all space characters with '%20'.
    @return: string which replaced spaces with '%20'.
    """
    ASCII_SPACE = ord(" ")

    i = 0
    while i < len(a_string):
        if ord(a_string[i]) is ASCII_SPACE:
            a_string = a_string[:i] + "%20" + a_string[i+1:]
            i += 3
        else:
            i += 1
    return a_string


if __name__ == "__main__":
    test_string = "a p p  l e"
    print len(test_string)
    result = test_string.replace(" ", "%20")
    print result
    print replace_spaces(test_string)

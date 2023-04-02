# Design an algorithm and write code to remove the duplicate characters in
# a string without using any additional buffer.
# NOTE: One or two additional varables are fine. An extra copy of the array is
# not.
#
# Requirements:
# 1. Cannot use additional buffers.
# 2. length of string is 1million and above.
# 3. spaces do not count.
# 4. uppercase and lowercase characters are considered different.


def remove_duplicates(a_string):
    """
    Removes duplicate characters in a string.
    """

    if len(a_string) is 0:
        print "String is empty."
        return a_string

    # remove whitespaces and spaces in between
    a_string = a_string.strip(" ").replace(" ", "")

    charset = [False] * 256
    print a_string
    i = 0
    while i <= len(a_string) - 1:
        if charset[ord(a_string[i])]:
            print "%s duplicate found. going to remove." % a_string[i]
            print a_string[:i]
            print a_string[i+1:]
            a_string = a_string[:i] + a_string[i+1:]
            print a_string
            i -= 1  # character removed, so string size shrunk by 1
        else:
            print "%s is found. saved to charset" % a_string[i]
            charset[ord(a_string[i])] = True
        i += 1
    return a_string


if __name__ == "__main__":
    test_string = "    apple pear"
    print test_string
    remove_duplicates(test_string)

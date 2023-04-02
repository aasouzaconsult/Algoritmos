def reverse_string(a_string):
    """
    Takes in a string and return the reverse of the string.
    """

    return a_string[::-1]

if __name__ == "__main__":
    test_string = "abcd\0"
    print test_string
    print len(test_string)
    print reverse_string(test_string)
    print len(reverse_string(test_string))

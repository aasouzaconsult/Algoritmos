def replace_space(a_string):
    """

    Write a method to replace all spaces in a string with %20.

    """
    if len(a_string) < 1:
        return a_string
    result = ""
    for char in a_string:
        if char == " ":
            result += "%20"
        else:
            result += char
    return result


if __name__ == "__main__":
    test = "the quick brown fox jumps over the wall"
    print replace_space(test)
    print test.replace(" ", "%20")

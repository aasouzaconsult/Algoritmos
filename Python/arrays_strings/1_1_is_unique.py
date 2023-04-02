# Implement an algorithm to determine if a string has all unique characters.
# What if you can not use additional data structures?


def is_unique(string):
    new_string = ""
    for item in string:
        if item not in new_string:
            new_string += item
    if string == new_string:
        return True
    return False


def is_unique2(string):
    for i in range(len(string)):
        if string[i] in string[i+1:]:
            return False
    return True


if __name__ == "__main__":
    test = "abcdefg"
    test2 = "aabcde"
    test3 = "cdbefgg"
    test4 = "gneken"
    test5 = "23514"
    print is_unique(test)
    print is_unique(test5)
    print is_unique(test2)
    print is_unique(test3)
    print is_unique(test4)
    print is_unique2(test)
    print is_unique2(test2)
    print is_unique2(test3)
    print is_unique2(test4)

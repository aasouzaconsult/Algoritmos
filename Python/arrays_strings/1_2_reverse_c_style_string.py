# Write code to reverse a c style string. (C-string means that "abcd" is
# represented as five characters, including the null character.)


def reverse_string(c_string):
    if c_string == "":
        return None
    reverse = c_string[:-1]
    return reverse[::-1] + '\0'


if __name__ == "__main__":
    test = "abc\0"
    print reverse_string(test)

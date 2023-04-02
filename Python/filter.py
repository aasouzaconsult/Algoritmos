import unittest


def char_filter(target, filter_string):
    """

    Given a string, remove all chars from the string that are present in say
    another string called filter.

    """
    # declare result string
    result = ""
    # pass filter_string into an array
    char_filter = list(filter_string)
    print char_filter
    # loop through target string and add char if string is not present in
    # filter array
    for char in target:
        if char not in char_filter:
            result += char
    # return result
    return result


class CharFilterTestCase(unittest.TestCase):
    """

    Test case for char_filter function.

    """
    def setUp(self):
        self.string1 = "abcdefghijkmnopqrstuvwxyz"
        self.filter_string = "acexyz"

    def test_char_filter(self):
        self.assertEqual(char_filter(self.string1, self.filter_string),
                         "bdfghijkmnopqrstuvw")

if __name__ == "__main__":
    string1 = "abcdefghijkmnopqrstuvwxyz"
    filter_string = "acexyz"
    print char_filter(string1, filter_string)
    unittest.main()

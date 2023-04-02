import unittest


def remove_duplicates(a_string):
    """

    Design an algorithm and write code to remove the duplicate characters in a
    string without using any additional buffer. NOTE: One or two additional
    variables are fine. An extra copy of the array is not.

    """
    if a_string == "":
        return a_string

    result = ""
    for i in range(len(a_string)):
        #  char is not seen after itself
        if a_string[i] not in a_string[i+1:]:
            result += a_string[i]
    return result


class RemoveDuplicatesTestCase(unittest.TestCase):
    def setUp(self):
        self.str1 = "abcd"
        self.str2 = "aaa"
        self.str3 = ""
        self.str4 = "aaabbbb"

    def test_remove_duplicates(self):
        self.assertEqual(remove_duplicates(self.str1), 'abcd')
        self.assertEqual(remove_duplicates(self.str2), 'a')
        self.assertEqual(remove_duplicates(self.str3), '')
        self.assertEqual(remove_duplicates(self.str4), 'ab')

if __name__ == "__main__":
    str1 = "abcd"
    str2 = "aaa"
    str3 = ""
    str4 = "aaabbbb"
    print remove_duplicates(str1)
    print remove_duplicates(str2)
    print remove_duplicates(str3)
    print remove_duplicates(str4)
    unittest.main()

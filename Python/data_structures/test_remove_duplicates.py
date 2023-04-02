import unittest
from remove_duplicates import remove_duplicates


class TestRemoveDuplicates(unittest.TestCase):

    def test_no_duplicates(self):
        test = "abcd"
        self.assertEqual(remove_duplicates(test), "abcd")

    def test_all_duplicates(self):
        test = "aaa"
        self.assertEqual(remove_duplicates(test), "a")

    def test_null_string(self):
        test = ""
        self.assertEqual(remove_duplicates(test), "")

    def test_continuous_duplicates(self):
        test = "aaabbbcccddd"
        self.assertEqual(remove_duplicates(test), "abcd")


if __name__ == '__main__':
    unittest.main()

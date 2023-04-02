import unittest
import linked_list_1


class LinkedListTestCase(unittest.TestCase):
    def setUp(self):
        self.test = linked_list_1.LinkedList(0)
        self.test.insert(1)
        self.test.insert(2)
        self.test.insert(3)
        self.test.insert(4)

    def test_insert(self):
        self.assertEquals(self.test.get_list(), [4, 3, 2, 1, 0])

    def test_search(self):
        self.assertEquals(self.test.search(2), 2)
        self.assertEquals(self.test.search(3), 3)
        self.assertEquals(self.test.search(0), 0)

    def test_delete(self):
        self.test.delete(0)
        self.assertEquals(self.test.get_list(), [4, 3, 2, 1])
        self.test.delete(2)
        self.assertEquals(self.test.get_list(), [4, 3, 1])
        self.test.delete(4)
        self.assertEquals(self.test.get_list(), [3, 1])


if __name__ == "__main__":
    unittest.main()

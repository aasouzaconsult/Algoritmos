import unittest
import selection_sort_1
import selection_sort_2
import selection_sort_3
import selection_sort_4
import selection_sort_5
import selection_sort_6
import selection_sort_7
import selection_sort_8
import selection_sort_9
import selection_sort_10


class TestSelectionSort1(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_1.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_1.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestSelectionSort2(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_2.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_2.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestSelectionSort3(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_3.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_3.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestSelectionSort4(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_4.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_4.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestSelectionSort5(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_5.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_5.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestSelectionSort6(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_6.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_6.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestSelectionSort7(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_7.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_7.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestSelectionSort8(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_8.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_8.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestSelectionSort9(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_9.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_9.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestSelectionSort10(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(selection_sort_10.selection_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(selection_sort_10.selection_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

if __name__ == "__main__":
    unittest.main()

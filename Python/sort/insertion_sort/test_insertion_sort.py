import unittest
import insertion_sort_1
import insertion_sort_2
import insertion_sort_3
import insertion_sort_4
import insertion_sort_5
import insertion_sort_6
import insertion_sort_7
import insertion_sort_8
import insertion_sort_9
import insertion_sort_10


class TestInsertionSort1(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_1.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_1.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestInsertionSort2(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_2.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_2.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestInsertionSort3(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_3.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_3.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestInsertionSort4(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_4.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_4.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestInsertionSort5(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_5.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_5.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestInsertionSort6(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_6.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_6.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestInsertionSort7(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_7.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_7.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestInsertionSort8(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_8.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_8.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestInsertionSort9(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_9.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_9.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestInsertionSort10(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_selection_sort_1(self):
        self.assertEquals(insertion_sort_10.insertion_sort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_selection_sort_2(self):
        self.assertEquals(insertion_sort_10.insertion_sort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

if __name__ == "__main__":
    unittest.main()

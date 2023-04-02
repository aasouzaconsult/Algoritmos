import unittest
import quicksort_1
import quicksort_2
import quicksort_3
import quicksort_4
import quicksort_5
import quicksort_6
import quicksort_7
import quicksort_8
import quicksort_9
import quicksort_10


class TestQuickSort1(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_1.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_1.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestQuickSort2(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_2.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_2.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestQuickSort3(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_3.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_3.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestQuickSort4(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_4.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_4.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestQuickSort5(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_5.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_5.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestQuickSort6(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_6.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_6.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestQuickSort7(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_7.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_7.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestQuickSort8(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_8.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_8.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestQuickSort9(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_9.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_9.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])


class TestQuickSort10(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]

    def test_quicksort_1(self):
        self.assertEquals(quicksort_10.quicksort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(quicksort_10.quicksort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

if __name__ == "__main__":
    unittest.main()

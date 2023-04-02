import unittest
import mergesort_1
import mergesort_2
import mergesort_3
import mergesort_4
import mergesort_5
import mergesort_6
import mergesort_7
import mergesort_8
import mergesort_9
import mergesort_10


class TestMergeSort1(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_1.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_1.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_1.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_1.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])


class TestMergeSort2(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_2.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_2.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_2.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_2.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])


class TestMergeSort3(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_3.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_3.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_3.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_3.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])


class TestMergeSort4(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_4.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_4.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_4.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_4.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])


class TestMergeSort5(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_5.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_5.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_5.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_5.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])


class TestMergeSort6(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_6.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_6.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_6.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_6.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])


class TestMergeSort7(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_7.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_7.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_7.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_7.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])


class TestMergeSort8(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_8.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_8.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_8.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_8.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])


class TestMergeSort9(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_9.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_9.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_9.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_9.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])


class TestMergeSort10(unittest.TestCase):
    def setUp(self):
        self.test1 = [64, 25, 12, 22, 11]
        self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
        self.test3 = [11, 12, 43, 3, 7, 29]
        self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]

    def test_quicksort_1(self):
        self.assertEquals(mergesort_10.mergesort(self.test1),
                          [11, 12, 22, 25, 64])

    def test_quicksort_2(self):
        self.assertEquals(mergesort_10.mergesort(self.test2),
                          [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19, 19])

    def test_quicksort_3(self):
        self.assertEquals(mergesort_10.mergesort(self.test3),
                          [3, 7, 11, 12, 29, 43])

    def test_quicksort_4(self):
        self.assertEquals(mergesort_10.mergesort(self.test4),
                          [17, 20, 26, 31, 44, 54, 55, 77, 93])

if __name__ == "__main__":
    unittest.main()

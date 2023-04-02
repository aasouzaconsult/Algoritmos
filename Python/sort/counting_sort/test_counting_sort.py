import unittest
import counting_sort_1
import counting_sort_2
import counting_sort_3
import counting_sort_4
import counting_sort_5
import counting_sort_6
import counting_sort_7
import counting_sort_8
import counting_sort_9
import counting_sort_10


class TestCountingSort1(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_1.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_1.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_1.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_1.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_1.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_1.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])


class TestCountingSort2(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_2.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_2.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_2.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_2.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_2.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_2.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])


class TestCountingSort3(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_3.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_3.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_3.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_3.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_3.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_3.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])


class TestCountingSort4(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_4.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_4.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_4.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_4.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_4.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_4.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])


class TestCountingSort5(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_5.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_5.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_5.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_5.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_5.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_5.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])


class TestCountingSort6(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_6.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_6.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_6.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_6.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_6.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_6.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])


class TestCountingSort7(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_7.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_7.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_7.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_7.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_7.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_7.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])


class TestCountingSort8(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_8.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_8.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_8.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_8.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_8.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_8.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])


class TestCountingSort9(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_9.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_9.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_9.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_9.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_9.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_9.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])


class TestCountingSort10(unittest.TestCase):
        def setUp(self):
                self.test1 = [64, 25, 12, 22, 11]
                self.test2 = [18, 4, 11, 4, 2, 19, 8, 14, 13, 18, 14, 17, 19]
                self.test3 = [11, 12, 43, 3, 7, 29]
                self.test4 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
                self.test5 = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
                self.test6 = [2, 5, 3, 0, 2, 3, 0, 3]

        def test_counting_sort_1(self):
            self.assertEquals(counting_sort_10.counting_sort(self.test1, 64),
                              [11, 12, 22, 25, 64])

        def test_counting_sort_2(self):
            self.assertEquals(counting_sort_10.counting_sort(self.test2, 19),
                              [2, 4, 4, 8, 11, 13, 14, 14, 17, 18, 18, 19,
                              19])

        def test_counting_sort_3(self):
            self.assertEquals(counting_sort_10.counting_sort(self.test3, 43),
                              [3, 7, 11, 12, 29, 43])

        def test_counting_sort_4(self):
            self.assertEquals(counting_sort_10.counting_sort(self.test4, 93),
                              [17, 20, 26, 31, 44, 54, 55, 77, 93])

        def test_counting_sort_5(self):
            self.assertEquals(counting_sort_10.counting_sort(self.test5, 6),
                              [0, 0, 1, 1, 2, 2, 3, 3, 4, 6])

        def test_counting_sort_6(self):
            self.assertEquals(counting_sort_10.counting_sort(self.test6, 5),
                              [0, 0, 2, 2, 3, 3, 3, 5])

if __name__ == "__main__":
    unittest.main()

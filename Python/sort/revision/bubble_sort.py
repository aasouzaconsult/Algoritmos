import unittest


def bubble_sort(a_list):
    """

    Sort *a_list* by bubble sort technique.

    Time Complexity:
    Best: O(n)
    Average: O(n^2)
    Worst: O(n^2)

    Space Complexity: O(1)
    """
    # check list has at least 2 items
    if len(a_list) < 2:
        return a_list
    # iterate through the list starting from 2nd element
    #   if item is less than previous:
    #       swap item and previous
    #       set swap to True

    while True:
        # declare swapping flag
        swap = False
        for i in range(1, len(a_list)):
            if a_list[i] < a_list[i-1]:
                a_list[i], a_list[i-1] = a_list[i-1], a_list[i]
                swap = True
        if not swap:
            break
    # return a_list
    return a_list


class BubbleSortTestCase(unittest.TestCase):
    """

    Unittest for bubble_sort.

    """
    def setUp(self):
        self.test = [3, 7, 4, 9, 5, 2, 6, 1]

    def test_bubble_sort(self):
        self.assertEqual(bubble_sort(self.test), [1, 2, 3, 4, 5, 6, 7, 9])

if __name__ == "__main__":
    test = [3, 7, 4, 9, 5, 2, 6, 1]
    print bubble_sort(test)
    unittest.main()

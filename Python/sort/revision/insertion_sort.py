import unittest


def insertion_sort(a_list):
    """

    Sort *a_list* by insertion sort technique.

    Time Complexity:
    Best: O(n)
    Average: O(n^2)
    Worst: O(n^2)

    Space Complexity: O(1)
    """
    # check that list has 2 or more elements
    if len(a_list) < 2:
        return a_list
    # iterate throught the list starting from 2nd element
    #   while each item in list is less than previous element
    #       swap item with previous element
    # return the list
    for i in range(1, len(a_list)):
        j = i
        while a_list[j] < a_list[j-1] and j > 0:
            a_list[j], a_list[j-1] = a_list[j-1], a_list[j]
            j -= 1
    return a_list


class InsertionSortTestCase(unittest.TestCase):
    def setUp(self):
        self.test = [3, 7, 4, 9, 5, 2, 6, 1]

    def test_insertion_sort_success(self):
        self.assertEqual(insertion_sort(self.test), [1, 2, 3, 4, 5, 6, 7, 9])

if __name__ == "__main__":
    test = [3, 7, 4, 9, 5, 2, 6, 1]
    print insertion_sort(test)
    unittest.main()

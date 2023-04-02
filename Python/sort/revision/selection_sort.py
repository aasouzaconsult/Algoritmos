import unittest


def selection_sort(a_list):
    """

    Sort *a_list* by selection sort technique

    Time Complexity:
    Best: O(n^2)
    Average: O(n^2)
    Worst: O(n^2)

    Space Complexity: O(1)
    """
    # check list has at least 2 elements
    if len(a_list) < 2:
        return a_list
    # iterate through the list
    #   smallest = i
    #   for each subsequent element in list:
    #       if item is less than smallest:
    #           smallest = current item index
    #   if smallest != i:
    #       swap smallest in list and ith element
    for i in range(len(a_list)):
        smallest = i
        for j in range(i+1, len(a_list)):
            if a_list[j] < a_list[smallest]:
                smallest = j
        if smallest != i:
            a_list[smallest], a_list[i] = a_list[i], a_list[smallest]
    return a_list


class SelectionSortTestCase(unittest.TestCase):
    """

    Test cases for selection_sort.

    """
    def setUp(self):
        self.test = [3, 7, 4, 9, 5, 2, 6, 1]

    def test_selection_sort(self):
        self.assertEqual(selection_sort(self.test), [1, 2, 3, 4, 5, 6, 7, 9])

if __name__ == "__main__":
    test = [3, 7, 4, 9, 5, 2, 6, 1]
    print selection_sort(test)
    unittest.main()

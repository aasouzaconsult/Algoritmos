import unittest


def quick_sort(a_list):
    """

    Sort *a_list* using quicksort technique.

    Time Complexity:
    Best: O(n log(n))
    Average: O(n log(n))
    Worst: O(n^2)

    Space Complexity: O(log(n))
    """
    # check list has at least 2 elements
    if len(a_list) < 2:
        return a_list
    return quicksort_recur(a_list, 0, len(a_list)-1)


def quicksort_recur(a_list, start, end):
    # pick the last list element as pivot to array
    # recursively sort the left of pivot
    # recursively sort the right of pivot
    if start < end:
        partition_index = partition(a_list, start, end)
        quicksort_recur(a_list, start, partition_index)
        quicksort_recur(a_list, partition_index+1, end)
    return a_list


def partition(a_list, start, end):
    value = a_list[start]
    h = start

    for k in range(start+1, len(a_list)):
        if a_list[k] < value:
            h += 1
            # swap between value at partition index and value at index k
            a_list[h], a_list[k] = a_list[k], a_list[h]
    # swap values between index at partition index and h
    a_list[start], a_list[h] = a_list[h], a_list[start]
    return h


class QuickSortTestCase(unittest.TestCase):
    def setUp(self):
        self.test = [3, 7, 4, 9, 5, 2, 6, 1]

    def test_quick_sort(self):
        self.assertEqual(quick_sort(self.test), [1, 2, 3, 4, 5, 6, 7, 9])

if __name__ == "__main__":
    test = [3, 7, 4, 9, 5, 2, 6, 1]
    print quick_sort(test)
    unittest.main()

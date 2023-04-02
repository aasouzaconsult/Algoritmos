import unittest


def merge_sort(a_list):
    """

    Sorts *a_list* using mergesort technique.

    Time Complexity:
    Best: O(n log(n))
    Average: O(n log(n))
    Worst: O(n log(n))

    Space Complexity: O(n)

    """
    # check a_list has at least 2 elements
    if len(a_list) < 2:
        return a_list
    # initialize left, right lists
    left, right = list(), list()
    # set mid pointer to list
    mid = len(a_list) / 2
    # set left list
    left = a_list[:mid]
    # set right list
    right = a_list[mid:]
    # recursively sort left list
    left = merge_sort(left)
    # recursively sort right list
    right = merge_sort(right)
    # merge left and right lists and return the merged list
    return merge(left, right)


def merge(left_list, right_list):
    """

    Merge receives as inputs left_list and right_list are each
    sorted in nondecreasing order, the two arrays are merged into a
    single nondecreasing array.

    """
    # initialize result array
    result = []
    # set i and j current pointers to each array
    i, j = 0, 0
    # while left and right list is not exhausted
    #   if left item less than equal right:
    #       add left item to result
    #       increment left current pointer
    #   else:
    #       add right item to result
    #       increment right current pointer
    while i < len(left_list) and j < len(right_list):
        if left_list[i] <= right_list[j]:
            result.append(left_list[i])
            i += 1
        else:
            result.append(right_list[j])
            j += 1
    # append remaining left and right elements to result
    result.extend(left_list[i:])
    result.extend(right_list[j:])
    # return result
    return result


class MergeSortTestCase(unittest.TestCase):
    def setUp(self):
        self.num_list = [14, 20, 36, 10, 12, 30, 40, 44]

    def test_merge_sort(self):
        self.assertEqual(merge_sort(self.num_list),
                         [10, 12, 14, 20, 30, 36, 40, 44])

if __name__ == "__main__":
    num_list = [14, 20, 36, 10, 12, 30, 40, 44]
    print merge_sort(num_list)
    unittest.main()

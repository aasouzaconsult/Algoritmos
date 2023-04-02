# Insertion sort


def insertion_sort(array):
    """

    Divides array in 2 sub lists, sorted on the left and unsorted on the right.
    For each element in the unsorted list, compare with the sorted element in
    right to left order. if unsorted element less than sorted element, swap
    them and compare with the next sorted element.

    """
    # traverse the array starting from 2nd element
    for i in xrange(1, len(array)):
    #   initialize j element to equal i
        j = i
    #   while j is not out of bounds and j element is less than j-1 element
        while j > 0 and array[j] < array[j-1]:
    #       swap j and j-1 element
            array[j], array[j-1] = array[j-1], array[j]
    #       decrement j
            j -= 1
    # return array
    return array

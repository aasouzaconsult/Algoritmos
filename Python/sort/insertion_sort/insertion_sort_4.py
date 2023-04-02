# insertion sort


def insertion_sort(array):
    """

    Divides array into sorted and unsorted element sublist. For each element in
    unsorted elements, compare with sorted elements from right to left and swap
    them if unsorted element is lesser than sorted element and compare with
    next element.

    """
    # traverse the array from 2nd item
    for i in xrange(1, len(array)):
    #   initialize j to current element
        j = i
    #   while j element is less than j-1 element
        while j > 0 and array[j] < array[j-1]:
    #       swap j element and j-1
            array[j], array[j-1] = array[j-1], array[j]
    #       decrement j
            j -= 1
    # return array
    return array

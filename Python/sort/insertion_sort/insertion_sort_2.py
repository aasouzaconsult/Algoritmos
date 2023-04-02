# insertion sort


def insertion_sort(array):
    """

    Divides the array into 2 sublists, sorted and unsorted. Left sublist
    contains sorted elements, right sublist contains unsorted elements.
    For each element in unsorted list, compare with sorted list elements from
    right to left. if unsorted element is less than sorted element, swap their
    position and compare with next sorted element.

    """
    # traverse the array starting from 2nd element
    for i in xrange(1, len(array)):
    #   initialize j equal current index
        j = i
    #   while j element less than previous element
        while j > 0 and array[j] < array[j-1]:
    #       swap j and j-1 element
            array[j], array[j-1] = array[j-1], array[j]
    #       decrement j
            j -= 1
    # return array
    return array

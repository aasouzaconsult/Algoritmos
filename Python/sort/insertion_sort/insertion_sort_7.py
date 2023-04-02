# insertion sort


def insertion_sort(array):
    """

    Divide array into unsorted and sorted sublist. For each element in unsorted
    element compare with sorted element from right to left and swap if unsorted
    element is smaller then compare with next sorted element.

    """
    for i in xrange(1, len(array)):
        j = i
        while j > 0 and array[j] < array[j-1]:
            array[j], array[j-1] = array[j-1], array[j]
            j -= 1
    return array

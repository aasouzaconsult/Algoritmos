# selection sort


def selection_sort(array):
    """

    Divides the array in 2 sublist, sorted and unsorted. Left sublist contains
    list of sorted elements, right sublist contains list of unsorted elements.
    Find the least element and put in sorted sublist.

    """
    # traverse the array
    for i in xrange(len(array)):
    #   initialize min_index
        min_index = i
    #   traverse the unsorted sublist, update min index
        for j in xrange(i+1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
    #   swap current with min index value
        array[i], array[min_index] = array[min_index], array[i]
    # return array
    return array

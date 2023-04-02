# selection sort


def selection_sort(array):
    """

    Divides the array into sorted and unsorted sublist. Left sublist contains
    sorted list of elements, right sublist contains unsorted list of elements.
    Find the least element and put in sorted sublist.

    """
    # traverse the array
    for i in xrange(len(array)):
    #   initialize min index
        min_index = i
    #   find min index in unsorted list
        for j in xrange(i+1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
    #   swap current and min index
        array[i], array[min_index] = array[min_index], array[i]
    # return array
    return array

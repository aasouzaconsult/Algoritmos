# selection sort


def selection_sort(array):
    """

    Divides the array into unsorted and sorted sublist. Left sublist contains
    list of sorted elements, right sublist contains list of unsorted elements.
    Find the least element in unsorted list and put in sorted list.

    """
    # traverse the array
    for i in xrange(len(array)):
    #   initialize min index
        min_index = i
    #   find the least element in unsorted list and update min index
        for j in xrange(i+1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
    #   swap current element with min index value
        array[i], array[min_index] = array[min_index], array[i]
    # return array
    return array

# Selection sort


def selection_sort(array):
    """

    Divides the list into two parts, sorted and unsorted. Left sublist contains
    the sorted list of elements, right sublist contained unsorted list of
    elements. Each time the pointer traverses the unsorted part of element,
    finds the least element and place it in sorted part of list.

    """
    # traverse the array
    for i in xrange(len(array)):
    #   initialize min_index
        min_index = i
    #   traverse the unsorted part to find min value index
        for j in xrange(i+1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
    #   if min_index changes, swap current with min index
        array[i], array[min_index] = array[min_index], array[i]
    # return array
    return array

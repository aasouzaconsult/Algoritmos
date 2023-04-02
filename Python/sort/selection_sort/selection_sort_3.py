# selection sort


def selection_sort(array):
    """

    Divides the list into 2 parts, sorted and unsorted. Left sublist contains
    list of sorted elements, right sublist contains list of unsorted elements.
    Find the least element and place it in sorted part of list.

    """
    # traverse the array
    for i in xrange(len(array)):
    #   initialize min index
        min_index = i
    #   traverse the unsorted part of list and update min index
        for j in xrange(i+1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
    #   swap min index value with current value
        array[i], array[min_index] = array[min_index], array[i]
    # return array
    return array

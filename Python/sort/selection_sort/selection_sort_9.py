# selection sort


def selection_sort(array):
    """

    Divides the array into sorted and unsorted sublist. Left sublist contains
    sorted elements, right sublist contains unsorted elements. Find the least
    element in unsorted sublist and put in sorted sublist.

    """
    # traverse the array
    for i in xrange(len(array)):
    #   initialize the min index
        min_index = i
    #   find the least element in unsorted list and update min index
        for j in xrange(i+1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
    #   swap min index value with current
        array[i], array[min_index] = array[min_index], array[i]
    # return array
    return array

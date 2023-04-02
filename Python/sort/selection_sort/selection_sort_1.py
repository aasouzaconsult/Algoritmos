# Selection sort


def selection_sort(array):
    """
    Divides the list into two parts: sorted and unsorted. Left sublist
    contains the sorted list of elements, right unsorted. Each time the
    pointer traverses the unsorted part of element, finds the least element
    and place it in the sorted part of the list.
    """
    # traverse the entire list
    for i in xrange(len(array)):
    #   initialize the min index to current index
        min_index = i
    #   traverse the next element to end, update the min index if smaller than
    #   current
        for j in xrange(i+1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
    #   swap min index element with current element
        if min_index != i:
            array[min_index], array[i] = array[i], array[min_index]
    # return array
    return array

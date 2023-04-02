# selection sort


def selection_sort(array):
    """

    Divides the array into unsorted and sorted sublist. Left sublist contains
    list of sorted elements, right sublist contains list of unsorted elements.
    Find the min value in unsorted sublist and put in sorted sublist.

    """
    # traverse the array
    for i in xrange(len(array)):
    #   initialize the min_index
        min_index = i
    #   find the least index element in unsorted elements and update index
        for j in xrange(i+1, len(array)):
            if array[j] < array[min_index]:
                min_index = j
    #   swap current index with min index value
        array[i], array[min_index] = array[min_index], array[i]
    # return array
    return array

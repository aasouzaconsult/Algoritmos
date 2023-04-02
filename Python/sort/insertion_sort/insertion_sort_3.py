# insertion sort


def insertion_sort(array):
    """

    Divide the array into unsorted and sorted sublist. For each element in
    unsorted sublist, compare with sorted elements from right to left and swap
    elements if unsorted element is smaller and compare with next element.

    """
    # traverse the array
    for i in xrange(1, len(array)):
    #   initialize j to current index
        j = i
    #   while j element is less than prev element
        while j > 0 and array[j] < array[j-1]:
    #       swap j and j-1 element
            array[j], array[j-1] = array[j-1], array[j]
    #       decrement j
            j -= 1
    # return array
    return array

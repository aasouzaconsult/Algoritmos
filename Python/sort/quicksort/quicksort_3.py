# quicksort


def quicksort(array):
    """

    Quicksort selects a pivot element and splits the remaining n-1 items into
    two sublists. Left sublist contains all elements less than pivot element,
    right sublist contains elements more than pivot element in sorted order.
    Then we merge the left and right sublist by joining pivot element in
    between them.

    """
    return _quicksort(array, 0, len(array))


def _quicksort(array, low, high):
    if low < high:
        pivot = partition(array, low, high)
        _quicksort(array, low, pivot)
        _quicksort(array, pivot+1, high)
    return array


def partition(array, low, high):
    # initialize pivot index
    pivot = high-1
    # initialize first high index
    first_high = low
    # iterate array from low to high
    for i in xrange(low, high):
    #   if current item is less than pivot
    #       swap current with first_high index
    #       increment first_high
        if array[i] < array[pivot]:
            array[i], array[first_high] = array[first_high], array[i]
            first_high += 1
    # swap first high index element with pivot value
    array[pivot], array[first_high] = array[first_high], array[pivot]
    # return first_high index
    return first_high

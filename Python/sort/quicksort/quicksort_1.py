# quicksort


def quicksort(array):
    """

    Quicksort selects a pivot element and splits the remaining n-1 elements
    into 2 sublists. Left sublist contains all elements appearing before the
    pivot and right sublist contains all elements appearing after pivot in
    sorted order. Then we merge the left and right sublist by placing pivot in
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
    # set pivot to high element
    pivot = high-1
    # initialize pivot eventual index
    first_high = low
    # iterate through array from low until high element
    for i in xrange(low, high):
    #   if current item is less then pivot, swap with first_high index
        if array[i] < array[pivot]:
            array[i], array[first_high] = array[first_high], array[i]
    #   increment first_high
            first_high += 1
    # swap pivot and first high element
    array[pivot], array[first_high] = array[first_high], array[pivot]
    # return pivot index
    return first_high

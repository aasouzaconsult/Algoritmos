# quicksort


def quicksort(array):
    """

    Quicksort selects a pivot element and splits the remaining n-1 items into
    two sublists. Left sublist contains all elements appearing before the pivot
    and the right sublist contains all elements appear after pivot in sorted
    order. Then we merge the left and right sublist by placing pivot element in
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
    # set pivot to last element
    pivot = high-1
    # set ending position where pivot element is in sorted array
    first_high = low
    # iterate through array until before last element
    for i in xrange(low, high):
        # if current element less than pivot, swap and increment first_high
        # index
        if array[i] < array[pivot]:
            array[i], array[first_high] = array[first_high], array[i]
            first_high += 1
    # swap pivot element with first high index element
    array[pivot], array[first_high] = array[first_high], array[pivot]
    # return the pivot index position
    return first_high

# quicksort


def quicksort(array):
    """

    Quicksort chooses an array element as pivot and splits the remaining n-1
    elements into 2 sublists. Left sublist contains elements to the left of
    pivot in eventual position and right sublist contains elements to the right
    of pivot element. Then we merge left and right sublists, placing pivot in
    betweeen. We perform this step recursively for left and right sublist until
    all sublists are sorted.

    """
    return _quicksort(array, 0, len(array))


def _quicksort(array, low, high):
    if low < high:
        pivot = partition(array, low, high)
        _quicksort(array, low, pivot)
        _quicksort(array, pivot+1, high)
    return array


def partition(array, low, high):
    # init pivot index
    # init first high index
    # iterate through low to high
    #   if current element less than pivot
    #       swap current element with first high
    #       increment first high
    # swap first high index with pivot index element
    # return first high index
    pivot = high-1
    first_high = low
    for i in xrange(low, high):
        if array[i] < array[pivot]:
            array[i], array[first_high] = array[first_high], array[i]
            first_high += 1
    array[pivot], array[first_high] = array[first_high], array[pivot]
    return first_high

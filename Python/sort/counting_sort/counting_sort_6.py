# counting sort


def counting_sort(array, num_range):
    """

    Counting sort takes an array and with num range that numbers lie in. Each
    occurence of number is stored in an aux array. Then sum the aux array in
    increasing order. Then iterate through the array in reverse and put
    elements in their sorted position.

    """
    # init result
    result = [0 for _ in array]
    # init histogram
    histogram = [0 for _ in xrange(num_range+1)]
    # iterate through array and note number occurence
    for num in array:
        histogram[num] += 1
    # sum up histogram in increasing order
    for i in xrange(1, len(histogram)):
        histogram[i] += histogram[i-1]
    # reverse iterate through the array and put number in sorted position
    # according to histogram index
    for num in reversed(array):
        result[histogram[num]-1] = num
    #   decrement histogram count
        histogram[num] -= 1
    # return result
    return result

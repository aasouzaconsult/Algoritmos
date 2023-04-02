# counting sort


def counting_sort(array, num_range):
    """

    Counting sort takes an array and number range the numbers lie in. Each
    occurence of array element is stored in aux array. Aux array is summed in
    increasing order. Then iterate through the array and put the elements in
    their sorted position.

    """
    # init result
    result = [0 for _ in array]
    # init histogram
    histogram = [0 for _ in xrange(num_range+1)]
    # iterate through array and note number occurence
    for num in array:
        histogram[num] += 1
    # sum histogram in increasing order
    for i in xrange(1, len(histogram)):
        histogram[i] += histogram[i-1]
    # iterate through array in reverse
    for num in reversed(array):
    #   put num in their sorted position
        result[histogram[num]-1] = num
    #   decrement histogram count
        histogram[num] -= 1
    # return result
    return result

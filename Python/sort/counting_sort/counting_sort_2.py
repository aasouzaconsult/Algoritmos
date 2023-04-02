# counting sort


def counting_sort(array, num_range):
    """

    Counting sort takes in an array and the range the numbers lie in. Each
    occurence of the number is tabulated and stored in aux array. Aux array is
    then summed to strictly increasing order. Then iterate through the array in
    reverse and put each element in its eventual position.

    """
    # init result
    result = [0 for _ in array]
    # init histogram
    histogram = [0 for _ in xrange(num_range+1)]
    # iterate array and note number occurence
    for num in array:
        histogram[num] += 1
    # sum histogram in increasing order
    for i in xrange(1, len(histogram)):
        histogram[i] += histogram[i-1]
    # reverse iterate through array
    for num in reversed(array):
        # put each number in sorted position
        # decrement histogram count
        result[histogram[num]-1] = num
        histogram[num] -= 1
    # return result
    return result

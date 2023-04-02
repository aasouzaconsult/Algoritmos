# counting sort


def counting_sort(array, num_range):
    """

    COunting sort takes in an array and the number range they lie in. Each
    occurence of number is stored in an aux array. Aux array is arranged in
    increasing order. Then iterate through the array in reverse and put numbers
    in their sorted position.

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
    # iterate through array in reverse and put number in their sorted position
    #   decrement histogram count
    for num in reversed(array):
        result[histogram[num]-1] = num
        histogram[num] -= 1
    # return result
    return result

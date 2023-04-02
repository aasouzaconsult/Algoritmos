# counting sort


def counting_sort(array, num_range):
    """

    Takes in an array and the number range the array elements lie in. Each
    occurence of the number is stored in an aux array. Sum the aux array in
    increasing order. Reverse iterate through the array and put elements in
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
    # iterate through array in reverse and put item in sorted position
    for num in reversed(array):
        result[histogram[num]-1] = num
    #   decrement histogram count
        histogram[num] -= 1
    # return result
    return result

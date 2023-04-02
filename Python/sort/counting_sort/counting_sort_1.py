# counting sort


def counting_sort(array, num_range):
    """

    Counting sort takes in an array and the range in which the numbers lie in.
    Each occurence of the number in the array is tabulated and stored in
    auxillary array. Aux array is summed to strictly increasing order. Then
    iterate through the array backwards and put element in its eventual sorted
    position.

    """
    # init result array
    result = [0 for _ in xrange(len(array))]
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
    #   put each number in its sorted position
        result[histogram[num]-1] = num
    #   decrement histogram count
        histogram[num] -= 1
    # return result
    return result


if __name__ == "__main__":
    test = [0, 2, 0, 1, 3, 4, 6, 1, 3, 2]
    test2 = [2, 5, 3, 0, 2, 3, 0, 3]
    print counting_sort(test, 6)
    print counting_sort(test2, 5)

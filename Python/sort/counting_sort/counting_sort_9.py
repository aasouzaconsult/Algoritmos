# counting sort


def counting_sort(array, num_range):
    """

    Counting sort takes in an array and the max number range the element lies
    in. Each occurence of the number is stored in an aux array. Sum the aux
    array in increasing order. Then reverse iterate the array and put elements
    in their sorted position.

    """
    # init result
    result = [0 for _ in array]
    # init histogram
    histogram = [0 for _ in xrange(num_range+1)]
    # iterate through the array and note occurence
    for num in array:
        histogram[num] += 1
    # sum the histogram in increasing order
    for i in xrange(1, len(histogram)):
        histogram[i] += histogram[i-1]
    # reverse iterate the array and put elements in sorted position
    for num in reversed(array):
        result[histogram[num]-1] = num
    #   decrement histogram count
        histogram[num] -= 1
    # return result
    return result

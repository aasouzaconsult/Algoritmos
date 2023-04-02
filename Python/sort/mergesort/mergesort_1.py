# mergesort


def mergesort(array):
    """

    Divide the array into 2 equal size sublists. Sorted the 2 sublists using
    mergesort recursively. Then merge the two sorted sublists to produce the
    sorted answer.

    """
    # check if size of array is less than 2
    if len(array) <= 1:
        return array
    # get mid index and create left, right sublists
    mid = len(array) // 2
    left = array[:mid]
    right = array[mid:]

    # recursively sort left and right sub array
    left = mergesort(left)
    right = mergesort(right)
    # merge left and right subarray to 1 combined array
    return merge(left, right)


def merge(left, right):
    """

    We traverse left and right array instead of popping the values to prevent
    unintended manipulation of input parameters.

    """
    # initialize left and right indexes
    result = []
    i, j = 0, 0

    while i < len(left) and j < len(right):
        # change direction of this comparison to change direction of sort
        # append the smaller of 2 elements to result
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    # when either left or right array is exhausted
    # append remaining left and right elements to result
    if left:
        result.extend(left[i:])
    if right:
        result.extend(right[j:])
    # return result
    return result


if __name__ == "__main__":
    test1 = [11, 12, 43, 3, 7, 29]
    test2 = [54, 26, 93, 17, 77, 31, 44, 55, 20]
    print mergesort(test1)
    print mergesort(test2)

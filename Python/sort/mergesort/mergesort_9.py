# mergesort


def mergesort(array):
    """

    Divides the array into 2 almsot equal sublists and recursively sort the
    sublists. Then merge the sorted sublist to produce the sorted result.

    """
    # check array size more than 1
    if len(array) <= 1:
        return array
    # compute mid index
    mid = len(array) // 2
    # recursively sort sublists
    left = mergesort(array[:mid])
    right = mergesort(array[mid:])
    # merge sorted sublists to produce result
    return merge(left, right)


def merge(left, right):
    # init result
    result = []
    # init left, right index
    i, j = 0, 0
    # while neither sublist is exhausted, repeatedly compare each sublist
    # elements and put smaller element in result
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    # when either sublist is exhausted, add remaining other sublist to result
    if left:
        result.extend(left[i:])
    if right:
        result.extend(right[j:])
    # return result
    return result

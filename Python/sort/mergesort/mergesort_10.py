# mergesort


def mergesort(array):
    """

    Divides the array into 2 almost equal sublist and recursively sort both
    sublists. Then merge both sorted sublists to produce sorted result.

    """
    # check array size at least 2
    if len(array) <= 1:
        return array
    # compute mid index
    mid = len(array) // 2
    # recursively sort both lists
    left = mergesort(array[:mid])
    right = mergesort(array[mid:])
    return merge(left, right)


def merge(left, right):
    # init result
    result = []
    # init left right index
    i, j = 0, 0
    # while neither sublist is exhausted, repeatedly compare elements from each
    # sublist and put smaller element in result
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

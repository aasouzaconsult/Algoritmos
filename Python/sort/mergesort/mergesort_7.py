# mergesort


def mergesort(array):
    """

    Divides the array into 2 almost equal size sublists and recursively sort
    both sublists. Then merge both sublists with mergesort to produce the
    sorted result.

    """
    # check array size more than 1
    if len(array) <= 1:
        return array
    # compute mid index
    mid = len(array) // 2
    # recursively sort left and right sublists
    left = mergesort(array[:mid])
    right = mergesort(array[mid:])
    # merge both sublists and return sorted result
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
    # when either sublist is exhausted, add other partial sublist to result
    if left:
        result.extend(left[i:])
    if right:
        result.extend(right[j:])
    # reutrn result
    return result

# mergesort


def mergesort(array):
    """

    Divides the array in 2 almost equal sublists. Recursively sort the
    sublists. Then merge both sublists to produce the sorted result.

    """
    # check array has at least 2 item
    if len(array) <= 1:
        return array
    # compute mid index
    mid = len(array) // 2
    # recursively sort sublists
    left = mergesort(array[:mid])
    right = mergesort(array[mid:])
    # merge and return sorted sublists
    return merge(left, right)


def merge(left, right):
    # init result
    result = []
    # init left right index
    i, j = 0, 0
    # while neither sublist is exhausted, repeatedly compare the sublist
    # elements and put smaller element in result
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    # when either sublist exhausted, put remaining other sublist in result
    if left:
        result.extend(left[i:])
    if right:
        result.extend(right[j:])
    # return result
    return result

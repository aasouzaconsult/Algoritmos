# mergesort


def mergesort(array):
    """

    Divides the array into 2 almost equal size sublists and recursively sort 2
    sublists with mergesort. Then merge both sublists to produce the sorted
    result.

    """
    # check size of array less than 2
    if len(array) <= 1:
        return array
    # compute mid index and split to left, right sublists
    mid = len(array) // 2
    # recursively sort both sublists
    left = mergesort(array[:mid])
    right = mergesort(array[mid:])
    # merge both sorted sublists and return result
    return merge(left, right)


def merge(left, right):
    # init result
    result = []
    # init left right index
    i, j = 0, 0
    # while neither sublist is exhausted, repeatedly compare left, right
    # elements and put smaller elements in result
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    # when either list is exhausted, add the other remaining list to result
    if left:
        result.extend(left[i:])
    if right:
        result.extend(right[j:])
    # return result
    return result

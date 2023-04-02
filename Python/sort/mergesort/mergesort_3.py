# mergesort


def mergesort(array):
    """

    Divides the array into 2 almost 2 equal size sublists. Sort the 2 sublists
    using mergesort recursively. Then merge both sublists to produce the sorted
    answer.

    """
    # check size of array more than 2
    if len(array) <= 1:
        return array
    # get mid index and split to left, right sublist
    mid = len(array) // 2
    left = array[:mid]
    right = array[mid:]
    # recursively sort sublists with mergesort
    left = mergesort(left)
    right = mergesort(right)
    # merge sublists and return the result
    return merge(left, right)


def merge(left, right):
    # init result
    result = []
    # init left, right index
    i, j = 0, 0
    # while neither sublist is exhausted, put smaller of 2 list item into
    # result
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

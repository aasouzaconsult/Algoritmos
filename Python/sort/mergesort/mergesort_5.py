# mergesort


def mergesort(array):
    """

    Divides the array into 2 almost equal sublists and recursively sort the 2
    sublists. Merge the sublists to produce the sorted result.

    """
    # check array size more than 1
    if len(array) <= 1:
        return array
    # get mid index and split to left, right sublists
    mid = len(array) // 2
    left = array[:mid]
    right = array[mid:]
    # recursively sort left, right sublists
    left = mergesort(left)
    right = mergesort(right)
    # merge 2 sorted sublists and return result
    return merge(left, right)


def merge(left, right):
    # init result
    result = []
    # init left, right index
    i, j = 0, 0
    # while neither sublist is exhausted, repeatedly compare both sublist
    # elements and put smaller element in result
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    # when either list is exhausted, add other list to result
    if left:
        result.extend(left[i:])
    if right:
        result.extend(right[j:])
    # return result
    return result

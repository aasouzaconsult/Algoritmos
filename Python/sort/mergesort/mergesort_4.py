# mergesort


def mergesort(array):
    """

    Divides the array into almost equal 2 sublists then sort the 2 sublists
    recursively with mergesort. Then we combine the sublists to produce the
    sorted answer.

    """
    # check array size more than 1
    if len(array) <= 1:
        return array
    # get mid index and split array from mid index
    mid = len(array) // 2
    left = array[:mid]
    right = array[mid:]
    # recursively sort left, right sublist
    left = mergesort(left)
    right = mergesort(right)
    # merge left and right sublist and return result
    return merge(left, right)


def merge(left, right):
    # init result
    result = []
    # init left, right index
    i, j = 0, 0
    # while neither sublist is exhausted, repeatedly get smaller value of 2
    # sublists and put in result
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    # when either list is exhausted, add other sublist to result
    if left:
        result.extend(left[i:])
    if right:
        result.extend(right[j:])
    # return result
    return result

# mergesort


def mergesort(array):
    """

    Divide the array into 2 almost equal size sublists. Sort the 2 sublist
    using mergesort recursively. Then merge the two sorted sublists to produce
    the sorted answer.

    """
    # check array length less than 2
    if len(array) <= 1:
        return array
    # get mid index and create left, right sublists
    mid = len(array) // 2
    left = array[:mid]
    right = array[mid:]
    # recursively call mergesort to left and right sublists
    left = mergesort(left)
    right = mergesort(right)
    # return the merged left and right sublists
    return merge(left, right)


def merge(left, right):
    # initialize left, right index
    i, j = 0, 0
    # init result
    result = []
    # while neither sublist is exhausted, compare each left, right elements and
    # put smaller element in result
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    # when either left or right is exhausted, add remaining other sublist
    # elements to result
    if left:
        result.extend(left[i:])
    if right:
        result.extend(right[j:])
    # return result
    return result

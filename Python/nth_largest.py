def nth_largest(a_list, n):
    """

    Find the n-th largest element in the list of unsorted integers.

    """
    if n < 1:
        return
    n -= 1  # 0 indexing

    pivot = a_list[-1]

    bigger = -1
    print a_list
    for i in range(len(a_list)-1):
        if a_list[i] > pivot:
            a_list[bigger+1], a_list[i] = a_list[i], a_list[bigger+1]
            bigger += 1
    # swap pivot with bigger+1 element
    a_list[bigger+1], a_list[-1] = a_list[-1], a_list[bigger+1]
    print a_list
    print bigger
    print n

    if n == bigger+1:
        return a_list[n]
    elif n < bigger+1:  # element in left sub array
        return nth_largest(a_list[:bigger+1], n+1)
    elif n > bigger+1:  # element in right sub array
        return nth_largest(a_list[bigger+2:], n+1-len(a_list[:bigger+2]))


def nth_largest2(a_list, n):
    """

    Find the n-th largest element in the list of unsorted integers.

    """
    a_list.sort()
    new_list = a_list[::-1]
    return new_list[n-1]


if __name__ == "__main__":
    test_list = [5, 3, 13, 1, 17, 11, 7]
    sorted_test = [1, 3, 5, 7, 11, 13, 17]
    print nth_largest(test_list, 5)
    print nth_largest2(test_list, 5)

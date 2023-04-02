def counting_sort(a_list, limit):
    """

    Sorts *a_list* using counting sort technique

    Time Complexity:
    n is num of elements and k is the range of input
    Best: O(n+k)
    Average: O(n+k)
    Worst: O(n+k)

    Space Complexity: O(n+k)
    """
    # check a_list has at least 2 elements:
    if len(a_list) < 2:
        return a_list
    # limit is the highest number that appears in the list
    limit += 1  # account for 0 index issue

    # initialize result list to size of a_list
    result = [None] * len(a_list)
    # initialize freq list to size of limit
    freq = [0] * limit

    # count the number of times each value in a_list occurs and store in freq
    # list
    for i in range(len(a_list)):
        freq[a_list[i]] += 1
    # modify freq list so each index value represents the
    # number of elements <= value:
    for i in range(1, limit):
        freq[i] += freq[i-1]
    # sort a_list with result in result list
    for i in range(len(a_list)-1, -1, -1):
        result[freq[a_list[i]]-1] = a_list[i]
        freq[a_list[i]] -= 1
    # return result list
    return result


def radix_sort(a_list, digits):
    """

    Sort *a_list* using radix sort technique.

    Time Complexity:
    n is num of elements and k is the range of input
    Best: O(nk)
    Average: O(nk)
    Worst: O(nk)

    Space Complexity: O(n+k)

    """
    for i in range(digits):
        a_list = counting_sort(a_list, 10)
    return a_list

if __name__ == "__main__":
    test = [3, 7, 4, 9, 5, 2, 6, 1]
    print counting_sort(test, 9)
    print radix_sort(test, 1)

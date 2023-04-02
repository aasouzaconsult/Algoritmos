'''
A host gets a set of back to back reservation requests (inquiries) for stays
of various lengths. The information about these requests is stored in an array,
where each value is an integer representing the length of a stay in nights. All
of these inquiries are back to back, which means that stay number i+1 starts
right after stay number i ends. The host wants to have time to prepare the
listing for the next guest, so they don't want to accept inquiries that are
adjacent to each other. In other words, if they accept inquiry i, they can't
also accept either i-1 or i+1.

Under these conditions, what is the maximum number of nights the host can
accept?

Some examples:
[5, 1, 2, 6] = 11     [5,2] [5,6] [1,6]
[4, 9, 6] = 10    [4, 6] [9]
[4, 11, 6] = 11
[4, 10, 3, 1, 5] = 15

[1] -> [1]
[1,2] -> [1] [2]
[1,2,3] -> [1,3], [2], [3]
[1,2,3,4] -> [1,3] [1,4] [2,4]
every index will generate n-2
'''

import copy


def max_nights(array):
    """
    Dynamic programming solution.
    O(n)

    """
    if len(array) < 1:
        return 0
    elif len(array) <= 2:
        return max(array)
    else:
        compare = [[array[0]], array[0]]
        if array[1] > array[0]:
            gap = [[array[1]], array[1]]
        else:
            gap = copy.deepcopy(compare)
        for i in xrange(2, len(array)):
            if compare[1] + array[i] > gap[1]:
                compare[0].append(array[i])
                compare[1] = compare[1] + array[i]

                compare, gap = gap, compare
            else:
                compare = copy.deepcopy(gap)
    return gap

# assumptions
# min 0 size
# max infinite
# all integeres in array are positive and no 0s

# get subsets of from the original array based on rules to omit immediate next
# request
# compute the sum of subsets and return the largest value
# O(n * n-2) -> O(n^2)


def maximum_nights(array):
    if len(array) < 1:
        return 0
    largest = 0
    for i in xrange(len(array)):  # O(n)
        temp = 0
        if i == len(array)-2:
            if array[i] > largest:
                largest = array[i]
            break
        for item in array[i+2:]:  # O(n-2)
            temp = array[i] + item
            if temp > largest:
                largest = temp
    return largest

# O(n)
# possible to update the largest with only 1 run


def maximum_nights3(array):
    if len(array) < 1:
        return 0
    largest = 0
    for i in xrange(len(array)):
        if i == len(array)-2:
            if array[i] > largest:
                largest = array[i]
            break
        sliced = array[i+2:]
        if len(sliced) < 1:
            continue
        temp = array[i] + max(sliced)
        if temp > largest:
            largest = temp
    return largest

if __name__ == "__main__":
    test1 = [5, 1, 2, 6, 20, 2]
    test2 = [4, 9, 6]
    test3 = [4, 11, 6]
    test4 = [4, 10, 3, 1, 5]
    print maximum_nights3(test1), max_nights(test1)  # 11
    print maximum_nights3(test2), max_nights(test2)  # 10
    print maximum_nights3(test3), max_nights(test3)  # 11
    print maximum_nights3(test4), max_nights(test4)  # 15

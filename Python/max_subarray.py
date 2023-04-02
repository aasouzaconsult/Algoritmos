# FIND-MAX-CROSSING-SUBARRAY(A, low, mid, high)
# Finds the maximum subarray in A which crosses the midpoint of the array and
# returns the starting index, the ending index and the sum of the subarray 
# O(n)
# Chapter 4, Page 71


def find_max_crossing_subarray(a_list, low, mid, high):
    left_sum = -1e308
    temp_sum = 0
    max_left = 0
    for i in reversed(range(low, mid+1)):
        temp_sum += a_list[i]

        if temp_sum > left_sum:
            left_sum = temp_sum
            max_left = i

    right_sum = -1e308
    temp_sum = 0
    max_right = 0
    for j in range(mid+1, high+1):
        temp_sum += a_list[j]

        if temp_sum > right_sum:
            right_sum = temp_sum
            max_right = j

    return (max_left, max_right, left_sum + right_sum)


def find_max_subarray(a_list, low, high):
    # only 1 element in list
    if high == low:
        return (low, high, a_list[low])

    mid = (low + high)/2
    # return tuples with data (low index, high index, sum)
    left = find_max_subarray(a_list, low, mid)
    right = find_max_subarray(a_list, mid+1, high)
    cross = find_max_crossing_subarray(a_list, low, mid, high)
    if left[2] >= right[2] and left[2] >= cross[2]:
        return left
    elif right[2] >= left[2] and right[2] >= cross[2]:
        return right
    else:
        return cross

if __name__ == "__main__":
    test_list = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15,
                 -4, 7]
    test_list2 = [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
    print find_max_crossing_subarray(test_list, 0, 8, len(test_list)-1)
    print find_max_subarray(test_list, 0, len(test_list)-1)
    print find_max_subarray(test_list2, 0, len(test_list2)-1)
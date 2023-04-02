def max_subarray_brute(a_list):
    """

    Find the maximum subarray from *a_list* using brute force.

    Time Complexity: O(n^2)

    """
    profits = []
    for i in range(len(a_list)-1):
        for j in range(i+1, len(a_list)):
            profit = 0
            profit += a_list[j] - a_list[i]
            profits.append((i, j, profit))
    max_profit = profits[0][2]
    for i in range(1, len(profits)):
        if profits[i][2] > max_profit:
            max_profit = profits[i][2]
            result = profits[i]
    return result


def max_subarray(a_list, low, high):
    """

    Find the maximum subarray from *a_list* using divide and conquer method.

    Time complexity: O(n lgn)

    """
    # base case, only 1 element
    if high == low:
        return (low, high, a_list[low])

    mid = (low+high) / 2
    left = max_subarray(a_list, low, mid)
    right = max_subarray(a_list, mid+1, high)
    cross = max_crossing_subarray(a_list, low, mid, high)
    if left[2] >= right[2] and left[2] >= cross[2]:
        return left
    elif right[2] >= left[2] and right[2] >= cross[2]:
        return right
    else:
        return cross


def difference(a_list):
    # find the difference between each day and store in list.
    difference = []
    for i in range(len(a_list)-1):
        for j in range(i+1, len(a_list)):
            difference.append(a_list[j] - a_list[i])
            break
    return difference


def max_crossing_subarray(a_list, low, mid, high):
    """

    Return the maximum array that crosses from the left subarray to the right
    subarray.

    """
    left_sum = -1e30
    curr_sum = 0
    max_left = mid
    for i in reversed(range(low, mid+1)):
        curr_sum += a_list[i]
        if curr_sum > left_sum:
            left_sum = curr_sum
            max_left = i
    right_sum = -1e30
    curr_sum = 0
    max_right = mid + 1
    for i in range(mid+1, high):
        curr_sum += a_list[i]
        if curr_sum > right_sum:
            right_sum = curr_sum
            max_right = i
    return (max_left, max_right, left_sum + right_sum)


def max_subarray_kandane(a_list):
    """

    Find maximum sub array for *a_list* using kandane's algorithm.

    """
    curr_sum = 0
    max_sum = 0
    local_max = [[0, 0, 0]]  # start_index, end_index, max_sum
    for i in range(len(a_list)):
        curr_sum += a_list[i]
        if curr_sum > max_sum:
            max_sum = curr_sum
            local_max[-1][1] = i
            local_max[-1][2] = max_sum
        elif curr_sum < 0:
            curr_sum = 0
            subset = [i+1, i+1, 0]
            local_max.append(subset)
    result = []
    maximum = 0
    for i in range(len(local_max)):
        if local_max[i][2] > maximum:
            maximum = local_max[i][2]
            result = local_max[i]
    return result

if __name__ == "__main__":
    test_list = [100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101,
                 79, 94, 90, 97]
    test_list2 = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15,
                  -4, 7]
    print difference(test_list)
    print max_subarray(test_list2, 0, len(test_list2)-1)
    print max_subarray_kandane(test_list2)

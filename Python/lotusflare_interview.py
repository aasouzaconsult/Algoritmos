import unittest

"""
Given a array arr[1..n] of integers. Write an algorithm to find the sum of contiguous subarray within the array which has the largest sum. Return 0 if all the numbers are negative.

[1,2,3,-1,4] => 9 [1,2,3,-1,4]
[1,-1,-2,3]=>3 [3]

[1,2,-5,6,7,-13] => 14
[1,2,-5,6,7,-15,14]
"""
# assumptions
# 1. there are +ve and -ve values in the list
# 2. there's at least 1 element in the list
# 3. its possible to have a list with all -ve values
# 4. unlimited integer magnitude and list size. no overflow

# return integer with the largest sum.
"""
[4,-1,-2,2]=> 4
max_sub(list, 0, len(list)-1)
left= [4,-1] => 4
[4]=>4, [-1]=> -1
right = [-2, 2] => 2
[-2]=>-2, [2]=>2

[1,2,3,-1,4]
left = [1,2],
right = [3, -1, 4],
crossing = [2,3]
largest continuous set in each of the 3 scenario above, return the largest element
"""

# O(nlgn)
def max_subarray(a_list, low, high):
    # base case
    if high == low:
        return (low, high, a_list[low])
    mid = (low+high)/2
    
    left = max_subarray(a_list, low, mid)  # (low, high, sum)
    right = max_subarray(a_list, mid+1, high)
    crossing = crossing_subarray(a_list, low, mid, high)
    if left[2] >= right[2] and left[2] >= crossing[2]:
        return left
    elif right[2] >=left[2] and right[2] >= crossing[2]:
        return right
    else:
        return cross

def crossing_subarray(a_list, low, mid, high):
    """
    Assumes answer is in crossing part of 2 array
    """
    # (low, high, sum)
    left_sum = -1e30
    curr_sum = 0
    max_left = mid
#    left = [1,2]
    for i in reversed(xrange(low, mid+1)):
        curr_sum += a_list[i]
        if curr_sum > left_sum:
            left_sum = curr_sum
            max_left = i
    right_sum = -1e30
    curr_sum = 0
    max_right = mid + 1
#    right = [3, -1, 4],
    for i in xrange(mid+1, high):
        curr_sum += a_list[i]
        if curr_sum > right_sum:
            right_sum = curr_sum
            max_right = i
    return (max_left, max_right, left_sum + right_sum)

# Following the divide and conquer solution with O(n lgn) time complexity,
# I think we can cut down the time complexity to O(n) with this revised
# solution.
# Time complexity: O(n)

def max_subarray(a_list):
    """

    This solution uses a max_sum variable to keep track of historical maximum
    sum and curr_sum to keep track of current sum as we iterate through the
    list.

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
    return max_sum


class MaxSubArrayTestCase(unittest.TestCase):
    def setUp(self):
        self.test1 = [1, 2, 3, -1, 4]
        self.test2 = [1, -1, -2, 3]
        self.test3 = [1, 2, -5, 6, 7, -15, 14]
        self.test4 = [-1, -4, -3, -15]

    def test_max_subarray_correct_return_value(self):
        self.assertEqual(max_subarray(self.test1), 9)
        self.assertEqual(max_subarray(self.test2), 3)
        self.assertEqual(max_subarray(self.test3), 14)

    def test_max_subarray_with_all_negative_value(self):
        self.assertEqual(max_subarray(self.test4), 0)

if __name__ == "__main__":
    unittest.main()

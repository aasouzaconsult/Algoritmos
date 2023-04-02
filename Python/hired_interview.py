# You are asked to write a max_slice function which takes as an input an array
# of integers,and returns the slice with the largest sum of the elements

# [1, 2, 3] => [1,2,3]
# [1, -2, 3] => [3]
# [-1, -2, -3] => [-1]


def max_slice(num_array):
    # check there are at least 2 numbers in the array
    if len(num_array) < 2:
        return num_array
    maximums = []
    curr = []
    for item in num_array:
        if item >= 0:
            curr.append(item)
        else:  # negative number
            maximums.append(curr)
            curr = []
    maximums.append(curr)
    max_list = []
    for item in maximums:
        local_max = 0
        for number in item:
            local_max += number
        max_list.append(local_max)
    biggest_index = 0
    for i in range(1, len(max_list)):
        if max_list[i] > max_list[biggest_index]:
            biggest_index = i
    return maximums[biggest_index]


def max_slice2(num_array, low, high):
    if high == low:
    mid = (low + high)/2
    
    left = max_slice2(a_list, low, mid)
    right = max_slice2(a_list, mid+1, high)
    cross = max_crossing_slice(a_list, low, mid, high)
    # find max of the 3 above, left, right, cross
    # return left / right / cross

def max_crossing_slice(a_list, low, mid, high):
    left_sum = -1e100
    temp_sum = 0
    max_left = 0
    for i in reversed(range(low, mid+1)):
        temp_sum += a_list[i]
        if temp_sum > left_sum:
            max_left = i
    right_sum = -1e100
    temp_sum =0 
    max_right = 0
    for j in range(mid+1, high+1):
        temp_sum +=a_list[j]
        if temp_sum > right_sum:
            right_sum = temp_sum
            max_right = j
    return (max_left, max_right, left_sum + right_sum)
            
if __name__ == "__main__":
    num_array = [1, -2, 3]
    num_array2 = [1,2,3]
    num_array3 = [-1, -2, -3]
    print max_slice(num_array)
    print max_slice(num_array2)
    print max_slice2(num_array, 0, len(num_array)-1)

# Write an algorithm that brings all nonzero elements to the left of the array,
# and returns the number of nonzero elements.

# Example input: [1,0,2,0,0,3,4]
# Example output: 4


def non_zero_count(a_list):
    a_list.sort(reverse=True)
    freq = 0
    for num in a_list:
        if num is not 0:
            freq += 1
    return freq, a_list

if __name__ == "__main__":
    test_list = [1, 0, 2, 0, 0, 3, 4]
    freq, result = non_zero_count(test_list)
    print freq
    print result

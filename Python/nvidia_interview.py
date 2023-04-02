# If i give you an array of integers, i want you to write an algorithm that
# brings all the 0 elements to the end of the array and returns the # of
# non-zero elements.

# [1, 2, 0, 4, 0] => [1,2,4, 0, 0] , 3

# [1, 2, 4, 4 , 5, 0, 0]

# []

# [-1, -3,0 , 4, -2] ==> [-1, -3, 4, -2, 0], 4


def find_non_zero_elements(an_array):
    # check that array has at least 1 element
    # zeros = 0
    # iterate through an_array
    #    check for 0 elemenet:
    #    if elemnt is 0:
    #        remove this elemnt and append to the end
    #        zeros += 1
    # return an_array, len(an_array) - zeros
    if len(an_array) < 1:
        return an_array, 0

    zeros = 0
    last_index = len(an_array)-1
    curr = 0
    while curr <= last_index:
        if an_array[curr] == 0:
            an_array.remove(an_array[curr])
            an_array.append(0)
            zeros += 1
            last_index -= 1
        curr += 1
    return an_array, len(an_array) - zeros


if __name__ == "__main__":
    test = [1, 2, 0, 4, 0]
    print find_non_zero_elements(test)

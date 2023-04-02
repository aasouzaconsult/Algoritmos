# Given an array, write a function to return true if the sum of any two numbers
# in the array is zero.

# O(n^2)
def sum_to_ten(a_list):
    """
    Takes in a list of integer arrays and return true if any two numbers sum to
    zero. false otherwise.

    """
    # check list is not empty
    if len(a_list) < 1:
        return False
    is_sum_zero = False
    # initialize a list
    data_sets = []
    # iterate through the list
    for item in a_list:
        if -item not in data_sets:
            data_sets.append(item)
        else:
            is_sum_zero = True
    return is_sum_zero
    #   for each item, check if the inverse value is in list
    #   return true if found, else continue
    # return false

# O(n)
def sum_to_ten_v2(a_list):
    """
    Takes in a list of integer arrays and return true if any two numbers sum to
    zero. false otherwise.

    """
    if len(a_list) < 1:
        return False
    is_sum_zero = False
    data_sets = {}

    for item in a_list:
        if -item not in data_sets.keys():
            data_sets[item] = None
        else:
            is_sum_zero = True
    return is_sum_zero

if __name__ == "__main__":
    test = [1, 3, 5, 7, -3]
    print sum_to_ten(test)
    print sum_to_ten_v2(test)
    test_2 = [1, 3, 4, 6, -13]
    print sum_to_ten(test_2)
    print sum_to_ten_v2(test_2)

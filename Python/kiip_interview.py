# 12pm - May 8th
'''
Given a two-dimensional array of decimal values (double[][]), where the
values are numbered consecutively, find a given value

Example:

arr = 
[[1.0, 5.0, 12.5, 13.6],
 [15.3, 19.2, 56.4, 58.2],
 [59.1, 71.2, 91.4, 102.3]]

print find_val(arr, 71.2)
> True
print find_val(arr, 72.3)
> False
'''
# 4th solution as extension of 3rd solution
# O(nlgn)
# acutal running time is shorter than 3rd solution
# iterate through the list
    # if item[-1] < number:
    #     continue
    # else:
    #     find_element(item, number)
# return False 

# assume array can be of any size, even 0
# 1st solution
def find_val(a_list, number):
    # check that a_list is not empty
    # iterate through the first level of list
    #     iterate through the element in the current list
    #        if a_list[i][j] == number
    #            return True
    # return False
    # O(n^2)
    if len(a_list) < 1:
        return False
    for item in a_list:
        for element in item:
            if element == number:
                return True
            elif number > element:
                break
    return False

# 2nd solution
def find_val(a_list, number):
    # check that a_list is not empty
    # iterate through the first level of list
    #     iterate through the element in the current list
    #        if a_list[i][j] == number
    #            return True
    # return False
    # O(n^2)
    if len(a_list) < 1:
        return False
    for item in a_list:
        if number not in item:
            continue
        else:
            return True
    return False

# 3rd solution
def find_val(2d_array, number):
    # check that a_list is not empty
    # iterate through the list again
    #     mid = math.floor(len(item) / 2)
    # O(nlgn)
    if len(a_list) < 1:
        return False
    for item in 2d_array:
        result = find_element(item, number)
        if result:
            return result
    return False

def find_element(a_list, number):
    if len(a_list) < 2:
        if a_list[0] != number:
            return False
        return True
    mid = math.floor(len(item)/2)
    if a_list[mid] == number:
            return True
        elif a_list[mid] < number:
            find_element(a_list[mid+1:], number)   
        else:
            find_element(a_list[:mid], number)

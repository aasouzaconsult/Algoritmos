# Write a function that will return an array/array-like object of integers from 1 to N in a random order
# e.g. if N = 6 the array will look something like [4,3,1,6,5,2]
# each number should only occur once in the array

# declare a function to take in a number
# check that number is not 0 or negative
# initiate an list with the size of N. list comprehension
# iterate through the number from 1 to N
#     position = random(value)
#     result[position] = value
# return an array with the numbers in random
from random import randint

# O(n^2)
def randomized(number):
    if type(number) != type(1) or number < 1:
        return
    result = [None for i in range(number)]  # 0 - number-1 # O(n)
    position = randint(0, number-1)
    for i in range(1, number+1):  # loops runs number times #O(n)
        # get a new position if position is filled
        while result[position] is not None:  # O(n)
            position = randint(0, number-1)
        result[position] = i
    return result  # [4,3,1,6,5,2]

# O(n)
def randomized_v2(number):
    if type(number) != type(1) or number < 1:
        return
    result = []
    while len(result) < number:
        item = randint(0, number-1)+1
        if item not in result:
            result.append(item)
        else:
            continue
    return result


# Write a function that takes an array of strings as an input and returns an array (or array like object) containing the items of the input array that are palindromes. A palindrome is a word that reads the same forwards as backwards.
# For the sake of this exercise assume that there is no built-in function that will return a reversed string.
# e.g. array = ['madam', 'nope', 'rotor', 'hmmmm']

# result = ['madam', 'rotor']

# declare a function to take in this array of strings
# input argument is an array of strings only, with possible numbers
# check that the array is not empty
# iterate through the array
#     check for palindrome --> is_palindrome(string) return True
#     if is palindrome append to result array
# return the result array

# O(n)
def check_palindrome(an_array):
    result = []
    if len(an_array) < 1:
        return result
    for item in an_array:
        if is_palindrome(item):
            result.append(item)
    return result
   
# O(1)
def is_palindrome(a_string):
    if type(a_string) != type("string"):
        return False
    return a_string == a_string[::-1]

if __name__ =="__main__":
    new_array = ['madam', 'nope', 'rotor', 'hmmmm']
    print check_palindrome(new_array)  # result = ['madam', 'rotor']
    print randomized(6)
    print randomized_v2(6)
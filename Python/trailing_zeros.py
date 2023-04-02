# Given a factorial value of n, count the number of trailing zeros in
# the value.

# factorial being n * n-1 * n-2 * ... * 1
# 2 * 5 = 10 contributes to 1 trailing zero
# 0 contributes to 1 trailing zero

# This method does not cater for numbers more than 25
def trailing_zeros(number):
    """
    @param number must be larger equal to 1
    @return number of zeros in the factorial of the number

    """
    # check if number is larger equal to 1
    if number < 1:
        return 0
    # initalize dict to store results
    histogram = {0: 0,
                 1: 0,
                 2: 0,
                 3: 0,
                 4: 0,
                 5: 0,
                 6: 0,
                 7: 0,
                 8: 0,
                 9: 0}
    # go through every number from the number down to 1
    for i in range(1, number+1):
        histogram[i % 10] += 1
    print histogram
    # return the values of 0, 2, 5 keys and compute the result using the
    # equation value_0 + min(value_2, value_5)
    return histogram[0] + min(histogram[2], histogram[5])


def trailing_zeros_v2(number):
    # http://www.purplemath.com/modules/factzero.htm
    # check if number if larger equal to 1
    if number < 1:
        return 0

    result = 0
    multiple = 5
    # as long as number / multiple of 5 gives a value larger equal 1, we
    # truncate the integer and add to result.
    while number/multiple > 0:
        result += int(number/multiple)
        multiple *= 5
    return result

if __name__ == "__main__":
    print trailing_zeros(1000)
    print trailing_zeros_v2(4617)

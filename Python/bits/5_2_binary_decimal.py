# Given a (decimal - e.g. 3.72) number that is passed in as a string, print the
# binary representation. if the number cannot be represented accurately in
# binary, print "ERROR"

import math


def binary_decimal(string):
    num = float(string)
    if math.floor(num) != num:
        return "ERROR"
    else:
        return bin(int(num))

if __name__ == "__main__":
    num1 = '3.72'
    num2 = '4.20'
    num3 = '5.0'
    num4 = '0'
    print binary_decimal(num1)
    print binary_decimal(num2)
    print binary_decimal(num3)
    print binary_decimal(num4)

# You are given two 32-bit numbers, N and M, and two bit positions, i and j.
# Write a method to set all bits between i and j in N equal to M(eg. M becomes
# a substring of N located at i and starting at j).
# Example:
# Input: N = 10000000000, M = 10101, i = 2, j = 6
# Output: N = 10001010100


def set_bits(num1, num2, start, end):
    result = num1[::-1][:start] + num2[::-1] + num1[::-1][end+1:]
    return result[::-1]


if __name__ == "__main__":
    num1 = '10000000000'
    num2 = '10101'
    print set_bits(num1, num2, 2, 6)

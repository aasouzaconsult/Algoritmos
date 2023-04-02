# Write a function to determine the number of bits required to convert integer
# A to integer B.
# Input: 31, 14
# Output: 2

# 11111
# 01110


def convert_required_bits(num1, num2):
    str1 = bin(num1)[2:]
    str2 = bin(num2)[2:]
    while len(str2) < len(str1):
        str2 = "0" + str2
    result = 0
    for i, j in zip(str1, str2):
        if i != j:
            result += 1
    return result


if __name__ == "__main__":
    print convert_required_bits(31, 14)

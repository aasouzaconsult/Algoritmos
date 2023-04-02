# Write a program to swap odd and even bits in an integer with as few
# instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3
# are swapped, etc).


def swap_bits(num):
    array = list(bin(num)[2:][::-1])

    for i in xrange(1, len(array), 2):
        array[i], array[i-1] = array[i-1], array[i]
    result = ""
    for item in array:
        result += item
    return result[::-1]


def swap_bits_2(num):
    return (num & 0xaaaaaaaa) >> 1 | (num & 0x55555555) << 1

if __name__ == "__main__":
    print swap_bits(21)

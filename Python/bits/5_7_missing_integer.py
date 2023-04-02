# An array A[1... n] contains all the integers from 0 to n except for one
# number which is missing. In this problem, we cannot access an entire integer
# in A with a single operation. The elements of A are represented in binary,
# and the only operation we can use to access them is "fetch the jth bit of
# A[i]", which takes constant time. Write code to find the missing integer. Can
# you do it in O(n) time?

# for each a[i], fetch the least significant bit


def fetch_bit(num):
    """
    fetch least significant bit of an binary number.
    """
    return num[-1]


def missing_integer(array):
    for i in xrange(len(array)):
        if i % 2 != int(fetch_bit(array[i])):
            return int(array[i], 2) - 1
    return


if __name__ == "__main__":
    test = ['0', '01', '10', '11', '100', '101', '111']
    print missing_integer(test)

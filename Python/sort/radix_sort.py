##############################################################################
# Author: GuoChen
# Title: Radix sort
##############################################################################

def radix_sort(a_list):
    """
    Radix sort, like counting sort and bucket sort, is an integer based
    algorithm. Hence radix sort is among the fastest sorting algorithms
    around, in theory. The particular distinction for radix sort is that
    it creates a bucket for each digit in numbers; as such, each bucket
    in radix sort must be a growable list that may admit different keys.

    For decimal values, the number of buckets is 10, as the decimal system
    has 10 numerals (i.e 0..9). Then the keys are continuously sorted by
    significant digits.
    """

    RADIX = 10
    max_length = False
    temp, placement = -1, 1

    while not max_length:
        max_length = True

        # declare and initialize buckets
        buckets = [list() for i in range(RADIX)]

        #split a_list between lists
        for num in a_list:
            temp = num / placement
            buckets[temp % RADIX] = num
            if max_length and temp > 0:
                max_length = False

        # empty lists into a_list
        a = 0
        for i in range(RADIX):
            buck = buckets[i]
            for j in buck:
                a_list[a] = j
                a += 1

        # move to next digit
        placement *= RADIX
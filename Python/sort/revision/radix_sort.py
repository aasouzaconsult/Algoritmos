def radix_sort(a_list):
    """

    Sort *a_list* using radix sort technique.

    Time Complexity:
    n is num of elements and k is the range of input
    Best: O(nk)
    Average: O(nk)
    Worst: O(nk)

    Space Complexity: O(n+k)

    """
    RADIX = 10
    max_length = False
    temp, placement = -1, 1

    while not max_length:
        max_length = True
        # declare and initialize buckets
        buckets = [list() for i in range(RADIX)]

        # split a_list between lists
        for i in a_list:
            temp = i / placement
            buckets[temp % RADIX].append(i)
            if max_length and temp > 0:
                max_length = False

        # empty lists into a_list array
        a = 0
        for b in range(RADIX):
            buck = buckets[b]
            for item in buck:
                a_list[a] = item
                a += 1

        # move to next digit
        placement *= RADIX
    return a_list


if __name__ == "__main__":
    test = [18, 5, 100, 3, 1, 19, 6, 0, 7, 4, 2]
    print radix_sort(test)

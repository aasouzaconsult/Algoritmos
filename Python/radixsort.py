def radixsort(a_list, d):
    RADIX = 10
    max_len = False
    temp, placement = -1, 1

    while not max_len:
        max_len = True
        # declare and initalize buckets
        buckets = [list() for i in range(RADIX)]
        print buckets
        # put elements with the same digit number in the same bucket
        for item in a_list:
            temp = item/placement
            buckets[temp % RADIX].append(item)
            if max_len and temp > 0:
                max_len = False
        print buckets
        # empty lists into a_list array
        a = 0
        for b in range(RADIX):
            buck = buckets[b]
            for item in buck:
                a_list[a] = item
                a += 1
        print a_list
        placement *= RADIX
    return a_list

if __name__ == "__main__":
    test_list = [329, 457, 657, 839, 436, 720, 355]
    print radixsort(test_list, 3)

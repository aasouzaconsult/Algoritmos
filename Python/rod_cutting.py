revenue = {
    0: 0,
    1: 1,
    2: 5,
    3: 8,
    4: 9,
    5: 10,
    6: 17,
    7: 17,
    8: 20,
    9: 24,
    10: 30,
}


def cut_rod(price, size):
    """

    Top down approach of memoization in dynamic programming.

    """
    revenue = [None for _ in xrange(size)]
    return _cut_rod(price, size, revenue)


def _cut_rod(price, size, revenue):
    if revenue[size-1] is not None:
        return revenue[size-1]
    if size == 0:
        result = 0
    else:
        result = -1e30
        for i in xrange(1, size+1):
            result = max(result, price[i]+_cut_rod(price, size-i, revenue))
    revenue[size-1] = result
    return result


def cut_rod_2(price, size):
    """

    Bottom up approach of memoization in dynamic programming.

    """
    revenue = [None for _ in xrange(size+1)]
    solution = [[] for _ in xrange(size+1)]
    revenue[0] = 0
    solution[0] = [0]

    for j in xrange(1, size+1):
        result = -1e30
        for i in xrange(1, j+1):
            #result = max(result, price[i]+revenue[j-i])
            if result < price[i] + revenue[j-i]:
                result = price[i] + revenue[j-i]
                solution[j] = [i]
                if size - i > 0:
                    solution[j].extend([size-i])
        revenue[j] = result
    return revenue[size], solution[size]

if __name__ == "__main__":
    print cut_rod(revenue, 1), cut_rod_2(revenue, 1)
    print cut_rod(revenue, 2), cut_rod_2(revenue, 2)
    print cut_rod(revenue, 3), cut_rod_2(revenue, 3)
    print cut_rod(revenue, 4), cut_rod_2(revenue, 4)
    print cut_rod(revenue, 5), cut_rod_2(revenue, 5)
    print cut_rod(revenue, 6), cut_rod_2(revenue, 6)
    print cut_rod(revenue, 7), cut_rod_2(revenue, 7)
    print cut_rod(revenue, 8), cut_rod_2(revenue, 8)
    print cut_rod(revenue, 9), cut_rod_2(revenue, 9)
    print cut_rod(revenue, 10), cut_rod_2(revenue, 10)

# Serling Enterprises buys long steel rods and cuts them into shorter rods,
# which it then sells. Each cut is free. The management of Serling Enterprises
# wants to know the best way to cut up the rods.

# Given a rod of length n inches and a table of prices for rod length
# i = 1, 2,...,n. Determine the maximum revenue obtainable by cutting up the
# rod and selling the pieces. Note that if the price Pn for a rod of length n
# is large enough, an optimal solution may require no cutting at all.

# length i | 1 2 3 4 5  6  7  8  9  10
# price Pi | 1 5 8 9 10 17 17 20 24 30

# Consider the case when n = 4. Cutting a 4 inch rod into 2 inch pieces
# produces revenue P2 + P2 = 5 + 5 = 10, which is optimal.


def cut_rod_recursive(price_table, n):
    """
    Recursive solution to cut rod problem. Takesn in a price_table and a number
    n for which to calculate the optimal revenue.

    """
    if n == 0:
        return 0
    result = -1
    # go through all possible ways of cutting the rod of current length and get
    # the max revenue of these values
    for i in xrange(1, n+1):
        result = max(result, price_table[1][i] + cut_rod_recursive(price_table,
                                                                   n-i))
    return result

# Dynamic programming solution by top down apporach


def cut_rod_memoized(price_table, n):
    # initialize DP table
    dp_table = [-1 for i in xrange(n+1)]
    return cut_rod_memoized_aux(price_table, n, dp_table)


def cut_rod_memoized_aux(price_table, n, dp_table):
    if dp_table[n] >= 0:
        return dp_table[n]
    if n == 0:
        result = 0
    else:
        result = -1
        for i in xrange(1, n+1):
            result = max(result, price_table[1][i] +
                         cut_rod_memoized_aux(price_table, n-i, dp_table))
    dp_table[n] = result
    return result

# Dynamic programming solution by bottom-up method


def cut_rod_bottom_up(price_table, n):
    """
    In DP bottom-up approach, we create a solution table to store the size of
    the first cut in each of the optimal sub solutions and return the actual
    solution of cutting a rod of n size.

    """
    dp_table = [-1 for i in xrange(n+1)]
    solutions = [-1 for i in xrange(n+1)]
    # initialize first term
    dp_table[0] = 0
    solutions[0] = 0
    for i in xrange(1, n+1):
        temp = -1
        for j in xrange(1, i+1):
            if temp < price_table[1][j] + dp_table[i-j]:
                temp = max(temp, price_table[1][j] + dp_table[i-j])
                solutions[i] = j
        dp_table[i] = temp
    return dp_table[n], (solutions[n], n - solutions[n])


if __name__ == "__main__":
    table = [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10],
             [0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30]]

    print cut_rod_bottom_up(table, 0)
    print cut_rod_bottom_up(table, 1)
    print cut_rod_bottom_up(table, 2)
    print cut_rod_bottom_up(table, 3)
    print cut_rod_bottom_up(table, 4)
    print cut_rod_bottom_up(table, 5)
    print cut_rod_bottom_up(table, 6)
    print cut_rod_bottom_up(table, 7)
    print cut_rod_bottom_up(table, 8)
    print cut_rod_bottom_up(table, 9)
    print cut_rod_bottom_up(table, 10)

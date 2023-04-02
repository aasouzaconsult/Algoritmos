# 0 - 1 knapsack
# A thief robbing a store finds n items. The ith item is worth v dollars and
# weights w pounds, where v and w are integers. The thief wants to take as
# valuable a load as possible, but he can carry at most W pounds in his
# knapsack, for some integer W. Which items should he take?


def zero_one_knapsack(items, knapsack):
    items.sort(key=lambda items: items[0])
    value = [0]
    weight = [0]
    for item in items:
        value.append(item[1])
        weight.append(item[0])

    table = [[0 for _ in xrange(knapsack+1)] for _ in xrange(len(items)+1)]
    # populate table
    for i in xrange(1, len(table)):
        for j in xrange(1, knapsack+1):
            if i == 1:
                table[i][j] = value[i]
                continue
            if j >= weight[i]:
                table[i][j] = max(table[i-1][j], table[i-1][j-weight[i]]+value[i])
            else:
                table[i][j] = table[i-1][j]
    return table[-1][-1]

# fractional knapsack problem
# Having the same setup as above, but the thief can take fractions of item,
# rather than having to make a binary choice for eah item. eg. Instead of
# choosing to take a gold ingot or not, he faced with gold dust.


def fractional_knapsack(items, knapsack):
    """

    Greedy solution.

    """
    value = []
    for item in items:
        value.append([item[0], item[1], item[1]/item[0]])
    value.sort(key=lambda value: value[2], reverse=True)
    result = []
    dollar = 0.0
    weight = 0
    for item in value:
        if weight >= knapsack:
            break
        elif item[0] <= knapsack-weight:
            result.append(item)
            weight += item[0]
            dollar += float(item[1])
        else:
            dollar += float((knapsack-weight))/item[0] * item[1]
            item[0] = (knapsack-weight)
            result.append(item)
            weight += item[0]
    return result, dollar

if __name__ == "__main__":
    items = [(1, 6), (3, 12), (2, 10)]
    knapsack = 5
    items2 = [(1, 3), (3, 4), (4, 5), (6, 5)]
    knapsack2 = 7
    #print fractional_knapsack(items, knapsack)
    print zero_one_knapsack(items2, knapsack2)

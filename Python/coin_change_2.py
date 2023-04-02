def change(number, coins_available, coins_so_far):
    if sum(coins_so_far) == number:
        yield coins_so_far
    elif sum(coins_so_far) > number:
        pass
    elif coins_available == []:
        pass
    else:
        for c in change(number, coins_available[:], coins_so_far +
                        [coins_available[0]]):
            yield c
        for c in change(number, coins_available[1:], coins_so_far):
            yield c


def change_2(number, coins_available):
    result = []
    for coin in coins_available[::-1]:
        while number > 0:
            multiple = number / coin
            if multiple > 0:
                for i in xrange(multiple):
                    result.append(coin)
                number %= coin
            else:
                break

    return result


def change_3(value):
    least_coins = [0 for i in xrange(value)]
    coin_type = [[] for i in xrange(value)]
    coin_type[0] = [0]
    least_coins[0] = 0
    coin_value = [5, 3, 1]
    for i in xrange(1, value):
        temp = i
        for coin in coin_value:
            while temp > 0 and coin <= temp:
                least_coins[i] += 1
                temp -= coin
                coin_type[i].append(coin)
    print least_coins
    print coin_type


if __name__ == "__main__":
    num = 15
    coins = [1, 5, 10, 25]
    solutions = [s for s in change(num, coins, [])]
    for s in solutions:
        print s

    print 'optimal solution', min(solutions, key=len)
    print change_2(num, coins)
    change_3(12)

import math


def convertFracts(lst):
    # find the lowest common multiple of a group of integers.
    # express each number as its multiple of prime numbers, ignoring the powers
    denom = [lst[i][1] for i in range(len(lst))]
    largest_primes = []
    for i in denom:
        largest_primes.append(prime_factorization(i)[-1])
    # multiple the biggest numbers from each prime list to get the lowest
    # common multiple
    new_denomator = 1
    for item in largest_primes:
        new_denomator *= item
    for i in range(len(lst)):
        lst[i][0] *= new_denomator / denom[i]
        lst[i][1] = new_denomator
    # return the fraction
    return lst


def is_prime(number):
    if number == 2 or number == 3:
        return True
    elif number % 2 == 0 or number % 3 == 0:
        return False
    i = 4
    while i <= int(math.sqrt(number)):
        if number % i == 0:
            return False
        i += 1
    return True


def prime_factorization(number):
    """Given a number, give the list of prime factors of the number
    and return the list of factors"""
    result = []
    i = 2
    while not is_prime(number):
        if number % i == 0:
            result.append(i)
            number /= i
        else:
            i += 1
    result.append(number)
    return result


def primes(number):
    """

    Using Sieve of Eratosthenes method, return a list of all prime numbers up
    to and including the number.

    """
    result = [[i, True] for i in xrange(number+1)][2:]
    for i in xrange(len(result)):
        for j in xrange(i+1, len(result)):
            if result[j][1]:
                if result[j][0] % result[i][0] == 0:
                    result[j][1] = False
            else:
                continue
    primes = []
    for i in xrange(len(result)):
        if result[i][1]:
            primes.append(result[i][0])
    return primes

if __name__ == "__main__":
    convertFracts([[1, 2], [1, 3], [1, 4]])
    print primes(121)
    print prime_factorization(8736)


def prime_factorization(number):
    """Given a number, give the list of prime factors of the number
    and return the list of factors"""
    result = []
    i = 2
    while not is_prime(number):
        if number % i == 0:
            result.append(i)
            number /= i
        else:
            i += 1
    result.append(number)
    return result


def is_prime(number):
    if number == 2 or number == 3:
        return True
    elif number % 2 == 0 or number % 3 == 0:
        return False
    i = 4
    while i <= int(math.sqrt(number)):
        if number % i == 0:
            return False
        i += 1
    return True

from fractions import gcd


def lcm(numbers):
    return reduce(lambda x, y: (x*y)/gcd(x, y), numbers, 1)


if __name__ == "__main__":
    test1 = [5, 3]
    test2 = [234, 543]
    print lcm(test1)
    print lcm(test2)

"""
Dynamic programming is fundamentally:
- recursion
- Memoization
- Guessing
Fibonacci sequence. Get the n-th fibonacci number.

"""


def fibo1(n):
    """
    Naive recursion algorithm.
    Generate the fibonacci number using normal recursion.
    Time complexity is O(2^(n/2)).

    """
    if n == 0:
        return 0
    if n == 1 or n == 2:
        return 1
    return fibo1(n-1) + fibo1(n-2)


memo = {}


def fibo2(n):
    """
    Memoized DP algorithm.

    We use a memo dictionary to store the computed values so fibo2(k) only
    recurses the first time it's called.

    Number of non-memoized calls is n:
    fib(1), fib(2), ... , fib(n)

    Non recursive work done per call is linear.

    Time complexity: O(n)

    """
    if n in memo:
        return memo[n]
    if n == 0:
        memo[0] = 0
        return 0
    if n == 1 or n == 2:
        memo[1] = 1
        memo[2] = 1
        return 1
    result = fibo2(n-1) + fibo2(n-2)
    memo[n] = result
    return result

memo3 = {}


def fibo3(n):
    """
    DP bottom-up approach. Compute the numbers starting from base up until n.

    Time complexity: O(n)
    """
    for k in range(n+1):
        if k == 0:
            result = 0
        elif k == 1 or k == 2:
            result = 1
        else:
            result = fibo3(k-1) + fibo3(k-2)
        memo3[k] = result
    return memo3[n]


if __name__ == "__main__":
    print fibo1(5)
    print fibo2(10)
    print fibo3(10)

# Given 2 strings, find the longest common subsequence of the 2 strings.
# https://www.youtube.com/watch?v=RUckZMzqUcw

# time complexity: O(m*n)


def lcs_sequence(string1, string2):
    m = len(string1)
    n = len(string2)
    sequence = [[0 for _ in xrange(n+1)] for _ in xrange(m+1)]
    for i in xrange(1, m+1):
        for j in xrange(1, n+1):
            if string1[i-1] == string2[j-1]:
                sequence[i][j] = sequence[i-1][j-1] + 1
            else:
                sequence[i][j] = max(sequence[i][j-1], sequence[i-1][j])
    return sequence


def longest_common_subsequences(sequence, string1, string2, i, j):
    if i == 0 or j == 0:
        return set([""])
    elif string1[i-1] == string2[j-1]:
        return set([k + string1[i-1] for k in longest_common_subsequences(sequence, string1, string2, i-1, j-1)])
    else:
        result = set()
        if sequence[i][j-1] >= sequence[i-1][j]:
            result.update(longest_common_subsequences(sequence, string1, string2, i, j-1))
        if sequence[i-1][j] >= sequence[i][j-1]:
            result.update(longest_common_subsequences(sequence, string1, string2, i-1, j))
    return result

if __name__ == "__main__":
    test1 = "philologist"
    test2 = "lollipop"
    test3 = "ABCBDAB"
    test4 = "BDCABA"
    print longest_common_subsequences(lcs_sequence(test1, test2), test1, test2, len(test1), len(test2))
    print longest_common_subsequences(lcs_sequence(test3, test4), test3, test4, len(test3), len(test4))

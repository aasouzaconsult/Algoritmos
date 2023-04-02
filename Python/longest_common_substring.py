# Given two strings 'X' and 'Y', find the length of the longest common
# substring. For example, if the given strings are "GeeksforGeeks" and
# "GeeksQuiz", the output should be 5 as longest common substring is "Geeks"


def longest_common_substring(string1, string2):
    """

    Brute force solution.
    Get all the substrings of the first string and for every substring, check
    if it is a substring in the second string. Keeping track of the maximum
    length substring. There will be O(n^2) substrings and we can find if a
    substring is in string2 in O(m) time. So overall complexity is O(n^2 * m)

    Time complexity: O(n^2 * m)

    """
    size = 0
    result = ""
    for i in xrange(len(string1)-1):
        for j in xrange(i+1, len(string1)):

            if string1[i:j+1] in string2:
                if len(string1[i:j+1]) > size:
                    size = len(string1[i:j+1])
                    result = string1[i:j+1]
    return result


def longest_common_substring2(string1, string2):
    """

    Dynamic Programming can be used to find the longest common substring in
    O(m*n) time. The idea is to find length of the longest common suffix for
    all substrings of both strings and store these lengths in a table.

    """
    # init DP table
    table = [[0 for _ in xrange(len(string1)+1)] for _ in xrange(len(string2)+1)]

    for i in xrange(1, len(string2)+1):
        for j in xrange(1, len(string1)+1):
            if string2[i-1] == string1[j-1]:
                table[i][j] = table[i-1][j-1] + 1
            else:
                table[i][j] = 0
    for i in table:
        print i
    largest = 0
    largest_indice = []
    # find largest
    for i in xrange(1, len(string2)+1):
        for j in xrange(1, len(string1)+1):
            if table[i][j] > largest:
                largest = table[i][j]
                largest_indice = [i, j]
    result = ""
    while table[largest_indice[0]][largest_indice[1]] != 0:
        result += string1[largest_indice[0]-1]
        for i in xrange(len(largest_indice)):
            largest_indice[i] -= 1
    return result[::-1]

if __name__ == "__main__":
    test1 = "GeeksforGeeks"
    test2 = "GeeksQuiz"
    # A, AB, ABA, ABAB,ABABC
    # B
    test3 = "ABABC"
    test4 = "BABCA"
    print longest_common_substring(test1, test2)  # Geeks
    print longest_common_substring(test3, test4)  # Geeks
    print longest_common_substring2(test1, test2)

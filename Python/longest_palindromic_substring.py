def longest_palindromic_substring(string1):
    # init DP table
    table = [[False for _ in xrange(len(string1))] for _ in xrange(len(string1))]

    # all substrings of length 1 are palindromes
    for i in xrange(len(string1)):
        table[i][i] = True
    # check for substring length 2
    start = 0
    for i in xrange(0, len(string1)-1):
        if string1[i] == string1[i+1]:
            table[i][i+1] = True
            start = i
            max_len = 2
    # check for lengths greater than 2, outer loop is length of substring
    for i in xrange(3, len(string1)):
        # fix starting index according to substring length
        for j in xrange(0, len(string1)-i+1):
            # get ending index of substring
            k = j + i - 1
            # check substring from ith index to jth index iff str[i+1] to
            # str[j-1] is a palindrome
            if table[j+1][k-1] and string1[j] == string1[k]:
                table[j][k] = True
                if i > max_len:
                    start = j
                    max_len = i
    for i in table:
        print i
    print max_len
    return string1[start:start+max_len]

if __name__ == "__main__":
    test1 = "forgeeksskeegfor"
    print longest_palindromic_substring(test1)

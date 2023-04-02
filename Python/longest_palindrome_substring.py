def longest_palindrome_brute(a_string):
    """

    Brute force solution.
    Check for every possible substring in string for palindrome.
    If current substring palindrome is longer than result, replace result.

    Time complexity: O(n^3)
    O(n^2) to get the substrings, O(n) to check if they are palindrome

    """
    if len(a_string) < 1:
        return None
    result = ""
    for i in range(len(a_string)-1):
        for j in range(i+1, len(a_string)):
            if is_palindrome(a_string[i:j+1]) and \
               len(result) < len(a_string[i:j+1]):
                result = a_string[i:j+1]
    if result == "":
        return a_string[0]
    return result


def longest_palindrome2(a_string):
    """
    """
    result = a_string[0]
    for i in xrange(len(a_string)):
        temp = get_palindrome_at(i, a_string)
        if len(temp) > len(result):
            result = temp
    return result


def get_palindrome_at(position, string):
    """

    Given the position index in the string, return the longest palindrome
    substring.

    """
    result = string[position]
    for lower, upper in [(position, position+1), (position-1, position+1)]:
        while lower >= 0 and upper < len(string):
            if is_palindrome(string[lower:upper+1]):
                result = string[lower:upper+1]
            else:
                break
            lower -= 1
            upper += 1
    return result


def is_palindrome(a_string):
    return a_string == a_string[::-1]

if __name__ == "__main__":
    test0 = "abaccddccefe"  # ccddcc
    test1 = "racecar"  # racecar
    test2 = "abacabde"  # bacab
    test3 = "raca"  # aca
    test4 = "abfad"  # a
    print longest_palindrome_brute(test0)
    print longest_palindrome_brute(test1)
    print longest_palindrome_brute(test2)
    print longest_palindrome_brute(test3)
    print longest_palindrome_brute(test4)
    print longest_palindrome2(test0)
    print longest_palindrome2(test1)
    print longest_palindrome2(test2)
    print longest_palindrome2(test3)
    print longest_palindrome2(test4)

# write a function to accept a string and decide if the string is a palindrome

# "racecar" => true
# "auto" => false.

# O(n)


def isPalindrome(s1):
    """
    Takes in a string and decide if string is a palindrome. 
    Return True if is palidronme.
    
    """
    # 0 len string check
    if len(s1) < 1:
        return False
    return s1 == s1[::-1]


# cut string to half, 1st == 2nd half
# take in a string
# cut string into 2 equal portions
# compare 2 portions of string

# "fun cat ,ball" => "nuf tac, llab"
# O(n)
def reverse(s2):
    # 0 len string check
    if len(s2) < 1:
        return ""
    # split string by ' ' delimiter
    arr = s2.split()  # ['fun', 'cat', 'ball']
    # reverse each individal word
    end_string = ""
    result = [item[::-1] for item in arr]
    # output the word
    return " ".join(result)


import re

def reverse2(s2):
    pattern = re.compile(r"([,]*\w+)+([,]*)")
    arr = pattern.findall(s2)  # ['fun', 'cat', ',' 'ball']
    print arr
    result = ""
    for item in arr:
        result += item[0][::-1] + item[1] + " "
        # check for nonalaphamueric in item
    # output the word
    return result


if __name__ == "__main__":
    test1 = "racecar"
    test2 = "auto"
    test3 = 'fun cat ,ball'
#    print isPalindrome(test1)  # true
#    print isPalindrome(test2)  # false
#    print reverse(test3)  # "nuf tac llab"
    print reverse2(test3)
    
    
# "fun cat ,ball" = > "nuf tac llab"
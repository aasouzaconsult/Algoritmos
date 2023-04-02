# Assume you have a method is_substring which checks if one word is a substring
#  of another.
# Given two strings, s1 and s2, write code to check if s2 is a rotation of s1
# using only 1 call to is_substring


def is_substring(s1, s2):
    if s2 in s1:
        return True
    return False


def check_substring(s1, s2):
    s1 += s1
    return is_substring(s1, s2)


if __name__ == "__main__":
    s1 = "waterbottle"
    s2 = "erbottlewat"
    s3 = "gfdag"
    print check_substring(s1, s2)
    print check_substring(s1, s3)

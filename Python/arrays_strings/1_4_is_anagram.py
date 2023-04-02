def is_anagram(string1, string2):
    """

    Write a method to decide if two strings are anagrams or not.

    """
    if len(string1) < 1 or len(string2) < 1:
        return False
    list1 = list(string1)
    list2 = list(string2)
    list1.sort()
    list2.sort()

    if list1 == list2:
        return True
    return False


def is_anagram_2(string1, string2):
    dict1 = {}
    for char in string1:
        if char in dict1.keys():
            dict1[char] += 1
        else:
            dict1[char] = 1
    dict2 = {}
    for char in string2:
        if char in dict2.keys():
            dict2[char] += 1
        else:
            dict2[char] = 1
    if dict1 == dict2:
        return True
    return False

if __name__ == "__main__":
    str1 = "apple"
    str2 = "pear"
    str3 = "orange"
    str1_1 = "paple"
    str2_2 = "raep"
    str3_3 = "rnageo"
    print is_anagram(str1, str1_1)
    print is_anagram(str2, str2_2)
    print is_anagram(str3, str3_3)
    print is_anagram(str1, str2)
    print is_anagram(str1, str3)
    print is_anagram(str2, str3)
    print ""
    print is_anagram_2(str1, str1_1)
    print is_anagram_2(str2, str2_2)
    print is_anagram_2(str3, str3_3)
    print is_anagram_2(str1, str2)
    print is_anagram_2(str1, str3)
    print is_anagram_2(str2, str3)

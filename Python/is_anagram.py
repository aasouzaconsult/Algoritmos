def check_anagram(first_words, second_words):
    for i in range(len(first_words)):
        str1 = list(first_words[i])
        print str1
        str1.sort()
        print str1
        str2 = list(second_words[i])
        print str2
        str2.sort()
        print str2
        if str1 == str2:
            print 1
        else:
            print 0


if __name__ == "__main__":
    str1 = ["cinema", "host", "aba", "train"]
    str2 = ["iceman", "shot", "bab", "rain"]
    check_anagram(str1, str2)

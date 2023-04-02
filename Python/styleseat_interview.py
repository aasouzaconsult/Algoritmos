# longest_consec("aaabbaa") -> ('a', 3)
# "aaabbbaa" -> ('a', 3)
# longest_consec("abcde") -> ('a', 1) # return the first character's occurence
# in the event there are no repeated characters, return the first character and it's occurence
# 
# Determine the longest consecutively repeated character in a string
# Return character and count

# write a function to take a string as input


# declare the function to take in a string
# check that the string is not empty
# initialise the curr_num and max_num

# O(n) where n is the length of the string
def longest_consec(a_string):
    if type(a_string) != type("a") or a_string == "":
        return None
    current = [a_string[0],1]
    out = [current] # histogram

    for alphabet in a_string[1:]: #O(n)
        if alphabet == current[0]:
            current[1] += 1
        else:
            current = [alphabet, 1]
            if out[0][1] < current[1]:
                out[0] = current

    return tuple(out[0]) # ('a', 3)
    

if __name__ == "__main__":
    print longest_consec("aaabbaa")
    print longest_consec("aaabbbaa")
    print longest_consec("abcde")
    # "aaaa" ('a', 4)
    print longest_consec("aaaa")

#Say you're dealing with data that has a lot of repeated characters in it. You'd like to take advantage of that to compress the data. In particular, you are given the following run-length encoding scheme: An encoded string is normally passed through verbatim. However, if there is a decimal number followed by the character 'x', then the character after the x will be repeated that many times."
#For example: "abc11xkd55s" -> "abckkkkkkkkkkkd55s"
#

#5x j
#11x k
#3x 2
#4x:

## python
#input: string of infinite chars
#output: parsed string where instructions are parsed

#case 1:string len 0
#case 2: normal string w/o any instructions
#case 3: with 1 or more instructions

#import re

#O(n)
#def parsed_string(string):
    #result = “”
    #temp = “”
    #reg_exp = “da-z”
    #tokens = string_tokenize(string) #  7 elements
    #for i in xrange(len(tokens)):
        #if re.match(reg_exp, tokens[i]):
            #num = int(tokens[i][-1])
            #alp = tokens[i][-1]
#result += alp * (num)
        #else:
            #result += tokens[i]
#return result

#def string_tokenize(string):
    #tokens = []
    #reg_exp = “da-z”
    ## run through the string
## if encounter reg_exp
## token.append()
#return tokens  # list

#string_tokenize(“abc5xjflks11xk48ugjkl3x2dfjkl”)
    #return [abc, 5xj, flks, 11xk, 48ugjkl, 3x2, dfjkl]

import re


def parse(a_string):
    pattern = re.compile(r'([0-9]+)x([a-z])')
    matches = pattern.findall(a_string)

    for match in matches:
        repl = match[1] * int(match[0])
        a_string = re.sub(pattern, repl, a_string)
    return a_string

if __name__ == "__main__":
    print parse('abc11xkd55s')

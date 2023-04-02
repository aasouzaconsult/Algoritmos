# Implement a CSVReader class that will read a comma-separated-values (CSV) file from disk, parse it, and print out the parsed elements with some other separator.
# Rules:

#     The input delimiter is the comma, ","

#     If that delimiter is contained within an element, then that element must be quoted

#     If quotes are contained in an element, use double inner quotes (escape character)

# Input:
# John,Smith,john.smith@gmail.com,Los Angeles,1
# Jane,Roberts,janer@msn.com,"San Francisco, CA",0
# "Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
# one,two,,four,"five"
# 
# Sample Output:
# John|Smith|john.smith@gmail.com|Los Angeles|1
# Jane|Roberts|janer@msn.com|San Francisco, CA|0
# Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
# one|two||four|five


def read_line(line):
    # return a list of fields
    if len(line) < 1:
        return
    result = ""
    tokens = line.split(',') # array
    closed_quotation = True
    # construct my result string
    for i in xrange(len(tokens)):
        if len(tokens[i]) < 1:
            continue
        elif tokens[i][0] == '"':
            # found a "quote term
            # if is "", first char in elemnt is always a ", immed elemnt always end with a "
            closed_quotation = False
            result += tokens[i][1:] + ','
        elif tokens[i][-1] != '"' and not closed_quotation:
            result += tokens[i] + ','
        elif tokens[i][-1] == '"':
            closed_quotation = True
            result += tokens[i][:len(tokens[i])-1] + "|"
        else:
            result += tokens[i] + "|"
    return result[:len(result)-1]

# "Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
# flag = True/False
# 1st split: split initial string by ""
# [alexandra, "alex", "Menendez,alex.menendez@gmail.com,Miami,1"]
# 2nd split: split by ","

import re


def parser(line):
    pattern = re.compile(r'([a-zA-Z0-9@-_.]+)|"(.*?)"', re.DOTALL)
    matches = pattern.findall(line)
    result = ""
    for match in matches:
        for item in match:
            if len(item) > 0:
                result += item + "|"
    return result

if __name__ == "__main__":
    #print read_line("John,Smith,john.smith@gmail.com,Los Angeles,1")
    #print read_line('Jane,Roberts,janer@msn.com,"San Francisco, s, CA",0')
    #print read_line('Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1one,two,,four,"five')
    print parser("John,Smith,john.smith@gmail.com,Los Angeles,1")
    print parser('Jane,Roberts,janer@msn.com,"San Francisco, s, CA",0')
    print parser('Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1one,two,,four,"five')
    # Jane|Roberts|janer@msn.com|San Francisco, s, CA|0
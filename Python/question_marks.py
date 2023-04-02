# A string consists of '0', '1' and '?'. The question mark can be either '0' or
# '1'. Find all possible combinations for a string.


import copy


def combinations(a_string):
    if len(a_string) < 1:
        return []
    result = []
    if a_string[0] == '?':
        result = ['0', '1']
    else:
        result.append(a_string[0])

    for a in a_string[1:]:
        if a == '?':
            additions = copy.deepcopy(result)
            for i in xrange(len(result)):
                result[i] += '0'
                additions[i] += '1'
            result.extend(additions)
        else:
            result = [alp + a for alp in result]
    return result


if __name__ == "__main__":
    test1 = '1010?'
    test2 = '?01010?'

    print combinations(test1)
    print combinations(test2)

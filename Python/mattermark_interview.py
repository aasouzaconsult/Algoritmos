# Given an array of positive numbers with size n, there is 1 duplicate number
# in the array. Find the duplicate and return the number.


def find_duplicate(a_list):
    if len(a_list) < 1:
        return
    histogram = {}
    for item in a_list:
        if item in histogram.keys():
            histogram[item] += 1
        else:
            histogram[item] = 1
    result = 0
    for key, value in histogram.items():
        if value > 1:
            result = key
    return result


def find_duplicate_v2(a_list):
    domain = len(a_list)-1
    aggregate = 0

    for i in range(domain):
        aggregate += i+1
    for i in range(len(a_list)):
        aggregate -= a_list[i]
    return abs(aggregate)


def find_duplicate_v3(a_list):
    a_list = sorted(a_list)

    result = None
    for i in range(len(a_list)):
        if a_list[i] != i + 1:
            result = a_list[i]
            break
    return result

if __name__ == "__main__":
    list1 = [3, 4, 2, 1, 3]
    print find_duplicate(list1)
    print find_duplicate_v2(list1)
    print find_duplicate_v3(list1)

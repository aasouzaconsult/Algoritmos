def countsort(a_list, max_range):
    count = [0 for i in range(max_range+1)]  # +1 for 0 index structure
    for item in a_list:
        count[item] += 1
    for i in range(1, len(count)):
        count[i] += count[i-1]
    for i in range(len(count)):  # adjust for 0 index structure
        count[i] -= 1

    result = [0 for i in range(len(a_list))]
    for i in range(len(result)-1, -1, -1):
        result[count[a_list[i]]] = a_list[i]  # -1 for 0 index structure
        count[a_list[i]] -= 1
    return result


if __name__ == "__main__":
    test_list = [2, 5, 3, 0, 2, 3, 0, 3]
    print countsort(test_list, 5)

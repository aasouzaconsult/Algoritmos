# Partition procedure rearranges the subarray in place.


def partition(a_list, start, end):
    # last element in array
    # the element index just before the start index
    # for loop from start index to end - 1 index
    #   if current index less equal than last element
    #       i increment 1
    #       exchange less and more value positions
    # exchange more value position with the last position(pivot)
    i = start - 1
    for j in range(start, end):
        if a_list[end] > a_list[j]:
            i += 1
            a_list[j], a_list[i] = a_list[i], a_list[j]
    a_list[i+1], a_list[end] = a_list[end], a_list[i+1]
    return i + 1


def quicksort(a_list, start, end):
    if start < end:
        pivot = partition(a_list, start, end)
        quicksort(a_list, start, pivot-1)
        quicksort(a_list, pivot+1, end)
    return a_list

if __name__ == "__main__":
    test_list = [2, 8, 7, 1, 3, 5, 6, 4]
    test_list2 = [13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11]
    print quicksort(test_list, 0, len(test_list)-1)
    print quicksort(test_list2, 0, len(test_list2)-1)

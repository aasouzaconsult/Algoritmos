import random


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


def random_partition(a_list, start, end):
    pivot_index = random.randint(start, end)
    a_list[pivot_index], a_list[end] = a_list[end], a_list[pivot_index]
    return partition(a_list, start, end)


def randomized_select(a_list, start, end, index):
    """

    Selects the indexed smallest element from a_list and return the element.

    """
    if len(a_list) == 1:
        return a_list[0]
    # get random partitioned index
    curr = random_partition(a_list, start, end)

    if index == curr:
        return a_list[curr]
    elif index < curr:
        return randomized_select(a_list, start, curr, index)
    else:
        return randomized_select(a_list, curr, end, index-curr)


if __name__ == "__main__":
    pass

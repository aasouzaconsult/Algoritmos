# max_heapify assumes that the binary trees rooted at left(i) and right(i) are
# max-heaps, but that A[i] might be smaller than its children, thus violating
# the max-heap property. max_heapify lets the value at A[i] "float down" in
# the max-heap so that the subtree rooted at index i obeys the max-heap
# property.
# parent -> floor(i/2)
# left -> 2*i
# right -> 2 * i + 1


def max_heapify(a_list, i):
    # left child index
    left = 2 * i + 1
    # right child index
    right = 2*i + 2
    largest_index = i
    if left < len(a_list) and a_list[left] > a_list[largest_index]:
        largest_index = left
    if right < len(a_list) and a_list[right] > a_list[largest_index]:
        if a_list[right] > a_list[left]:
            # right child largest
            largest_index = right
    if largest_index != i:
        a_list[i], a_list[largest_index] = a_list[largest_index], a_list[i]
        return max_heapify(a_list, largest_index)
    return a_list


def max_heapify_iterative(a_list, i):
    """
    Heapify iterative solution

    """
    # terminating condition: index is more less than heap size
    left = 2 * i + 1
    right = 2*i + 2

    while i < len(a_list):
        if a_list[right] > a_list[i]:
            largest_index = right
        elif a_list[left] > a_list[i]:
            largest_index = left

        if largest_index != i:
            a_list[i], a_list[largest_index] = a_list[largest_index], a_list[i]
            i = largest_index
    return a_list


def build_max_heap(a_list):
    # build a max heap from given list.
    for i in range((len(a_list)/2), -1, -1):
        max_heapify(a_list, i)
    return a_list


if __name__ == "__main__":
    test_list = [4, 1, 3, 2, 16, 9, 10, 14, 8, 7]
    print build_max_heap(test_list)

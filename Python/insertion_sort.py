# Insertion sort
# Avg time complexity: O(n^2)
# Best time comlexity: O(n^2)
# Worst time complexity: O(n^2)
# Space complexity: constant
# Inefficient for large data collections
#
# Takes in a list containing a sequence of length n that is to be sorted.
# Sorts the input numbers in place
# rearranges the numbers within the array A, with at most a constant number of
# them stored outside the array at any time.
# Input list contains the sorted output sequence when the insertion sort
# procedure is finished.


def insertion_sort(a_list):
    """
    check that list has size > 1
    iterate through the array
        def a variable key to store the current value in question
        iteratively check that key is less than the value before itself and not
        yet reached start of list
            if key is lesser than value before, move value 1 position to right
            move pointer 1 index left
        once iteration breaks, key's position is found. put key in the i+1 th
        position. where i is current value being checked
    """
    if len(a_list) < 2:
        return a_list
    for index in range(1, len(a_list)):  # O(n)
        key = a_list[index]
        i = index - 1
        while i >= 0 and a_list[i] > key:
            a_list[i+1] = a_list[i]
            i -= 1
        a_list[i+1] = key
    return a_list


def reverse_insertion_sort(a_list):
    """
    Sort a given list in nonincreasing order.

    """
    if len(a_list) < 2:
        return a_list
    for index in range(1, len(a_list)):
        key = a_list[index]
        i = index - 1
        while i >= 0 and a_list[i] < key:
            a_list[i+1] = a_list[i]
            i -= 1
        a_list[i+1] = key
    return a_list


if __name__ == "__main__":
    test_list1 = [5, 2, 4, 6, 1, 3, 0]
    print insertion_sort(test_list1)
    print reverse_insertion_sort(test_list1)
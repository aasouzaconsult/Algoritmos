# Bubble sort
# Avg time complexity: O(n^2)
# Best time comlexity: O(n^2)
# Worst time complexity: O(n^2)
# Space complexity: constant
# Inefficient for large data collections
# Not recommended for real world applications

# Repeatedly swapping adjacent elements that are out of order.
# Terminates when there are no swapping cases.


def sort_bubblesort(my_list):

    for pos_upper in xrange(len(my_list)-1, 0, -1):
        for i in xrange(pos_upper):
            if my_list[i] > my_list[i+1]:
                my_list[i], my_list[i+1] = my_list[i+1], my_list[i]
    return my_list

if __name__ == "__main__":

    my_list = [54, 26, 93, 17, 77, 31, 44, 55, 20]
    print my_list
    print sort_bubblesort(my_list)

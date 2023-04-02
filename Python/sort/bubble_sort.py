##################################
### Title: Bubble Sort    ########
### Author: GuoChen Hou   ########
##################################


def bubble_sort(sort_list):
    """
    Sorts a list of numbered elements in a list in ascending order using the
    bubble sort method.

    """
    size = len(sort_list)
    while True:
        swapped = False
        for i in range(1, size):
            if sort_list[i-1] > sort_list[i]:
                # swap values
                sort_list[i-1], sort_list[i] = sort_list[i], sort_list[i-1]
                swapped = True
        size -= 1
        if not swapped:
            break
    return sort_list

if __name__ == "__main__":
    number_list = [23, 17, 5, 90, 12, 44, 38, 84, 77]
    print bubble_sort(number_list)

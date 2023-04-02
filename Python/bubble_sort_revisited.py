def bubble_sort(random_list):
    """
    Sorts a list of numbered elements in a list in ascending order using bubble
    sort method

    """
    swapped = False

    size = len(random_list)
    while True:
        swapped = False
        for i in range(1, size):
            if random_list[i-1] > random_list[i]:
                # swap values
                random_list[i-1], random_list[i] = random_list[i],\
                    random_list[i-1]
                swapped = True
        size -= 1
        if not swapped:
            break
    return random_list


if __name__ == "__main__":
    number_list = [23, 17, 5, 90, 12, 44, 38, 84, 77]
    print bubble_sort(number_list)

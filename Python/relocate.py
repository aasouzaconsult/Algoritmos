# WAP to modify the array such that arr[I] = arr[arr[I]].
# Do this in place i.e. with out using additional memory.

# example : if a = {2,3,1,0}
# o/p = a = {1,0,3,2}

# Note : The array contains 0 to n-1 integers.


def relocate(a_list):
    """
    Relocates the input list elements.
    """

    for i in range(len(a_list)):
        a_list[i] += (a_list[a_list[i]] % len(a_list)) * len(a_list)
    print a_list
    for i in range(len(a_list)):
        a_list[i] /= len(a_list)
    print a_list

if __name__ == "__main__":
    test_list = [2, 3, 1, 0]
    relocate(test_list)

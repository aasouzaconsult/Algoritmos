# Write a function that takes a matrix and examines each item in a spiral
# order, printing each item as it comes to it.
#
# For example, given a matrix like this as input:
#
# [[11, 12, 13, 14, 15],
# [21, 22, 23, 24, 25],
# [31, 32, 33, 34, 35],
# [41, 42, 43, 44, 45]]
# Your program must print:
#
# 11 12 13 14 15 25 35 45 44 43 42 41 31 21 22 23 24 34 33 32

# cases:
# 1. input 2d array is empty
# 2. must not assume matrix is 'square' shaped


import copy
mod = __import__(__name__)


def spiral_output(matrix):
    if len(matrix) == 0:
        return
    result = []
    fns = ['left_right', 'top_bottom', 'right_left', 'bottom_top']
    new_matrix = copy.deepcopy(matrix)
    count = 0
    while len(new_matrix) != 0:
        temp = getattr(mod, fns[count % 4])(new_matrix)
        result.extend(temp[0])
        new_matrix = temp[1]
        count += 1
    return " ".join(str(x) for x in result)


def left_right(matrix):
    """
    Takes in a matrix and print top outermost layer from left to right.

    """
    return matrix.pop(0), matrix


def top_bottom(matrix):
    """
    Takes in a matrix and print right outermost layer from top to bottom.

    """
    result = []
    for array in matrix:
        result.append(array.pop(-1))
    return result, matrix


def right_left(matrix):
    """
    Takes in a matrix and print bottom outermost layer from right to left.

    """
    return matrix.pop(-1)[::-1], matrix


def bottom_top(matrix):
    """
    Takes in a matrix and print left outermost layer from bottom to top.

    """
    result = []
    for array in matrix:
        result.append(array.pop(0))
    return result[::-1], matrix


if __name__ == "__main__":
    test = [[11, 12, 13, 14, 15], [21, 22, 23, 24, 25], [31, 32, 33, 34, 35],
            [41, 42, 43, 44, 45]]
    print spiral_output(test)
    print mod
    print getattr(mod, 'right_left')

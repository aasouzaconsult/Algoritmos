def matrix_multiply(matrix1, matrix2):
    if len(matrix1) < 1 or len(matrix2) < 1:
        return []
    for row in matrix1:
        if len(row) != len(matrix2):
            return []
    result = []
    for row in matrix1:
        temp = []
        for col in zip(*matrix2):
            temp.append(0)
            for i, j in zip(row, col):
                temp[-1] += i * j
        result.append(temp)
    return result


if __name__ == "__main__":
    test1 = [[1, 2], [3, 4]]
    test2 = [[5, 6], [7, 8]]
    test3 = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    test4 = [[1, 4], [2, 5], [3, 6]]
    print matrix_multiply(test1, test2)
    print matrix_multiply(test3, test4)

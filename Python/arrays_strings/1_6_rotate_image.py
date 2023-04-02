# Given an image represented by an NxN matrix, where each pixel in the image is
# 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
# place?

# 1, 2, 3, 4
# 5, 6, 7, 8
# 9, 10, 11, 12
# 13, 14, 15, 16
# --->
# 12, 8, 4, 0
# 13, 9, 5, 1
# 14, 10, 6, 2
# 15, 11, 7, 3

# [0][0], [0][1], [0][2], [0][3]
# [1][0], [1][1], [1][2], [1][3]
# [2][0], [2][1], [2][2], [2][3]
# [3][0], [3][1], [3][2], [3][3]
# --->
# [3][0], [2][0], [1][0], [0][0]
# [3][1], [2][1], [1][1], [0][1]
# [3][2], [2][2], [1][2], [0][2]
# [3][3], [2][3], [1][3], [0][3]


def rotate(image):
    result = []
    for i in zip(image[0], image[1], image[2], image[3]):
        result.append(i[::-1])
    return result

if __name__ == "__main__":
    image = [[0 for _ in range(4)] for _ in range(4)]
    print image
    k = 0
    for i in range(4):
        for j in range(4):
            image[i][j] = k
            k += 1
    print image
    for i in range(4):
        for j in range(4):
            print image[i][j],
        print ""
    print ""
    new_image = rotate(image)
    print new_image
    for i in range(4):
        for j in range(4):
            print new_image[i][j],
        print ""
    print ""

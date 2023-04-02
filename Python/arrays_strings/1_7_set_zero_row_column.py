def set_zeros(image):
    nones = []
    for i in range(len(image)):
        for j in range(len(image)):
            if image[i][j] is None:
                nones.append([i, j])
    print nones
    # change rows with None
    for i in range(len(image)):
        for k in nones:
            for j in range(len(image)):
                if i == k[0]:
                    image[i] = [None for _ in image[i]]
                image[i][k[1]] = None
    print_image(image)


def print_image(image):
    for i in range(len(image)):
        for j in range(len(image[i])):
            print image[i][j],
        print ""
    return

if __name__ == "__main__":
    image = [[0 for _ in range(6)] for _ in range(6)]
    k = 0
    for i in range(len(image)):
        for j in range(len(image[i])):
            image[i][j] = k
            print image[i][j],
            k += 1
        print ""
    image[3][5], image[1][2] = None, None
    set_zeros(image)

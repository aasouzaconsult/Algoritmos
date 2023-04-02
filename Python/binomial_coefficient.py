# Dynamic programming solution to binomial coefficient computation


def binomial_coefficients(order):
    """
    Return up to the <order>-th binomial coefficients.

    """
    # initialize 2d array
    binomials = [[0 for i in xrange(order+1)] for j in xrange(order+1)]

    # initialize left-most binomial coefficients
    for i in xrange(len(binomials)):
        binomials[i][0] = 1
    # initialize right-most binomial coefficients
    for j in xrange(1, len(binomials)):
        binomials[j][j] = 1

    # compute in-between coefficients
    for k in xrange(2, len(binomials)):
        for l in xrange(1, k):
            binomials[k][l] = binomials[k-1][l] + binomials[k-1][l-1]

    return binomials


def print_list(array):
    for item in array:
        print item

if __name__ == "__main__":
    print_list(binomial_coefficients(10))

# Multiply all fields except it's own position
# input [2,3,1,4]
# output[12,8,24,6]

# Restrictions:
# 1. no use of division
# 2. complexity in O(n)

# initialize output list same size as input list
# initalize a front and rear array
# front to store multiplication of all elements before index
# rear to store multiplication of all elements after index
# mulitiply front and rear same index value together to get output


def product(new_input):
    """
    Multiply all fields except its own position and put the result value in its
    index.
    """
    # initialize additional lists
    output = [None] * len(new_input)
    front = [None] * len(new_input)
    rear = [None] * len(new_input)

    # first value of front and last value of rear are 1, since there's no value
    # before front or after rear.
    front[0] = 1
    rear[len(new_input)-1] = 1

    for i in range(1, len(new_input)):
        front[i] = front[i-1] * new_input[i-1]
    for i in range(len(new_input)-2, -1, -1):
        rear[i] = rear[i+1] * new_input[i+1]
    for i in range(len(new_input)):
        output[i] = front[i] * rear[i]

    return output

if __name__ == "__main__":
    new_input = [2, 3, 1, 4]
    print product(new_input)

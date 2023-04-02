"""
input:
List 1: [4, 10, 15, 24, 26]
List 2: [0, 9, 12, 20]
List 3: [5, 18, 22, 30]

# size of each list? 10,000
# each list have at least 1 item
output: [20,24] <-- diff of 4

Given K sorted lists, find the smallest range that includes at least 1 number
from each list

"""
import copy


def smallest_range_trivial(list1, list2):
    """
    find the smallest range for 2 sorted lists.
    List 1: [4, 10, 15, 24, 26]
    List 2: [0, 9, 12, 20]
    O(2n * m + m) <-> O(n^2)

    """
    # check that both lists are not none
    if len(list1) < 1 or len(list2) < 1:
        return
    # initialize a list to store all the least ranges
    lesser = []
    # get the contributor for each lesser values
    contributor = []
    # iterate through the 2 lists and find the list of lesser values and their
    # corresponding contributors
    for i in range(len(list2)):  # O(m)
        # initialize current list to store ranges between each list2 item and
        # each list1 item
        current = []
        # initalize values list to store their corresponding values that
        # contributes to this range
        values = []
        for j in range(len(list1)):  # O(n)
            # put the result of the comparison in each of the 2 lists
            current.append(abs(list2[i]-list1[j]))
            values.append([list2[i], list1[j]])
        # find the least range value among the current list and append to
        # lesser values
        lesser.append(min(current))
        # find the contributing values that makes up this lesser value and
        # append to contributor list
        for i in range(len(current)):  # O(n)
            if current[i] == min(current):
                contributor.append(values[i])
                break
    # initialize the result items
    least = lesser[0]
    result = contributor[0]
    # find the result least value and its corresponding result values
    for i in range(len(lesser)):
        if lesser[i] < least:
            least = lesser[i]
            result = contributor[i]
    return result

######################################################################

# O(n*k) where n is number for which a list has the most number of items and k
# is the number of lists


def smallest_range(*args):
    """
    find smallest_range for a list of lists

    """
    # typecast arguments to a list
    lists = list(args)

    # the current set of items in question
    current = []  # [4, 0, 5] for first set of inputs
    # initialize index content of every list to 0
    indexes = [0 for i in lists]
    # initialize ranges to track the results from each set of currents
    # ranges has the format [[range_num, [item1, item2, item3]], ...]
    range_set = []

    # initialize current
    for i in range(len(lists)):  # O(k)
        current.append(lists[i][indexes[i]])
        indexes[i] += 1

    # add the current set into range_set
    # we use deepcopy here to deassociate the copied current with the changing
    # current below
    range_set.append([abs(max(current)-min(current)), copy.deepcopy(current)])

    # set a index to keep track of currently assessed index
    # will also be used to detect loop terminating condition
    current_index = 1
    while True:
        # set a current_index somewhere below
        try:
            list_item = lists[current_index][indexes[current_index]]
        except IndexError:
            # 1 of the list in lists has been exhausted, end loop here
            break

        # determine which list item to extract
        for i in range(len(current)):  # O(n)
            if current[i] == min(current):
                # replace with next element in the i-th list
                current[i] = lists[i][indexes[i]]  # new current generated
                indexes[i] += 1
                break
        # determine the next element to extract and set the current_index
        for i in range(len(current)):  # O(n)
            if current[i] == min(current):
                current_index = i
        # if current range is less than stored range, replace with new range
        # set.
        if range_set[0][0] > abs(max(current)-min(current)):
            range_set = [abs(max(current)-min(current)),
                         copy.deepcopy(current)]

    # range_set has the least range and the corresponding data
    result = range_set[1]
    return result

if __name__ == "__main__":
    list1 = [4, 10, 15, 24, 26]
    list2 = [0, 9, 12, 20]
    list3 = [5, 18, 22, 30]
    print smallest_range_trivial(list1, list2)  # [9, 10]
    print smallest_range_trivial(list2, list3)  # [18, 20]
    print smallest_range_trivial(list1, list3)  # [5, 4]
    print "===="
    print smallest_range(list1, list2, list3)  # [24, 20, 22]

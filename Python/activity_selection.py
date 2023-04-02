# Activity selection problem
# Given a list of activities characterised by their start and end times, we
# wish to select a maximum size subset of mutually compatible devices.

# assume start end pairs are sorted in nondecreasing order of end
# i     1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
# start 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12
# end   4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16


def activity_selector_recursive(start, end, result, index):
    next = index+1
    while next < len(start) and start[next] < end[index]:
        next += 1

    if next <= len(start):
        result.append((start[index], end[index]))
        return activity_selector_recursive(start, end, result, next)

    return result


def activity_selector_iterative(start, end):
    result = [(start[0], end[0])]
    curr = 0
    for i in xrange(1, len(start)):
        if start[i] >= end[curr]:
            result.append((start[i], end[i]))
            curr = i
    return result

if __name__ == "__main__":
    start = [1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12]
    end = [4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16]
    print activity_selector_recursive(start, end, [], 0)
    print activity_selector_iterative(start, end)

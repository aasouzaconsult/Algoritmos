def hill(v):
    # Write your code here
    # To print results to the standard output you can use print
    # Example print "Hello world!"
    v_sort = v[:]
    v_sort.sort()
    print v
    print v_sort
    values = []
    for i in range(len(v)):
        values.append(abs(v_sort[i] - v[i]))
    print values
    print max(values)


if __name__ == "__main__":
    v = [5, 4, 3, 2, 8]
    hill(v)

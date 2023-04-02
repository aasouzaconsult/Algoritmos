from random import randint

"""
This is a recursive solution.
For iterative solution, refer to:
http://stackoverflow.com/questions/12553238/quicksort-iterative-or-recursive
"""

def partition(a_list, start, end):
	"""
	Partitions the list by inserting a_list[partition_index] at index h where it should be if the array was sorted.
	Returns the index h where values at indexes less than h are less than a_list[partition_index], and values at indexes greater than h
	are greater than or equal to a_list[partition_index].
	"""

	value = a_list[start]
	h = start

	for k in range(start+1, len(a_list)):
		if a_list[k] < value:
			h += 1
			# swap between value at partition_index and value at index k
			a_list[h], a_list[k] = a_list[k], a_list[h]
	
	# swap values between index at partition_index and h
	a_list[start], a_list[h] = a_list[h], a_list[start]
	return h

def random_partition(a_list, start, end):
	k = randint(start, end)
	a_list[start], a_list[k] = a_list[k], a_list[start]
	return partition(a_list, start, end)

def quicksort_recurs(a_list, start, end):
	if start < end:		
		partition_index = partition(a_list, start, end)
		quicksort_recurs(a_list, start, partition_index-1)
		quicksort_recurs(a_list, partition_index+1, end)		
	return a_list

def random_quicksort_recurs(a_list, start, end):
	if start < end:
		partition_index = random_partition(a_list, start, end)
		random_quicksort_recurs(a_list, start, partition_index-1)
		random_quicksort_recurs(a_list, partition_index+1, end)
	return a_list

def quicksort(a_list):
	"""
	Sorts the array using the partition algorithm above
	"""
	return quicksort_recurs(a_list, 0, len(a_list)-1)

def random_quicksort(a_list):
	"""
	Sorts a_list by using random_partition algorithm
	Improves the time complexity of quicksort function from O(n2) to O(n lg n)
	"""
	return random_quicksort_recurs(a_list, 0, len(a_list)-1)


if __name__ == "__main__":
    test_list = [12,30,21,8,6,9,1,7]
    partition(test_list, 0, len(test_list)-1)
    print quicksort(test_list)
    print random_quicksort(test_list)

def counting_sort(a_list, limit):
	"""
	Sorts the array a_list, with values ranging from 0 to range inclusive, using counting sort method.
	"""
    # limit is the highest number that appears in the list
	limit += 1 # account for 0 index issue
	result = [None] * len(a_list)
	freq = [0] * limit

	# count the number of times each value in a_list occurs and store in freq list
	for i in range(len(a_list)):
		freq[a_list[i]] += 1

	# modify freq list so each index value represents the number of elements <= value
	for i in range(1, limit):
		freq[i] += freq[i-1]

	# sort a_list with result in result list
	for i in range(len(a_list)-1, -1, -1):		
		result[freq[a_list[i]]-1] = a_list[i]
		freq[a_list[i]] -= 1

	return result

def radix_sort(a_list, digits):
	for i in range(digits-1):
		a_list = counting_sort(a_list, 10)
	return a_list

if __name__ == "__main__":
	a = [5,8,3,8,10,7]
	print counting_sort(a, 10)
	print radix_sort(a, 2)
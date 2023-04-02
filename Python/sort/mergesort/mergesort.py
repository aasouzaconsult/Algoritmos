def merge_v1(a_list, start, mid, end):
	"""
	This function receives as input indexes start, mid & end and an array a_list where a[i],...,a[m] and a[m+1],...,a[j] are each
	sorted in nondecreasing order. These two nondecreasing subarrays are merged into a single nondecreasing array
	"""
	result = [-1] * len(a_list)
	curr1 = start # current index to 1st segment of array
	curr2 = mid + 1 # current index to 2nd segment of array
	curr_r = start # current index in the result array

	while curr1 <= mid and curr2 <= end:
		# copy smaller value to result list
		if a_list[curr1] <= a_list[curr2]:
			result[curr_r] = a_list[curr1]
			curr1 += 1
		else:
			result[curr_r] = a_list[curr2]
			curr2 += 1
		curr_r += 1

	while curr1 <= mid:
		result[curr_r] = a_list[curr1]
		curr1 += 1
		curr_r += 1

	while curr2 <= end:
		result[curr_r] = a_list[curr2]
		curr2 += 1
		curr_r += 1

	return result

def merge_v2(left_list, right_list):
	"""
	This function receives as inputs left_list and right_list are each
	sorted in nondecreasing order. These two nondecreasing subarrays are merged into a single nondecreasing array
	"""
	result = []
	i, j = 0, 0
	while i < len(left_list) and j < len(right_list):
		if left_list[i] <= right_list[j]:
			result.append(left_list[i])
			i += 1
		else:
			result.append(right_list[j])
			j += 1

	result += left_list[i:]
	result += right_list[j:]
	return result

def mergesort_v1(a_list, start, end):
	"""
	This function sorts the array a[i], ..., a[j] in nondecreasing order. It uses the merge_v1 algorithm
	"""	

	if (end - start) <= 1:
		return a_list
	else:
		mid = (start + end) / 2
		left = a_list[:mid]
		right = a_list[mid:]
		#sort each half
		left = mergesort_v1(left, 0, len(left)-1)
		right = mergesort_v1(right, 0, len(right)-1)
		temp = left + right
		# merge 2 sorted halves
		return merge_v1(temp, 0, len(left)-1, len(temp)-1)

def mergesort_v2(a_list):
	"""
	This function sorts the array a[i], ..., a[j] in nondecreasing order. It uses the merge_v2 algorithm
	"""	
	left, right = [], []
	if len(a_list) <= 1:
		return a_list
	else:
		mid = (len(a_list)) / 2		
		for element in a_list[:mid]:			
			left.append(element)

		for element in a_list[mid:]:
			right.append(element)

		left = mergesort_v2(left)
		right = mergesort_v2(right)
		return merge_v2(left, right)		

def join_sublists(a_list):
	result = []

	for i in range(len(a_list)//2): # time complexity of O(n/2)
		result.append(merge_v2(a_list[i*2], a_list[i*2+1]))		
	if len(a_list) % 2 == 1: # odd number of elements
		result.append(a_list[-1])	
	return result

def mergesort_v3(a_list):
	"""
	This function sorts the array a[i], ..., a[j] in nondecreasing order iteratively. It uses the merge_v2 algorithm
	Has a time complexity of O(nlg n)
	"""
	if len(a_list) <= 1:
		return a_list
	a_list = [[element] for element in a_list]
	
	while len(a_list) > 1: # time complexity of O(lg n)
		a_list = join_sublists(a_list)	
	return a_list[0]


if __name__ == "__main__":
	num_list = [14,20,36,10,12,30,40,44]

	print merge_v1(num_list, 0, 2, len(num_list)-1)
	print mergesort_v1(num_list, 0, len(num_list)-1)
	print merge_v2(num_list[:3], num_list[3:])	
	print mergesort_v2(num_list)
	print mergesort_v3(num_list)
from quicksort import random_partition

def random_select(a_list, start, end, chosen_index):
	"""
	Rearranges the array so that chosen value is at index 'chosen_index'. All values at indexes 'chosen_index' are less than value, and
	all values to the right are greater than or equal to val. The algorithm uses random_partition algorithm.
	"""
	if (start < end):
		position = random_partition(a_list, start, end)

		if chosen_index == position:
			print a_list
			return a_list
		if chosen_index < position:
			random_select(a_list, start, position-1, chosen_index)
		else:
			random_select(a_list, position+1, end, chosen_index)


if __name__ == "__main__":
	test_list = [17,21,5,23,9,37,15,3,11,25,31,13,29,7,19]
	random_select(test_list, 0, len(test_list)-1, len(test_list)-1)
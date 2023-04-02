##################################
### Title: Selection Sort ########
### Author: GuoChen Hou   ########
##################################

# This program sorts the elements in a list in ascending order using selection sort method.

def find_min(number_list, first_index):
	"""Find the minimum number in the list and return its corresponding index in the list"""
	least = number_list[first_index]
	least_index = first_index
	for index in range(first_index, len(number_list)):
		if number_list[index] < least:
			least = number_list[index]
			least_index = index
	return least_index

def swap(number_list, first_index, swap_index):
	temp = number_list[first_index]
	number_list[first_index] = number_list[swap_index]
	number_list[swap_index] = temp

number_list = [23,17,5,90,12,44,38,84,77]
first_index = 0

while first_index < len(number_list):
	swap_index = find_min(number_list, first_index)
	swap(number_list, first_index, swap_index)
	first_index += 1
print number_list
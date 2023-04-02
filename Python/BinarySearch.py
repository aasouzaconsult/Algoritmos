class BinarySearch:
	def __init__(self):
		pass

	def binary_search_recursive(self, a_list, start, end, value):
		"""
		This function performs a recursive binary search on the a_list array for value
		Returns the index of the value in array if found, otherwise return -1
		"""
		mid = (start + end) / 2
		if value == a_list[mid]:
			return mid
		if start > end:
			return -1
		if value < a_list[mid]:
			return binary_search_recursive(a_list, start, mid-1, value)
		else:
			return binary_search_recursive(a_list, mid+1, end, value)

	def binary_search_iterative(self, a_list, start, end, value):
		"""
		This function performs an iterative binary search on the a_list array for value
		Returns the index of the value in array if found, otherwise return -1
		"""
		mid = (start + end) / 2
		while(start <= end):
			if value == a_list[mid]:
				return mid
			if value < a_list[mid]:
				end = mid - 1
			else:
				start = mid + 1
		return -1

if __name__ == "__main__":
	pass
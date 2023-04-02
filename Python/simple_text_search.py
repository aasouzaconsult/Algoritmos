def simple_text_search(sub_string, text):
	"""
	Searches for an occurence of a pattern 'substring' in a text 'text'.
	Returns the smallest index i such that there is a match for 'sub_string' or -1 if no such index exists
	Function has a time complexity of O(m(n-m+1)). Where m denotes length of sub_string and n denotes length of text string.
	"""
	i = 0
	while (i + len(sub_string)) <= len(text):
		j = 0
		while text[i+j] == sub_string[j]:
			j += 1
			if j >= len(sub_string):
				return i
		i += 1
	return -1

if __name__ == "__main__":
	sub = "001"
	text = "010001"
	print simple_text_search(sub, text)

s = ['a','b','c','d']

def reverse(s):
	length = len(s)

	new_list = [None]*length
	print new_list
	for item in s:
		length -= 1
		new_list[length] = item
	return new_list

print reverse(s)
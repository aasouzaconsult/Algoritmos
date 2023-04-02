"""
Given a decimal number, convert it to its binary equivalent and vice versa.
"""

from ADT.Stack import Stack_linkedlist

def decimal(binary_value):
	"""	
	Given a binary value in string format, return its decimal equivalent in integer format.
	
	1. If len(binary_value) == 0, return None
	2. result = 0
	3. multiplier = 1
	4. For reverse iterate len(binary_value):
			if binary_value[i] == "1":
				result += binary_value[i] * multiplier
				multiplier *= 2
	5. return int(result)

	Algorithm has time complexity O(n).
	"""
	if len(binary_value) == 0:
		return
	result = 0
	multiplier = 1
	for i in range(len(binary_value)-1, -1, -1):
		if binary_value[i] == "1":
			result += multiplier
		multiplier *= 2
	return int(result)

def binary(decimal_value):
	"""
	Given an unsigned integer, return its binary equivalent.
	
	1. Create a stack
	2. While value > 0:
			divide value by 2
			put modolo into stack
			repeat
	3. While stack is not empty:
			pop an item from stack
			add the item with its multiplier to result
			increment multiplier
	4. return result

	Algorithm has time complexity O(n). Where n is the smallest value that satisfies 2**n >= decimal_value:
	"""
	stack = Stack_linkedlist()
	while decimal_value > 0: # comlexity O(lg n)
		remainder = decimal_value % 2
		decimal_value /= 2
		stack.push(remainder)
	result = 0
	multiplier = 10**(stack.get_size() - 1)

	while not stack.empty(): # complexity O(n)
		result += stack.pop() * multiplier
		multiplier /= 10
	return result

if __name__ == "__main__":
	#value = int(raw_input("Enter a decimal number: "))
	#print "%d in decimal converts to %d in binary." % (value, binary(value))
	value = raw_input("Enter a decimal number: ")	
	print "%s in binary converts to %d in decimal." % (value, decimal(value))

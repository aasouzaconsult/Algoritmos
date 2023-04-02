##################################
###	Fibonacci Sequence ###########
##################################

# This program takes a number as the sequence number of fibonacci and returns the 
# fibonacci sequence up to that number sequence

def fibonacci_number(index):
	"""
	Computes the fibonacci number given its index recursively.
	Return the value at index 
	"""
	if index <= 0:
		return 0
	elif index == 1 or index == 2:
		return 1
	else:
		return fibonacci_number(index-1) + fibonacci_number(index-2)

def fibo1(index):
	"""
	Computes the fibonacci number gives its index.
	Return the value at index.
	Dynamic programming algorithm used.
	Runs in time O(n).
	"""
	#index -= 1 # 0 index offset
	result = []
	result.append(0)
	result.append(1)
	result.append(1)
	for i in range(3, index+1):
		result.append(result[i-1] + result[i-2])
	return result[index]

def fibo2(index):
	"""
	Computes the fibonacci number given its index.
	Return the value at index
	Dynamic programming algorithm used.
	The algorithm saves two preceding fibo numbers in the variables f_twoback and f_oneback in order to compute the next fibo number.
	Runs in time O(n).
	"""
	if index <= 0:
		return
	elif index == 1:
		return 1
	elif index == 2:
		return 1
	f_twoback = 1
	f_oneback = 1
	for i in range(3, index+1):
		f = f_twoback + f_oneback
		f_twoback = f_oneback
		f_oneback = f
	return f

def memoized_fibo(index):
	"""
	Computes the fibonacci number given its index.
	Runs in time O(n).
	"""
	index += 1	
	result = [None] * index
	result[0] = 0
	return memoized_fibo_recurs(result, index)

def memoized_fibo_recurs(result_list, index):
	"""
	Recursive call to function and then add the value to the result_list for future reference.
	"""
	if result_list[index-1] != None:
		print result_list
		return result_list[index-1]
	if index == 0:
		return 0
	elif index == 1 or index == 2:
		value = 1
	else:
		value = memoized_fibo_recurs(result_list, index - 2)
		value += memoized_fibo_recurs(result_list, index - 1)
	result_list[index-1] = value
	return value

def sequence(index, func):
	fib_sequence = [None] * (index)
	for i in range(index-1):
		fib_sequence[i] = func(i)
	return fib_sequence

while True:
	try:
		index = int(raw_input('Enter the index for Fibonacci sequence or "quit" to quit: '))
	except ValueError:
		print 'Bye'
		break
	print sequence(index, fibonacci_number)
	print fibo1(index)
	print fibo2(index)
	print memoized_fibo(index)
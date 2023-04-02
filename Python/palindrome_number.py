##################################
### Title: Palindrome     ########
### Author: GuoChen Hou   ########
##################################

# This program reads two integers, a start value and an end value. Then computes the number of 
# Palindrome numbers in the range from start to end. It is assumed the the largest integer input
# contains at most 9 digits.
# A recursive solution is used.

def isPalindrome(a_list):
	"""Returns True if a_list contains number digits that are palindrome"""
	if len(a_list) == 1:
		return True
	elif palindromeRecur(a_list):
		return True
	else:
		return False

def palindromeRecur(a_list):
	"""
	Recursively computes a_list and returns True if the number is palindrome
	"""
	if len(a_list) <= 1:
		return True
	elif a_list[0] == a_list[-1]:
		a_list.pop(0)
		a_list.pop(-1)
		return palindromeRecur(a_list)
	else:
		return False

def toList(a_number):
	"""Converts a_number to a list of its digits"""
	num_string = str(a_number)
	a_list = []
	for char in num_string:
		digit = int(char)
		a_list.append(digit)
	return a_list

start, end = raw_input('Enter start and end: ').split()
start,end = int(start), int(end)

count = 0
start_list = []
end_list = []

if start > end:
	print 'start must be equal or smaller than end'
else:
	for num in range(start, end+1):
			start_list = toList(num)
			if isPalindrome(start_list):
				count += 1
			start_list = []
	print 'Number of palindrome numbers =', count

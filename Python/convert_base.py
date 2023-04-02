##################################
### Title: Convert Base   ########
### Author: GuoChen Hou   ########
##################################

# Conver a postitive integer in decimal(base 10) to another base by doing repeated division.
# For bases larger than 10, the digits 10, 11, 12, ... are represented by the characters 
# A, B, C, ... Hence the digits in hexadecimal are 
# 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, and F.
# The program executes a recursive solution.

def changeBase(a_number, a_base, a_list):
	"""Change a_number to an integer of a_base"""
	if a_number == 0:
		return a_list
	else:
		a_list.append(a_number % a_base)
		changeBase(a_number/a_base, a_base, a_list)

def toInteger(a_list):
	"""Convert a_list of integer digits to an integer string"""
	answer = ''
	for digit in reversed(a_list):
		answer += str(hex_convert(digit))
	return answer

def hex_convert(a_number):
	if a_number > 9:
		return chr(ord('A')+a_number - 10)
	else:
		return chr(ord('0')+a_number)

num = int(raw_input('Enter a positive decimal integer: '))
base = int(raw_input('Enter target base (2-36):  '))
number = num

remainder = []
changeBase(num, base, remainder)
print '%d converted to base %d = %s' % (number, base, toInteger(remainder))
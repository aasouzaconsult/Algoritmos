##################################
### Title: Magic Number   ########
### Author: GuoChen Hou   ########
##################################

# Reads positive integers and for each, adds up the numbers(from right) in positions 1,3, and 5.
# The right-most number of the sum is the required answer

def compute_magic_number(number):
	value = 0
	for digit in range(len(number)):
		if digit % 2 == 0:
			print number[digit]
			value += int(number[digit])
	while value >= 10:
		value -= 10
	return value

while True:
	num = raw_input('Enter a value: ')
	number = num[::-1]
	if number == 'quit':
		break
	else:
		magic_number = compute_magic_number(number)
		print 'Magic number =', magic_number
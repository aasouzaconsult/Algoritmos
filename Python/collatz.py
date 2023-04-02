##################################
### Title: Collatz Problem #######
### Author: GuoChen Hou   ########
##################################

# Also known as 3x + 1 problem
# Take any natural number - number, 
# If n is even,
# 	divide it by 2 to get n/2
# else:
# 	triple it and add 1 to obtain 3n+1
# Repeat the process indefinitely. No matter what number you start with, you will always eventually reach 1
# This program calculates the number of iterations to reach 1.

def count_iterations(n):
	iter_number = 0
	while n != 1:
		if n % 2 == 0:
			n /= 2
		else:
			n = 3*n + 1
		iter_number += 1
	return iter_number

number = int(raw_input('Enter a natural number: '))

print 'Number of iterations =', count_iterations(number)

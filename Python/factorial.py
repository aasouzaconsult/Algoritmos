##################################
### Title: Factorial      ########
### Author: GuoChen Hou   ########
##################################

# Computes the factorial of a number

def factorial(number):
	if number == 1:
		return number
	else:
		return number * factorial(number-1)

print factorial(5)

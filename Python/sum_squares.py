##################################
### Title: Sum of Squares ########
### Author: GuoChen Hou   ########
##################################

# This program takes in 2 integers and computs the sum of squares from 
# first integer up to 2nd integer

def sumSq(number_1, number_2):
	if number_1 == number_2:
		return pow(number_2, 2)
	else:
		return pow(number_1, 2) + sumSq(number_1+1, number_2)

print sumSq(5,10)
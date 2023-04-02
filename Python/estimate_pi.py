##################################
### Title: Estimate pi    ########
### Author: GuoChen Hou   ########
##################################

# This program estimates the pi value given at least 3 non-negative integers using applications of 
# certain theorems in number theory.
# Professor Robert A.J. Matthews of the Applied Mathematics and Computer Science Department at 
# the University of Aston in Birmingham, England, has recently described how the positions of 
# stars across the night sky may be used to deduce a surprisingly accurate value of p.

# Algorithm:
# 1. Take in a list of integers
# 2. Compute a list of list of integers
# 3. Find the pairs with no common factor other than 1
# 4. Compute value of pi with the equation 6/pow(p,2) = ratio
# 5. Print p

from fractions import gcd
from math import sqrt

def compute_pairs_list(input_list):
	"""
	Takes in a list of integers and return a paired list of every unique pair of integers
	"""
	pair = []
	pairs_list = []
	while input_list:
		sub_input_list = input_list[1:]
		for index in range(len(sub_input_list)):
			pair.append(input_list[0])
			pair.append(sub_input_list[index])
			pairs_list.append(pair)
			pair = []
		input_list.pop(0)
	return pairs_list

input_list = []
input_list = list(raw_input().split())
for index in range(len(input_list)):
	input_list[index] = int(input_list[index])

pairs_list = compute_pairs_list(input_list)

counter = 0
for pair in pairs_list:
	if gcd(pair[0], pair[1]) == 1:
		counter += 1

ratio = counter / float(len(pairs_list))
p = sqrt(6 / ratio)
print '%.4f' % p
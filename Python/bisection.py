##################################
### Title: Bisection      ########
### Author: GuoChen Hou   ########
##################################

# This program simulates the bisection method in numerical analysis.
# This is achieved as follows. The bisection method finds the midpoint m of the two 
# endpoints a and b, and depending on the sign of p(m) (the function value at m), 
# it replaces either a or b with m (so m now becomes one of the two endpoints). 
# It repeats this process and stops when one of the following two events happens:
# 1. when the midpoint m is the root, or
# 2. when the difference between the two endpoints a and b falls within a threshold, 
# that is, when they become very close to each other. We shall set the threshold to 0.0001 
# for this exercise. Then the midpoint m is calculated as (a+b)/2, and this is the 
# approximated root.

import math

THRESHOLD = 0.0001
NMAX = 100

def polynomial(a, b, c3, c2, c1, c0):
	n = 1
	result = [None]*2

	while n <= NMAX:
		root = (a + b) / 2
		print '%f = (%f+%f)/2' % (root, a, b)
		p_root = c3*pow(root, 3) + c2*pow(root, 2) + c1*root + c0
		p_a = c3*pow(a, 3) + c2*pow(a, 2) + c1*a + c0

		if p_root == 0 or (b-a)/2 < THRESHOLD:
			result[0] = root
			result[1] = p_root
			break
		n += 1
		if math.copysign(1, p_root) == math.copysign(1, p_a):
			a = root
		else:
			b = root
	return result

c3,c2,c1,c0 = raw_input('Enter coefficients (c3,c2,c1,c0) of polynomial: ').split()
a,b = raw_input('Enter endpoints a and b: ').split()

c3 = int(c3)
c2 = int(c2)
c1 = int(c1)
c0 = int(c0)
a = float(a)
b = float(b)

result = polynomial(a, b, c3, c2, c1, c0)

print 'root =', result[0]
print 'p(root) =', result[1]
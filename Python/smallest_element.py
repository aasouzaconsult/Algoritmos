##################################
###	Smallest_element		   ###
##################################

# Finds the smallest element among 3 elements a,b,c
# 1. Assign x to a
# 2. If b < x, x = b
# 3. if c < x, x = c 

a = 5
b = 3
c = 12

def smallest(a,b,c):
	x = a
	if x > b:
		x = b
	if x > c:
		x = c
	return x

print 'Smallest element is:', smallest(a,b,c)
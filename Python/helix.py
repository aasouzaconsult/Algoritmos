import math

def helix(rune, n):
	new_value = n
	compute(new_value)
	for a in range(1,n):
		x = radius * math.sin(a * (2*math.pi/n))
		y = radius * math.cos(a * (2*math.pi/n))
		print "x is %s" % x
		print "y is %s" % y

helix(1, 9)

def compute(n):
	rune_size = 2 / n
	radius = 0.5 - (1/n)
	degree = (2*math.pi)/n
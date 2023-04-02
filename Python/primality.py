##################################
### Title: Primality      ########
### Author: GuoChen Hou   ########
##################################

# The program tests if a number is prime using the following 4 methods.
# 1. Trial division method - is_prime_test1()
# 2. Fermat's little theorem method - is_prime_test2()
# 3. Miller Rabin method - is_prime_test3()
# 4. Murderous method - is_prime_test4()

import math
import random
import time, sys

REPS = 1000

def is_prime_test1(n):
	"""Check if a number is prime using Trial division method"""
	prime = True
	number = 4

	if n % 2 == 0 or n % 3 == 0:
		prime = False
	else:
		while number <= int(math.sqrt(n)):
			if n % number == 0:
				prime = False
				break
			number += 1
	return prime

def is_prime_test2(n):
	"""Check if a number is prime using Fermat's Little Theorem method"""
	prime = True
	k = 10 #Determines the number of times to test for primality
	for index in range(k):
		number = random.randint(1, n-1)
		if pow(number, n-1) % n != 1:
			prime = False
			break
	return prime

def is_prime_test3(n):
	prime = False
	k = 10 # Determines the number of times to test for primality

	s = 1
	t = (n-1)/2
	while t%2 == 0:
		t /= 2
		s += 1
	for r in range(0, k):
		rand_num = random.randint(1, n-1)
		y = pow(rand_num, t, n)
		
		if (y == 1):
			prime = True

		for i in range(0,s):
			if (y == n-1):
				prime = True
				break
			else:
				y = (y*y) % n
	return prime

def is_prime_test4(n):
	"""Check if a number is prime using Murderous method"""
	prime = False
	value =  str(float(pow(n, 2) + 17) / 12)
	if ".5" in value:
		prime = True
	return prime

def prime_list(n):
	"""Print out a list of all prime numbers from 1 to n"""
	prime_list = [1,2,3]
	for number in range(n+1):
		if number == 0:
			continue
		elif is_prime_test1(number):
			if number < 3:
				continue
			prime_list.append(number)
	return prime_list

def execution_speed(func, *args):
	"""Calulates the execution speed of a function in milliseconds"""
	startTime = time.time()
	for i in range(REPS):
		func(*args)
	elapsed = time.time() - startTime
	return elapsed

n = int(raw_input('Enter a positive integer: '))
prime_test = []
test_type = []

prime_test.append(is_prime_test1(n))
test_type.append('Trial Division')
prime_test.append(is_prime_test2(n))
test_type.append('Fermat\'s little theorem')
prime_test.append(is_prime_test3(n))
test_type.append('Miller Rabin')
prime_test.append(is_prime_test4(n))
test_type.append('Murderous')

test_funcs = [is_prime_test1, is_prime_test2, is_prime_test3, is_prime_test4]

for index in range(len(prime_test)):
	if prime_test[index]:
		print '%d is a prime according to %s method.' % (n, test_type[index])
	else:
		print '%d is not a prime according to %s method.' % (n, test_type[index])

print '\nAll prime integers between 0 to %d: ' % n
print prime_list(n)

for func in test_funcs:
	print '%s execution speed is %.10f' % (str(func), float(execution_speed(func, n)) * 1000)
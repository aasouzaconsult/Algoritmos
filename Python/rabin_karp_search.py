import random

def rabin_karp_search(pattern, text):
	"""
	Searches for an occurence of a pattern 'pattern' in a text 'text'.
	Returns the smallest index such that there is a pattern match. Or else return -1.
	m = len(pattern)
	n = len(text)
	With O(m) preprocessing, algorithm yirlds an expected time complexity of O(m + n)
	"""
	prime = find_larger_prime(len(pattern)+1)
	remainder = (2**(len(pattern)-1)) % prime

	# compute initial remainders
	result = [None] * len(text)
	result[0] = 0
	pattern_fingerprint = 0
	for j in range(len(pattern)):
		result[0] = (2 * result[0] + int(text[j])) % prime		
		pattern_fingerprint = (2 * pattern_fingerprint + int(pattern[j])) % prime
	
	i = 0
	while i + len(pattern) <= len(text):
		if result[i] == pattern_fingerprint: # fingerprint match between pattern and substring in text
			if text[i:i+len(pattern)] == pattern: # comparison takes time O(m). where m == len(pattern)
				return i
		result[i+1] = (2 * (result[i] - remainder*int(text[i])) + int(text[i+len(pattern)])) % prime
		i += 1	
	return -1

def monte_carlo_rabin_karp_search(p, t):
	"""
	Searches for occurences of a pattern p in a text t. It prints out a list of indexes such that with high probability there is a match 
	for every index i on the list.

	This algorithm relies entirely on fingerprints to decide whether there is a match at position i. We removed the loop testing whether
	t[i,...i+m-1] = p when its fingerprints and p fingerprints are the same. This makes the algorithm much fasterl it now runs in time O(n).
	However, it also makes the algorithm incorrect:
		Two strings could have the same fingerprint without being identical. Rabin and Karp observed that this is very unlikely to happen if q is a 
		randomly chosen prime less than mn**2. The probability of the algorithm making even a single wrong decision for  particular p and t is 
		less than 2.53/n, which is small when n is large. Furthermore, the algorithm only errs by listing wrong matches, also called false positives;
		the list will include all correct matches, since a position is only rejected if the fingerprints do not agree.
	Algorithms with these two properties are called Monte-Carlo algorithms.		
	"""
	# m = p.length
	# n = t.length
	# q = randomly chosen prime number less than mn**2
	# r = 2**(m-1) mod q
	# computation of initial remainders
	# f[0] = 0
	# pfinger = 0
	# for j = 0 to m - 1:
	# 	f[0] = 2 * f[0] + t[j] mod q
	#	pfinger = 2 * pfinger + p[j] mod q
	#
	# i = 0
	# while i + m <= n:
	# 	if f[i] == pfinger:
	#		print "Match at position " + i
	#	f[i+1] = 2 * (f[i]-r*t[i]) + t[i+m] mod q
	#	i += 1		

def find_larger_prime(number):
	"""
	Given an integer, return the immediate larger prime number of the integer.
	"""
	while not is_prime(number):
		number += 1
	return number

def is_prime(n):
	"""
	Tests if number given is a prime number.
	Return True if prime, else return False.
	"""
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

if __name__ == "__main__":
	pattern = "001010"
	text = "0010110101001010011"
	print rabin_karp_search(pattern, text)
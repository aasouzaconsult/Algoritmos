##################################
### Title: Candle Residue ########
### Author: GuoChen Hou   ########
##################################

# Alexandra has n candles. He burns them one at a time and carefully collects all unburnt 
# residual wax. Out of the residual wax of exactly k (where k > 1) candles, he can roll out 
# a new candle.
# Write a program to help Alexandra find out how many candles he can burn in total, 
# given two positive integers n and k.
# The output should print the total number of candles he can burn.
# eg. n = 5, k = 3
# Total candles burnt = 7

n,k = raw_input('Enter number of candles and number of residuals to make a new candle: ').split()
n = int(n)
k = int(k)
counter = 0

while n/k != 0:
	sets = n / k
	counter += k * sets
	n = n - (k * sets) + sets
counter += n

print 'Total candles burnt =', counter
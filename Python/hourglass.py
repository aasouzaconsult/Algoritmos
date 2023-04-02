##################################
### Title: Hourglass      ########
### Author: GuoChen Hou   ########
##################################

# Write a program to read in 3 positive integers: a and b which are the durations of two 
# hourglasses, and c which is the duration you want to measure. All values are in minutes. 
# The program then determines if you can measure c exactly using the hourglasses, and if so, 
# the number of times you need to flip the two hourglasses such that the total number of 
# flips is the minimum.
# You may assume that a < b < c, and that you can only use one hourglass at a time, 
# as the desk is too small to accommodate two hourglasses at the same time.

# For example, if you have 4-minute and 7-minute hourglasses, and you want to measure 
# 28 minutes, you need only flip the 7-minute hourglass 4 times. If you want to measure 
# 29 minutes, the solution is to flip the 4-minute hourglass twice and the 7-minute 
# hourglass thrice, giving a total of 5 flips. If you want to measure 9 minutes, 
# then it is impossible to solve.

def compute_flips(hourglass_1, hourglass_2, time):
	flip = ['Impossible!', 0, 0]

	if time % hourglass_2 == 0:
		flip[2] = time / hourglass_2
		flip[0] = 'Possible!'
	else:
		quantity = time / hourglass_2
		
		while quantity != 0:
			remainder = time - (quantity*hourglass_2)
			if remainder % hourglass_1 == 0:
				flip[2] = quantity 
				flip[1] = remainder / hourglass_1
				flip[0] = 'Possible!'
				break
			quantity -= 1
	return flip

def correct_order(hourglass_1, hourglass_2):
	hourglass = [hourglass_1, hourglass_2]
	if hourglass[0] > hourglass[1]:
		temp = hourglass[0]
		hourglass[0] = hourglass[1]
		hourglass[1] = temp
	return hourglass

hourglass_1, hourglass_2, time = raw_input('Enter 3 numerical non-negative inputs: ').split()

hourglass = correct_order(hourglass_1, hourglass_2)
hourglass_1 = int(hourglass[0])
hourglass_2 = int(hourglass[1])
time = int(time)

flip = compute_flips(hourglass_1, hourglass_2, time)

print flip[0]
if flip[0] == "Possible!":
	print '%d flip(s) for %d-minute hourglass and %d flip(s) for %d-minute hourglass.' % (flip[1], hourglass_1, flip[2], hourglass_2)
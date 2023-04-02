##################################
### Title: Fortune Cookies #######
### Author: GuoChen Hou   ########
##################################

# Write a program to read in a positive integer and add up its digits repeatedly until the 
# sum is a single digit. 
# For example: 
# if the integer is 12345, then adding its digits (1 + 2 + 3 + 4 + 5) yields 15, 
# and adding its digits again (1 + 5) yields 6. Hence the answer is 6.
# Using this single digit result, print out the corresponding Fortune Cookie message 
# according to the table below:
# 1	You will have a fine capacity for the enjoyment of life.
# 2	Now is the time to try something new.
# 3	Don't let doubt and suspicion bar your progress.
# 4	Your principles mean more to you than any money or success.
# 5	Accept the next proposition you hear.
# 6	A handful of patience is worth more than a bushel of brains.
# 7	You have an active mind and a keen imagination.
# 8	You are talented in many ways.
# 9	Treat everyone as a friend.

def sum_digits(number):
	digit = 0	
	while True:
		for index in number:
			digit += int(index)
		number = str(digit)
		if digit > 9:
			digit = 0
		else:
			break
	return digit

def print_cookie(id):
	print_dict ={1:'You will have a fine capacity for the enjoyment of life.',
				 2:'Now is the time to try something new.',
				 3:'Don\'t let doubt and suspicion bar your progress',
				 4:'Your principles mean more to you than any money or success.',
				 5:'Accept the next proposition you hear.',
				 6:'A handful of patience is worth more than a bushel of brains.',
				 7:'You have an active mind and a keen imagination.',
				 8:'You are talented in many ways.',
				 9:'Treat everyone as a friend.'}

	return print_dict[id]

number_string = raw_input('Enter a positive integer:')
digit = sum_digits(number_string) # read in number as a string

print print_cookie(digit)
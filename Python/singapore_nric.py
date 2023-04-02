##################################
### Title: Singapore NRIC ########
### Author: GuoChen Hou   ########
##################################

# This program generates the check code behind every Singapore NRIC given a 7-digit NRIC number

def generateValue(nric):
	digit = []
	weight = [2,7,6,5,4,3,2]
	total = 0

	for nric_digit in nric:
		digit.append(int(nric_digit))
	for index in range(len(digit)):
		digit[index] *= weight[index]
	for index in range(len(digit)):
		total +=digit[index]

	value = 11 - (total % 11)
	return value

def generateCheckCode(value):
	check = {1:'A',
			 2:'B',
			 3:'C',
			 4:'D',
			 5:'E',
			 6:'F',
			 7:'G',
			 8:'H',
			 9:'I',
			 10:'Z',
			 11:'J'}
	return check[value]

nric = raw_input('Enter 7-digit NRIC number: ')

print 'Check code is', generateCheckCode(generateValue(nric))

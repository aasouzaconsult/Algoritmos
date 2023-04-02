##################################
###	Random die ###################
##################################

# This algorithm randomizes a fair die using a fair coin concept

import random

while True:
	read = raw_input('Type "roll" to roll a die, "quit" to exit: ')
	if read == 'quit':
		break
	elif read == 'roll':
		face = random.randint(1,2)
		
		if face == 1:
			side = random.randint(1,2)
			if side == 1:
				digit = random.randint(1,2)
				if digit == 1:
					print 'Die roll is 1'
				else:
					print 'Die roll is 2'
			else:
				digit = random.randint(1,2)	
				if digit == 1:
					print 'Die roll is 3'
				else:
					print 'Die roll is 4'
		else:
			side = random.randint(1,2)	
			if side == 1:
				digit = random.randint(1,2)
				if digit == 1:
					print 'Die roll is 5'
				else:
					print 'Die roll is 6'
			else:
				print 'Reroll'
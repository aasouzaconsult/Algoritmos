##################################
###	Shuffle a List   		   ###
##################################

# This algorithm shuffles the values in a List
# 
# for first to last
# 	swap(position1, rand_position) 

import random

random_list = [17,21,5,23,9]

def shuffle_list(a_list):
	rand_index = random.randint(0, len(a_list)-1)
	for index in range(len(a_list)):
		a_list[index], a_list[rand_index] = a_list[rand_index], a_list[index] 
	return a_list

print shuffle_list(random_list)
random.shuffle(random_list)
print random_list

counter = 0

for index in range(1000000):
	random.shuffle(random_list)
	if random_list[0] == 21:
		counter +=1

rate = float(counter / 10000)
print 'Shuffle fairness index in 1,000,000 runs: %.4f%' % rate
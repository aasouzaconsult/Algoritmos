##################################
### Title: Module Sorting ########
### Author: GuoChen Hou   ########
##################################

# This program sorts the 7-character module codes of different class sizes in ascending order
from bubble_sort import bubbleSort

f = open('module_sorting.txt', 'r')
enrol = {}
population = []

for line in f:
	module, students = line.split()
	enrol[module] = int(students)
	population.append(int(students))

bubbleSort(population)

for element in population:
	for key in enrol.keys():
		if enrol[key] == element:
			print '%s\t\t%d' % (key, element)
			break